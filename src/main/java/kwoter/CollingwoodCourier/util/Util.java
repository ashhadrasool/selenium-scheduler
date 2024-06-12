package kwoter.CollingwoodCourier.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import kwoter.CollingwoodCourier.model.ChromeVersionsResponse;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Util {

    public static APIResponse callHttpGetApi(String url) throws IOException {
        return callHttpGetApi(url, null);
    }
    public static APIResponse callHttpGetApi(String url, Map<String, String> headersMap) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        if(headersMap!=null){
            headersMap.keySet().forEach(key -> {
                request.addHeader(key, headersMap.get(key));
            });
        }
        CloseableHttpResponse closeableHttpResponse = client.execute(request);

        APIResponse apiResponse = new APIResponse();

        int status = closeableHttpResponse.getStatusLine().getStatusCode();
        String response = null;

        if(status==200){
            String inputLine;
            StringBuffer buffer = new StringBuffer();

            BufferedReader reader = new BufferedReader( new InputStreamReader(
                    closeableHttpResponse.getEntity().getContent()
            ));

            while ((inputLine = reader.readLine()) != null) {
                buffer.append(inputLine);
            }
            reader.close();
            client.close();

            response = buffer.toString();
        }
        apiResponse.setStatus(status);
        apiResponse.setResponseBody(response);

        return apiResponse;
    }

    public static List<ChromeVersionsResponse.Version> getChromeAvailableVersions() throws IOException {
        final String URL = "https://googlechromelabs.github.io/chrome-for-testing/known-good-versions-with-downloads.json";

        Util.APIResponse apiResponse = Util.callHttpGetApi(URL);

        ObjectMapper mapper = new ObjectMapper();

        ChromeVersionsResponse chromeVersionsResponse =
                mapper.readValue(apiResponse.getResponseBody(), ChromeVersionsResponse.class);

        return chromeVersionsResponse.getVersions();
    }

    public static String findNearestAvailableChromeLibraryVersion(String browserVersion) throws IOException {

        List<ChromeVersionsResponse.Version> chromeAvailableVersions = getChromeAvailableVersions();

        List<String> sortedVersions =
                chromeAvailableVersions.stream().map(v -> v.getVersion()).collect(Collectors.toList());

        ChromeVersionsResponse.Version nearestVersion =
                chromeAvailableVersions.stream().filter(v -> v.compareTo(browserVersion) <=0).
                        max(ChromeVersionsResponse.Version::compareTo).orElse(null);

        if (nearestVersion != null) {
            return nearestVersion.getVersion();
        }
        return null;
    }

    public static class APIResponse {
        private int status;
        private String responseBody;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getResponseBody() {
            return responseBody;
        }

        public void setResponseBody(String responseBody) {
            this.responseBody = responseBody;
        }
    }

    public static String getBrowserVersion(String browserPath) {
        String version = null;
        String command = browserPath + " --version";

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                version = line;
                break;
            }
            reader.close();
            process.waitFor();
            String[] chunks = version.trim().split(" ");
            return chunks[chunks.length-1];

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void downloadAndExtractChrome(String destinationFilePath) throws IOException {
        List<ChromeVersionsResponse.Version> chromeAvailableVersions = Util.getChromeAvailableVersions();
        ChromeVersionsResponse.Version version = chromeAvailableVersions.get(chromeAvailableVersions.size()-1);

        String osName = System.getProperty("os.name").toLowerCase();
        String arch = System.getProperty("os.arch").toLowerCase();

        String platform = null;
        if (osName.contains("linux")) {
            if (arch.contains("64")) {
                platform = "linux64";
            }
        } else if (osName.contains("mac")) {
            if (arch.contains("arm") || arch.contains("aarch")) {
                platform = "mac-arm64";
            } else if (arch.contains("x86_64")) {
                platform = "mac-x64";
            }
        } else if (osName.contains("windows")) {
            if (arch.contains("64")) {
                platform = "win64";
            } else {
                platform = "win32";
            }
        }
        if(platform==null){
            throw new RuntimeException("");
        }
        String finalPlatform = platform;
        ChromeVersionsResponse.Download downloadDetails = version.getDownloads().get("chrome").stream().filter(d -> d.getPlatform().equals(finalPlatform))
                .findFirst().orElseThrow(() -> new RuntimeException());

        String fileUrl = downloadDetails.getUrl();

        String tempDir = System.getProperty("java.io.tmpdir");
        String[] stringSplit = fileUrl.split("/");
        String tempFilePath = tempDir+stringSplit[stringSplit.length-1];
        System.out.println("Downloading file");
         downloadFile(fileUrl, tempDir+stringSplit[stringSplit.length-1]);
        System.out.println("Downloaded File successfully");
        Files.createDirectories(Paths.get(destinationFilePath));
        extractZip(tempFilePath, destinationFilePath);
    }

    private static void downloadFile(String fileUrl, String destinationFilePath) throws IOException {
        URL url = new URL(fileUrl);
        FileUtils.copyURLToFile(url, new File(destinationFilePath));
    }

    // Method to extract a ZIP file
    private static void extractZip(String zipFilePath, String destDir) throws IOException {
        Path destDirPath = Paths.get(destDir);
        if (!Files.exists(destDirPath)) {
            Files.createDirectories(destDirPath);
        }

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                Path filePath = destDirPath.resolve(entry.getName());
                if (!entry.isDirectory()) {
                    // If the entry is a file, extract it
                    extractFile(zipIn, filePath);
                } else {
                    // If the entry is a directory, create the directory
                    Files.createDirectories(filePath);
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }
    private static void extractFile(ZipInputStream zipIn, Path filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(filePath))) {
            byte[] bytesIn = new byte[4096];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

}
