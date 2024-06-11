package kwoter.CollingwoodCourier.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import kwoter.CollingwoodCourier.pages.LoginPage;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Base {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected By html = By.xpath("//*[@id=\"stepRiskCapture\"]");
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String POST_PATH = "/leads/storeQuoteData/";

    public static String getBrowserVersion(String browserPath) {
        String version = null;

        // Command to retrieve browser version
        String command = browserPath + " --version";

        try {
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);

            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming version information is in the first line
                version = line;
                break; // Stop after reading the first line
            }

            // Close the reader
            reader.close();

            // Wait for the process to terminate
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return version.trim().split(" ")[1];
    }

    public void setUp()  {

//        https://googlechromelabs.github.io/chrome-for-testing/known-good-versions-with-downloads.json

        String browserPath = "/Applications/Chromium.app/Contents/MacOS/Chromium";
        String browserVersion = getBrowserVersion(browserPath);
        System.out.println("browserVersion: "+ browserVersion);

        WebDriverManager.chromiumdriver().clearDriverCache();
        WebDriverManager webDriverManager = WebDriverManager.chromedriver().browserVersion("116.0.5818.0");
        webDriverManager.setup();

        System.setProperty("webdriver.chrome.driver", webDriverManager.getDownloadedDriverPath());

        ChromeOptions options = new ChromeOptions();

        options.setBinary(browserPath);
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//options.setBinary("/var/www/Selenium/chrome/linux-123.0.6312.122/chrome-linux64/chrome");
//        options.setBinary("/var/www/Selenium/chrome/linux-125.0.6422.141/chrome-linux64/chrome");
//        options.setBinary("/var/www/Selenium/chrome/linux-104.0.5112.102/chrome-linux64/chrome");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-renderer-backgrounding");
//        options.addArguments("--disable-background-timer-throttling");
//        options.addArguments("--disable-backgrounding-occluded-windows");
//        options.addArguments("--disable-client-side-phishing-detection");
//        options.addArguments("--disable-crash-reporter");
//        options.addArguments("--disable-oopr-debug-crash-dump");
//        options.addArguments("--no-crash-upload");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--disable-low-res-tiling");
//        options.addArguments("--log-level=3");
//        options.addArguments("--silent");
//
//        options.addArguments("--window-size=800x600");
//        options.addArguments("blink-settings=imagesEnabled=false");
//        options.addArguments("--disable-webgl");
//        options.addArguments("--mute-audio");
//        options.addArguments("--renderer-process-limit=2");
//        options.addArguments("--disable-site-isolation-trials");
//        options.addArguments("--disable-smooth-scrolling");
//        options.addArguments("--disable-features=TranslateUI,NotificationPresenterImpl,MediaSessionService");
//        options.addArguments("--single-process");
//        options.addArguments("--reduce-security-for-testing");
//        options.addArguments("--disable-background-networking");
//        options.addArguments("--disable-sync");

        this.driver = new ChromeDriver(options);

        this.driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        goHome();
        loginPage = new LoginPage(driver);

    }

    public void goHome(){
        driver.get("https://www.collingwoodcourier.co.uk/WD190AWP/WD190Awp.exe/CONNECT/Collingwood_Commercial?_WWREFERER_=&_WWNATION_=3");
    }

    public void tearDown() {
        driver.quit();
    }

    protected void emptyClick(){
        driver.findElement(html).click();
    }

    protected void scrollTo(By selector){
        WebElement element = driver.findElement(selector);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, element);
    }


    protected static String compileGetUrl(String schema, String domain, String path, List<NameValuePair> urlParameters){

        String url = schema + "://" + domain + path + '?';

        for (NameValuePair pair : urlParameters) {
            url += pair.getName() + "=" + pair.getValue() + "&";
        }

        url += "1=1";

        url = url.replaceAll("£ ", "");

        System.out.println(url);
        return url;
    }

    protected String compilePostUrl(String schema, String domain, String path){
        return schema + "://" + domain + path ;
    }
    /*protected void reportErrorPOST(String error, String schema, String domain, String queue_id){

        String POST_URL = compilePostUrl(schema, domain, POST_PATH);
        System.out.println(POST_URL);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(POST_URL);
        httpPost.addHeader("User-Agent", USER_AGENT);

        try{
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("error", error));
            urlParameters.add(new BasicNameValuePair("queue_id", queue_id));

            HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
            httpPost.setEntity(postParams);

            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

            System.out.println("POST Response Status:: " + httpResponse.getStatusLine().getStatusCode());

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpResponse.getEntity().getContent()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            // print result
            System.out.println(response.toString());
            httpClient.close();

        }catch (IOException e){

        }
    }*/


    protected static void reportError(String error, String schema, String domain, String queue_id) {
        try {
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            //urlParameters.add(new BasicNameValuePair("error", error));
            urlParameters.add(new BasicNameValuePair("error", URLEncoder.encode(error, StandardCharsets.UTF_8)));
            urlParameters.add(new BasicNameValuePair("quote", queue_id));

            String GET_URL = compileGetUrl(schema, domain, POST_PATH, urlParameters);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(GET_URL);
            httpGet.addHeader("User-Agent", USER_AGENT);
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            System.out.println("GET Response Status:: " + httpResponse.getStatusLine().getStatusCode());

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpResponse.getEntity().getContent()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            // print result
            System.out.println(response.toString());
            httpClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected static void reportResults(List<NameValuePair> results, String schema, String domain) throws IOException {

        String GET_URL = compileGetUrl(schema, domain, POST_PATH, results);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(GET_URL);
        httpGet.addHeader("User-Agent", USER_AGENT);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        System.out.println("GET Response Status:: " + httpResponse.getStatusLine().getStatusCode());

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        // print result
        System.out.println(response.toString());
        httpClient.close();
    }


}
