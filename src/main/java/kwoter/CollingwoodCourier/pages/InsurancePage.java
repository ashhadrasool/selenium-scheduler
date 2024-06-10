package kwoter.CollingwoodCourier.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class InsurancePage {

    private WebDriver driver;

    public InsurancePage(WebDriver driver) {
        this.driver = driver;
    }

    private By insurarField = By.id("A86");
    private By policyNoField = By.id("A87");
    private By registrationNoField = By.id("A88");
    private By expiryDateField = By.id("A89");
    private By NcdDropdown = By.id("A6");
//    private By receiveNCDRadio = By.id("A210_1);
    private By dateNcdReceivedField = By.id("A212");

    private By receiveNcdRadio_Yes = By.id("A210_2");
    private By receiveNcdRadio_No = By.id("A210_1");
    private By clickQuoteButton = By.id("A310");


    public void setInsuranceInsurer(String insuranceInsurer) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(insurarField)).sendKeys(insuranceInsurer);
    }

    public void setInsurancePolicyNo(String insurancePolicyNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(policyNoField)).sendKeys(insurancePolicyNo);
    }

    public void setInsuranceRegistrationNo(String insuranceRegistrationNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(registrationNoField)).sendKeys(insuranceRegistrationNo);
    }

    public void setInsuranceExpiryDater(String insuranceExpiryDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(expiryDateField)).sendKeys(insuranceExpiryDate);
    }

    public void setInsuranceNcd(String insuranceNcd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(NcdDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(insuranceNcd);
    }

    public void setInsuranceProfNcd(String insuranceProfNcd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        if(insuranceProfNcd.contains("Yes") == true){
            driver.findElement(receiveNcdRadio_Yes).click();
        } else{
            driver.findElement(receiveNcdRadio_No).click();
        }
    }

    public void setInsuranceDateNcd(String insuranceDateNcd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(dateNcdReceivedField)).sendKeys(insuranceDateNcd);
    }

    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickQuoteButton)).click();
    }

    public QuotePage clickQuotePage() {
        clickNextButton();
        return new QuotePage(driver);
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
