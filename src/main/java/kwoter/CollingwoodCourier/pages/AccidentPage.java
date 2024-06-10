package kwoter.CollingwoodCourier.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AccidentPage {

    private WebDriver driver;

    public AccidentPage(WebDriver driver) {
        this.driver = driver;
    }


    //Claims
    private By haveClaimsDropdown = By.id("A122");
//    private By haveConvDropdown_yes = By.xpath("/html/body/div[1]/form/table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/table/tbody/tr[2]/td/div[2]/a/img");
    private By claimDecriptionDropdown = By.id("A100");
    private By claimDateDayDropdown = By.id("A98");
    private By claimDateMontDropdown = By.id("A97");
    private By claimDateYearDropdown = By.id("A96");
    private By claimCostField = By.id("A99");
    private By claimDriverDropdown = By.id("A4");
    private By claimSaveButton = By.id("A101");
    private By addClaimButton = By.id("A165");


    //Convictions
    private By convictionsCodeDropdown = By.id("A115");
    private By convictionsDateDayDropdown = By.id("A109");
    private By convictionsDateMontDropdown = By.id("A110");
    private By convictionsDateYearDropdown = By.id("A111");
    private By convictionsPointsDropdown = By.id("A117");
    private By convictionsMonthBanDropdown = By.id("A119");
    private By convictionsPendingCheck = By.id("A5_1");
    private By convictionsFineAmounthField = By.id("A113");
    private By convictionsSelectDriverDropdown = By.xpath("//html/body/form/table/tbody/tr[2]/td[1]/table/tbody/tr/td/table/tbody/tr[28]/td[2]/table/tbody/tr/td/select");
    private By convictionsSaveButton = By.id("A116");
    private By haveConvDropdown = By.id("A123");
    private By addConvButton = By.id("A163");


    //one button "Yes" for convictions and claim
    private By addNowButon_yes = By.id("A1");
    private By clickVehicleButton = By.id("A308");


    //Claims

    public void setNoClaim() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(haveClaimsDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText("No");
    }

    public void setHaveClaim(String haveClaim) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(haveClaimsDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(haveClaim);
        clickSaveYes();
    }

    public void clickAddClaim(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(addClaimButton)).click();
    }

    public void setDescriptionClaim(String descriptionClaim) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(claimDecriptionDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(descriptionClaim);
    }

    public void setDateDayClaim(String dateDayClaim) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(claimDateDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(dateDayClaim);
    }

    public void setDateMonthClaim(String dateMonthClaim) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(claimDateMontDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(dateMonthClaim);
    }

    public void setDateyearClaim(String dateyearClaim) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(claimDateYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(dateyearClaim);
    }

    public void setCostClaim(String costClaim) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(claimCostField)).sendKeys(costClaim);
    }

    public void setDriverClaim(String driverClaim) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(claimDriverDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(driverClaim);
    }

    public void clickSaveClaim(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(claimSaveButton)).click();
        clickSaveYes();
    }

    //Convictions

    public void setNoConvictions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(haveConvDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText("No");
    }

    public void setHaveConviction(String haveConv) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(haveConvDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(haveConv);
        clickSaveYes();
    }

    public void clickAddConviction(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(addConvButton)).click();
    }

    public void setConvictionCode(String convictionsictionCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(convictionsCodeDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(convictionsictionCode);
    }

    public void setConvictionDateDay(String convictionsictionDateDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(convictionsDateDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(convictionsictionDateDay);
    }

    public void setConvictionDateMonth(String convictionsictionDateMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(convictionsDateMontDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(convictionsictionDateMonth);
    }

    public void setConvictionDateYear(String convictionsictionDateYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(convictionsDateYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(convictionsictionDateYear);
    }

    public void setConvictionPenalty(String convictionsictionPenalty) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(convictionsPointsDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(convictionsictionPenalty);
    }

    public void setConvictionMonthBan(String convictionsictionMonthBan) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(convictionsMonthBanDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(convictionsictionMonthBan);
    }

    public void setConvictionPending(Boolean convictionsictionPending) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        if(convictionsictionPending == true){
            driver.findElement(convictionsPendingCheck).click();
        }
    }

    public void setConvictionFineAmount(String convictionsictionFineAmount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(convictionsFineAmounthField)).sendKeys(convictionsictionFineAmount);
    }

    public void setConvictionName(String convictionsictionName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(convictionsSelectDriverDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(convictionsictionName);
    }

    public void clickSaveConviction(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(convictionsSaveButton)).click();
        clickSaveYes();
    }

    public void clickSaveYes(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(addNowButon_yes)).click();
    }

    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(clickVehicleButton)).click();
    }

    public VehiclePage clickVehiclePage() {
        clickNextButton();
        return new VehiclePage(driver);
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
