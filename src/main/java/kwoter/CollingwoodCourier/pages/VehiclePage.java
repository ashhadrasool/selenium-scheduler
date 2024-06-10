package kwoter.CollingwoodCourier.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class VehiclePage {

    private WebDriver driver;

    public VehiclePage(WebDriver driver) {
        this.driver = driver;
    }

    private By registrationField = By.id("A21");
    private By ModelnField = By.id("A69");
    private By overnightGaragingDropdown = By.id("A205");
    private By coverDropdown = By.id("A205");
    private By carriageBasicDropdown = By.id("A371");
    private By workRadiusDropdown = By.id("A374");
    private By hazardousDropdown = By.id("A376");
    private By valueField = By.id("A181");
    private By modifiedDropdown = By.id("A19");
    private By garagingPostcodeField = By.id("A206");
    private By modifedDropdown = By.id("A19");
    private By dropsDropdown = By.id("A369");
    private By regularControctDropdown = By.id("A370");
    private By haveSignageDropdown = By.id("A373");
    private By maxValueDropdown = By.id("A372");
    private By visitSitesDropdown = By.id("A375");
    private By outsideUKDropdown = By.id("A377");

    private By clickInsuranceButton = By.id("A309");


    public void setVehicleRegistration(String vehicleRegistration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(registrationField)).sendKeys(vehicleRegistration);
        driver.findElement(registrationField).sendKeys(Keys.TAB);
        /*Alert alert = driver.switchTo().alert(); // switch to alert
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        alert.accept();*/
    }

    public void setVehicleOvernightGaraging(String vehicleOvernightGaraging) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(overnightGaragingDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(vehicleOvernightGaraging);
    }

    public void setVehicleCarriageBasic(String vehicleCarriageBasic) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(carriageBasicDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(vehicleCarriageBasic);
    }

    public void setVehicleWorkRadius(String vehicleWorkRadius) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(workRadiusDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(vehicleWorkRadius);
    }

    public void setVehicleHazardous(String vehicleHazardous) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hazardousDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(vehicleHazardous);
    }

    public void setVehicleValue(String vehicleValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(valueField)).sendKeys(vehicleValue);
    }

    public void setVehicleModifieds(String vehicleModified) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(modifiedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(vehicleModified);
    }

    public void setVehicleGaragingPostcode(String vehicleGaragingPostcode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(garagingPostcodeField)).sendKeys(vehicleGaragingPostcode);
    }

    public void setVehicleDrops(String vehicleDrops) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(dropsDropdown);
        Select dropdown = new Select(el);
        String selectedValue = "";

        int value = 0;
        try{
            value = Integer.parseInt(vehicleDrops);
        }catch (Exception e){

        }

        if(value <= 10 || vehicleDrops == "" ){
            selectedValue = "0 - 10";
        }else if (value > 10 && value <= 25){
            selectedValue = "11-25";
        }else if (value > 25 && value <= 50){
            selectedValue = "26-50";
        }else if (value > 50){
            selectedValue = "50+";
        }
        dropdown.selectByVisibleText(selectedValue);
    }

    public void setVehicleRegular(String vehicleRegular) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(regularControctDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(vehicleRegular);
    }

    public void setVehicleHaveSignage(String vehicleHaveSignage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(haveSignageDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(vehicleHaveSignage);
    }

    public void setVehicleMaxValue(String vehicleMaxValue) {

        int value = Integer.parseInt(vehicleMaxValue);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(maxValueDropdown);
        Select dropdown = new Select(el);
        String selectedValue;
        if(value <= 10000){
            selectedValue = "£0 - £10,000";
        }else{
            selectedValue = "£10,000+";
        }
        dropdown.selectByVisibleText(selectedValue);
    }

    public void setVehiclevisitSites(String vehiclevisitSites) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(visitSitesDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(vehiclevisitSites);
    }

    public void setVehicleOutsideUK(String vehicleOutsideUK) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(outsideUKDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(vehicleOutsideUK);
    }

    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickInsuranceButton)).click();
    }

    public InsurancePage clickInsurancePage() {
        clickNextButton();
        return new InsurancePage(driver);
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
