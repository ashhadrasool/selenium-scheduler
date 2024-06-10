package kwoter.CollingwoodCourier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchClient = By.id("A12");
    private By viewClientButton =  By.id("A11");
    private By newQuoteButton =  By.id("A36");
    private By newCustomerButton =  By.id("A31");

    private By searchClientFnameCol = By.id("A18_TITRES_RECH_2");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

    public void clickFnameCol(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(searchClientFnameCol)).click();
    }

    public void setSearchClient(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchClient)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchClient)));
        driver.findElement(searchClient).clear();
        driver.findElement(searchClient).sendKeys(firstName);

    }

    public void clickViewClient() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(viewClientButton)).click();
    }

    public void selectListCustomer(String firstName, String lastName, String DOB) {

        List<WebElement> lists = driver.findElements(By.xpath("//*[@id=\"A18_TB\"]/tbody/tr"));
//        System.out.println(lists.size());

        boolean isExistCustomer = false;

        for (int i = 0; i < lists.size(); i++) {

            boolean continueScrolling = true;
            int count = 0;

            By searchFirstName = By.id("A18_" + i + "_2");
            By searchLastName = By.id("A18_" + i + "_3");
            By searchDOB = By.id("A18_" + i + "_5");

//            while (continueScrolling || count <= 100){
//                try {
//                    WebElement t = driver.findElement(searchFirstName);
//                    Duration duration = Duration.ofSeconds(1);
//                    WebDriverWait w = new WebDriverWait(driver, duration);
//                    w.until(ExpectedConditions.visibilityOfElementLocated(searchFirstName));
//                    System.out.println("Element is visible");
//                    count = 100000;
//                    continueScrolling = false;
//                } catch(java.util.NoSuchElementException n) {
//                    System.out.println("Element is invisible");
//                    scrollTable();
//                    count++;
//                }
//            }

            WebElement FNElement = driver.findElement(searchFirstName);
            WebElement LNElement = driver.findElement(searchLastName);
            WebElement DOBElement = driver.findElement(searchDOB);

            String tableFname = FNElement.getText();
            String tableLname = LNElement.getText();
            String tableDOB = DOBElement.getText();

            String messageIf= "If there is a created customer, use it and create a new quote";

//          If there is a created customer, use it and create a new quote
            if (tableFname.equals(firstName.toUpperCase()) && tableLname.equals(lastName.toUpperCase()) && tableDOB.equals(DOB) ) {
                System.out.println(messageIf);
                isExistCustomer = true;

                Actions action = new Actions(driver);
                action.doubleClick(FNElement).perform();
                break;
            }
        }

        //If no existing customers are found. Create a new one
        if(isExistCustomer == false){
            String messageNewProp= "If no existing customers are found. Create a new one";
//            System.out.println(messageNewProp);
            createCustomer();
        }

//        return messageNewProp;
    }

//    public void scrollTable() {
//        WebElement we = driver.findElement(By.xpath("html/body/div[2]"));
//        we.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_DOWN);
//    }

    public void createCustomer(){
        String messageNewProp= "Create customer";
        System.out.println(messageNewProp);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(newCustomerButton)).click();
    }

    public void createQuote(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(newQuoteButton)).click();
    }

    public ProposerPage clickProposerPage() {
        createQuote();
        return new  ProposerPage(driver);
    }
}