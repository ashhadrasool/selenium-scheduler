package kwoter.CollingwoodCourier.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import kwoter.CollingwoodCourier.model.ChromeVersionsResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class Util {

    public static APIResponse callHttpGetApi(String url) throws IOException {
        return callHttpGetApi(url);
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

        String inputLine;
        StringBuffer response = new StringBuffer();

        BufferedReader reader = new BufferedReader( new InputStreamReader(
                closeableHttpResponse.getEntity().getContent()
        ));

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();
        client.close();

        apiResponse.setStatus(closeableHttpResponse.getStatusLine().getStatusCode());
        apiResponse.setResponseBody(response.toString());

        return apiResponse;
    }

    public static String findNearestVersion(String targetVersion) throws IOException {
        final String URL = "https://googlechromelabs.github.io/chrome-for-testing/known-good-versions-with-downloads.json";

        Util.APIResponse apiResponse = Util.callHttpGetApi(URL);

        ObjectMapper mapper = new ObjectMapper();

        ChromeVersionsResponse chromeVersionsResponse =
                mapper.readValue(apiResponse.getResponseBody(), ChromeVersionsResponse.class);

        ChromeVersionsResponse.Version nearestVersion = null;
        for (ChromeVersionsResponse.Version version : chromeVersionsResponse.getVersions()) {
            if (nearestVersion == null || Math.abs(compareVersions(version.getVersion(), targetVersion)) < Math.abs(compareVersions(nearestVersion.getVersion(), targetVersion))) {
                nearestVersion = version;
            }
        }

        if (nearestVersion != null) {
            return nearestVersion.getVersion();
        }
        return null;
    }

    private static int compareVersions(String v1, String v2) {
        String[] parts1 = v1.split("\\.");
        String[] parts2 = v2.split("\\.");

        for (int i = 0; i < Math.min(parts1.length, parts2.length); i++) {
            int diff = Integer.parseInt(parts1[i]) - Integer.parseInt(parts2[i]);
            if (diff != 0) {
                return diff;
            }
        }

        return parts1.length - parts2.length;
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
}
