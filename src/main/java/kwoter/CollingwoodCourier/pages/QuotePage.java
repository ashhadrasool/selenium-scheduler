package kwoter.CollingwoodCourier.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class QuotePage {

    private WebDriver driver;

    public QuotePage(WebDriver driver) {
        this.driver = driver;
    }

    //Fields and Dropdowns
    private By startDateDayDropdown = By.id("A177");
    private By startDateMontgDropdown = By.id("A178");
    private By startDateYearDropdown = By.id("A179");
    private By startTimeField = By.id("A150");
    private By policyDurationDropdown = By.id("A75");

    //Buttons
    private By clickCalculateButton = By.id("A3");
    private By clickSaveButton = By.id("A124");

    //Get Price information
    private By customerIDinfo = By.id("tzA106");
    private By quoteRefInfo = By.id("tzA152");
    private By brokerageIncludedInfo = By.id("tzA142");
    private By premiumInfo = By.id("tzA51");
    private By iptInfo = By.id("tzA50");
    private By totalInfo = By.id("tzA77");

    public void setQuoteStartDateDay(String quoteStartDateDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(startDateDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(quoteStartDateDay);
    }

    public void setQuoteStartDateMonth(String quoteStartDateMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(startDateMontgDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(quoteStartDateMonth);
    }

    public void setQuoteStartDateYear(String quoteStartDateYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(startDateYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(quoteStartDateYear);
    }

    public void setQuoteStartTime(String quoteStartTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(startTimeField)).sendKeys(quoteStartTime);
    }

    public void setQuotePolicyDuration(String quotePolicyDuration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(policyDurationDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(quotePolicyDuration);
    }

    public void clickCalculate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickCalculateButton)).click();
    }

    public void clickCalculateSave() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickSaveButton)).click();
    }

    public void clickAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        alert.accept();
    }

    //Get Price

    public String getCustomerIDinfo() {
        return driver.findElement(customerIDinfo).getText();
    }

    public String getQuoteRef() {
        return driver.findElement(quoteRefInfo).getText();
    }

    public String getBrokerageIncluded() {
        return driver.findElement(brokerageIncludedInfo).getText();
    }

    public String getPremium() {
        return driver.findElement(premiumInfo).getText();
    }

    public String getIpt() {
        return driver.findElement(iptInfo).getText();
    }

    public String getTotalClientPayable() {
        return driver.findElement(totalInfo).getText();
    }

    public boolean hasErrors(){

        try
        {
            Alert alert = driver.switchTo().alert();
            String alertMessage = driver.switchTo().alert().getText();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

    public String getErrors(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();

        return alertMessage;
    }
}
