package kwoter.CollingwoodCourier.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProposerPage {

    private WebDriver driver;
    public ProposerPage(WebDriver driver) {
        this.driver = driver;
    }

    //Fields and Dropdowns
    private By limitedCompanyCheck = By.id("A359_1");
    private By limitedCompanyHiden = By.id("czA360");
    private By policyTypeDropdown = By.id("A4");
    private By coverTypeDropdown = By.id("A45");
    private By classOfUseDropdown = By.id("A384");
    private By businessTypeDropdown = By.id("A204");
    private By telephoneNumberField = By.id("A9");
    private By mobileNumberField = By.id("A12");
    private By emailField = By.id("A10");
    private By occupationDropdown = By.id("A242");
    private By employmentStatusDropDown = By.id("A244");
    private By secondaryOccupationDropdown = By.xpath("//html/body/table/tbody/tr/td/div/form/div[2]/table/tbody/tr[3]/td[1]/table/tbody/tr[2]/td/table[1]/tbody/tr/td/div/table/tbody/tr[17]/td[2]/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/select");
    private By DOBdayDropdown = By.id("A80");
    private By DOBmonthDropdown = By.id("A174");
    private By DOByearDropdown = By.id("A175");
    private By vatRegistrationField_Yes = By.id("A201_1");
    private By vatRegistrationField_No = By.id("A201_2");
    private By companyNameField = By.id("A360");
    private By companyRegistrationNumberField = By.id("A361");
    private By titleDropdown = By.id("A13");
    private By firstNameField = By.id("A8");
    private By lastNameField = By.id("A11");
    private By proposerBuildingNField = By.id("A44");
    private By proposerPostoceField = By.id("A42");
    private By addres1Field = By.id("A40");
    private By addres2Field = By.id("A39");
    private By townField = By.id("A38");
    private By countyField = By.id("A36");
    private By postcodeFeld = By.id("A35");

    //Button
    private By nextButton = By.id("A306");


    public void setPolicyLimitedCompany(String PolicyHolder) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean isDisplayed = driver.findElement(companyNameField).isDisplayed();
        boolean isEnabled = driver.findElement(companyNameField).isEnabled();

        if(PolicyHolder == "1" && isDisplayed == false && isEnabled == true) {
            WebElement el = driver.findElement(limitedCompanyCheck);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].removeAttribute('disabled')",el);
            driver.findElement(limitedCompanyCheck).click();
        }
    }

    public void setPolicyType(String policyType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(policyTypeDropdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
            Select dropdown = new Select(el);
            dropdown.selectByVisibleText(policyType);
    }

    public void setCoverType(String coverType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(coverTypeDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(coverType);
    }

    public void setClassOfUse(String classOfUse) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(classOfUseDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(classOfUse);
    }

    public void setBusinessType(String businessType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement el = driver.findElement(businessTypeDropdown);
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(businessType);
    }

    public void setCompantyName(String companyName, String PolicyHolder) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean isEnabled = driver.findElement(companyNameField).isEnabled();
        if(PolicyHolder == "1" && isEnabled == true) {
            wait.until(ExpectedConditions.elementToBeClickable(companyNameField)).sendKeys(companyName);
        }
    }
    public void setCompanyRegistrationNumber(String companyRegistrationNumber, String PolicyHolder) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean isEnabled = driver.findElement(companyNameField).isEnabled();

        if(PolicyHolder == "1" && isEnabled == true) {
            wait.until(ExpectedConditions.elementToBeClickable(companyRegistrationNumberField)).sendKeys(companyRegistrationNumber);
        }
    }

    public void setTelephoneNumber(String telephoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(telephoneNumberField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(telephoneNumberField)).sendKeys(telephoneNumber);
    }

    public void setMobileNumber(String mobileNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(mobileNumberField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(mobileNumberField)).sendKeys(mobileNumber);
    }

    public void setEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(emailField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
    }

    public void setOccupation(String occupation) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(occupationDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(occupation);
    }

    public void setEmploymentStatus(String employmentStatus) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(employmentStatusDropDown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(employmentStatus);
    }

    public void setDOBday(String DOBday) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(DOBdayDropdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(DOBday);
    }

    public void setDOBmonth(String DOBmonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(DOBmonthDropdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(DOBmonth);
    }

    public void setDOByear(String DOByear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(DOByearDropdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(DOByear);
    }

    public void setSecondaryOccupation(String secondaryOccupation) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        WebElement el = driver.findElement(secondaryOccupationDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondaryOccupation);
    }

    public void setVatRegistration(String vatRegistration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        if(vatRegistration == "Yes") {
            driver.findElement(vatRegistrationField_Yes).click();
        }else{
            driver.findElement(vatRegistrationField_No).click();
        }
    }

    public void setTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(titleDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(title);
    }

    public void setFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstNameField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        driver.findElement(firstNameField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(lastNameField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        driver.findElement(lastNameField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).sendKeys(lastName);
    }

    public void setProposerBuildingNumber(String proposerBuildingNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(proposerBuildingNField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(proposerBuildingNField)).sendKeys(proposerBuildingNumber);
    }

    public void setProposePostcode(String proposePostcode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(proposerPostoceField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(proposerPostoceField)).sendKeys(proposePostcode);
    }

    public void setAddress1(String address1){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(addres1Field).clear();
        wait.until(ExpectedConditions.elementToBeClickable(addres1Field)).sendKeys(address1);
    }

    public void setAddress2(String address2){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(addres2Field).clear();
        wait.until(ExpectedConditions.elementToBeClickable(addres2Field)).sendKeys(address2);
    }

    public void setTown(String town){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(townField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(townField)).sendKeys(town);
    }

    public void setCounty(String county){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(countyField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(countyField)).sendKeys(county);
    }

    public void setPostcode(String postcode){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(postcodeFeld).clear();
        wait.until(ExpectedConditions.elementToBeClickable(postcodeFeld)).sendKeys(postcode);
    }

    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public DriversPage clickDriversPage() {
        clickNextButton();
        return new  DriversPage(driver);
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
