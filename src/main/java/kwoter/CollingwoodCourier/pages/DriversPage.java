package kwoter.CollingwoodCourier.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DriversPage {

    private WebDriver driver;

    public DriversPage(WebDriver driver) {
        this.driver = driver;
    }

    //Dropdowns and fields

    //Main Driver
    private By licenseTypeDropdown = By.id("A188");
    private By drivingLicenseNoField = By.id("A112");
    private By dateTestPassedDayDropdown = By.id("A216");
    private By dateTestPassedMonthDropdown = By.id("A217");
    private By dateTestPassedYearDropdown = By.id("A218");
    private By ukResidentFromDayDropdown = By.id("A220");
    private By ukResidentFromMonthDropdown = By.id("A221");
    private By ukResidentFromYearDropdown = By.id("A222");
    private By occupationDriversDropdown = By.xpath("//html/body/table/tbody/tr/td/div/form/div[2]/table/tbody/tr[3]/td[1]/table/tbody/tr[2]/td/table[2]/tbody/tr/td/table/tbody/tr[19]/td[2]/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/select");
    private By employmentStatusDwopdown = By.id("A187");
    private By secOccupationDriversDropdown = By.xpath("//html/body/table/tbody/tr/td/div/form/div[2]/table/tbody/tr[3]/td[1]/table/tbody/tr[2]/td/table[2]/tbody/tr/td/table/tbody/tr[24]/td[2]/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/select");

    //Driver 1
    private By firstDriverTitleDropdown = By.id("A256");
    private By firstDriverFirstNameField = By.id("A254");
    private By firstDriverLastNameField = By.id("A253");
    private By firstDriverDobDayDropdown = By.id("A250");
    private By firstDriverDobMonthDropdown = By.id("A251");
    private By firstDriverDobYearDropdown = By.id("A252");
    private By firstDriverLicenseTypeDropdown = By.id("A257");
    private By firstDriverDrivingLicenseNoField = By.id("A255");
    private By firstDriverDateTestPassedDayDropdown = By.id("A263");
    private By firstDriverDateTestPassedMonthDropdown = By.id("A264");
    private By firstDriverDateTestPassedYearDropdown = By.id("A265");
    private By firstDriverUkResidentFromDayDropdown = By.id("A267");
    private By firstDriverUkResidentFromMonthDropdown = By.id("A268");
    private By firstDriverUkResidentFromYearDropdown = By.id("A269");
    private By firstDriverOccupationDriversDropdown = By.id("A259");
    private By firstDriverBysubessTypeDwopdown = By.id("A260");
    private By firstDriverEmploymentStatusDwopdown = By.id("A261");
    private By firstDriverRelationshipDropdown = By.id("A295");
    private By firstDriverSecOccupationDriversDropdown = By.id("A367");

    //Driver 2
    private By secondDriverTitleDropdown = By.id("A280");
    private By secondDriverFirstNameField = By.id("A278");
    private By secondDriverLastNameField = By.id("A277");
    private By secondDriverDobDayDropdown = By.id("A274");
    private By secondDriverDobMonthDropdown = By.id("A275");
    private By secondDriverDobYearDropdown = By.id("A276");
    private By secondDriverLicenseTypeDropdown = By.id("A281");
    private By secondDriverDrivingLicenseNoField = By.id("A279");
    private By secondDriverDateTestPassedDayDropdown = By.id("A287");
    private By secondDriverDateTestPassedMonthDropdown = By.id("A288");
    private By secondDriverDateTestPassedYearDropdown = By.id("A289");
    private By secondDriverUkResidentFromDayDropdown = By.id("A291");
    private By secondDriverUkResidentFromMonthDropdown = By.id("A292");
    private By secondDriverUkResidentFromYearDropdown = By.id("A293");
    private By secondDriverOccupationDriversDropdown = By.id("A283");
    private By secondDriverBysubessTypeDwopdown = By.id("A284");
    private By secondDriverEmploymentStatusDwopdown = By.id("A285");
    private By secondDriverRelationshipDropdown = By.id("A296");
    private By secondDriverSecOccupationDriversDropdown = By.id("A368");

    //Buttons and Links
    private By fromBurthCheck = By.id("A223_1");
    private By removeButton = By.id("tzA191"); //link Remove
    private By nextQuestionsButton = By.xpath("//html/body/table/tbody/tr/td/div/form/div[2]/table/tbody/tr[3]/td[1]/table/tbody/tr[2]/td/table[2]/tbody/tr/td/table/tbody/tr[66]/td[2]/input");


    //Main Driver
    public void setProposerLicenseType(String licenseType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(licenseTypeDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(licenseType);
    }

    public void setProposerDrivingLicenseNo(String drivingLicenseNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(drivingLicenseNoField).clear();
        wait.until(ExpectedConditions.elementToBeClickable(drivingLicenseNoField)).sendKeys(drivingLicenseNo);
    }

    public void setProposerdateTestPassedDay(String dateTestPassedDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(dateTestPassedDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(dateTestPassedDay);
    }

    public void setProposerdateTestPassedMonth(String dateTestPassedMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(dateTestPassedMonthDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(dateTestPassedMonth);
    }

    public void setProposerdateTestPassedYear(String dateTestPassedYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(dateTestPassedYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(dateTestPassedYear);
    }

    public void setProposerUKResidentFromDay(String ukResidentFromDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(ukResidentFromDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(ukResidentFromDay);
    }

    public void setProposerUKResidentFromMonth(String ukResidentFromMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(ukResidentFromMonthDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(ukResidentFromMonth);
    }

    public void setProposerUKResidentFromYear(String ukResidentFromYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(ukResidentFromYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(ukResidentFromYear);
    }

    //First Druver
    public void setFirstDriverTitle(String firstDriverTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverTitleDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverTitle);
    }

    public void setFirstDriverFirstName(String firstDriverFirstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(firstDriverFirstNameField)).sendKeys(firstDriverFirstName);
    }

    public void setFirstDriverLastName(String firstDriverLastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(firstDriverLastNameField)).sendKeys(firstDriverLastName);
    }

    public void setFirstDriverDobDay(String firstDriverDobDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverDobDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverDobDay);
    }

    public void setFirstDriverDobMonth(String firstDriverDobMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverDobMonthDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverDobMonth);
    }

    public void setFirstDriverDobYear(String firstDriverDobYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverDobYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverDobYear);
    }

    public void setFirstDriverLicenseType(String firstDriverLicenseType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverLicenseTypeDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverLicenseType);
    }

    public void setFirstDriverDrivingLicenseNo(String firstDriverDrivingLicenseNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(firstDriverDrivingLicenseNoField)).sendKeys(firstDriverDrivingLicenseNo);
    }

    public void setFirstDriverDateTestPassedDay(String firstDriverDateTestPassedDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverDateTestPassedDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverDateTestPassedDay);
    }

    public void setFirstDriverDateTestPassedYear(String firstDriverDateTestPassedMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverDateTestPassedYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverDateTestPassedMonth);
    }

    public void setFirstDriverDateTestPassedMonth(String firstDriverDateTestPassedYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverDateTestPassedMonthDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverDateTestPassedYear);
    }

    public void setFirstDriverUkResidentFromDay(String firstDriverUkResidentFromDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverUkResidentFromDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverUkResidentFromDay);
    }

    public void setFirstDriverUkResidentFromMonth(String firstDriverUkResidentFromMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverUkResidentFromMonthDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverUkResidentFromMonth);
    }

    public void setFirstDriverUkResidentFromYear(String firstDriverUkResidentFromYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverUkResidentFromYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverUkResidentFromYear);
    }

    public void setFirstDriverOccupationDrivers(String firstDriverOccupationDrivers) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverOccupationDriversDropdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverOccupationDrivers);
    }

    public void setFirstDriverBusinessType(String firstDriverBusinessType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverBysubessTypeDwopdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverBusinessType);
    }

    public void setFirstDriverEmploymentStatus(String firstDriverEmploymentStatus) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverEmploymentStatusDwopdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverEmploymentStatus);
    }

    public void setFirstDriverRelationship(String firstDriverRelationship) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverRelationshipDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverRelationship);
    }

    public void setFirstDriverSecOccupationDrivers(String firstDriverSecOccupationDrivers) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(firstDriverSecOccupationDriversDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(firstDriverSecOccupationDrivers);
    }


    //Second 2
    public void setSecondDriverTitle(String secondDriverTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverTitleDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverTitle);
    }

    public void setSecondDriverFirstName(String secondDriverFirstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(secondDriverFirstNameField)).sendKeys(secondDriverFirstName);
    }

    public void setSecondDriverLastName(String secondDriverLastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(secondDriverLastNameField)).sendKeys(secondDriverLastName);
    }

    public void setSecondDriverDobDay(String secondDriverDobDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverDobDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverDobDay);
    }

    public void setSecondDriverDobMonth(String secondDriverDobMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverDobMonthDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverDobMonth);
    }

    public void setSecondDriverDobYear(String secondDriverDobYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverDobYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverDobYear);
    }

    public void setSecondDriverLicenseType(String secondDriverLicenseType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverLicenseTypeDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverLicenseType);
    }

    public void setSecondDriverDrivingLicenseNo(String secondDriverDrivingLicenseNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(secondDriverDrivingLicenseNoField)).sendKeys(secondDriverDrivingLicenseNo);
    }

    public void setSecondDriverDateTestPassedDay(String secondDriverDateTestPassedDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverDateTestPassedDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverDateTestPassedDay);
    }

    public void setSecondDriverDateTestPassedYear(String secondDriverDateTestPassedMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverDateTestPassedYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverDateTestPassedMonth);
    }

    public void setSecondDriverDateTestPassedMonth(String secondDriverDateTestPassedYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverDateTestPassedMonthDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverDateTestPassedYear);
    }

    public void setSecondDriverUkResidentFromDay(String secondDriverUkResidentFromDay) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverUkResidentFromDayDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverUkResidentFromDay);
    }

    public void setSecondDriverUkResidentFromMonth(String secondDriverUkResidentFromMonth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverUkResidentFromMonthDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverUkResidentFromMonth);
    }

    public void setSecondDriverUkResidentFromYear(String secondDriverUkResidentFromYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverUkResidentFromYearDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverUkResidentFromYear);
    }

    public void setSecondDriverOccupationDrivers(String secondDriverOccupationDrivers) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverOccupationDriversDropdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverOccupationDrivers);
    }

    public void setSecondDriverBusinessType(String secondDriverBusinessType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverBysubessTypeDwopdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')",el);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverBusinessType);
    }

    public void setSecondDriverEmploymentStatus(String secondDriverEmploymentStatus) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverEmploymentStatusDwopdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverEmploymentStatus);
    }

    public void setSecondDriverRelationship(String secondDriverRelationship) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverRelationshipDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverRelationship);
    }

    public void setSecondDriverSecOccupationDrivers(String secondDriverSecOccupationDrivers) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(secondDriverSecOccupationDriversDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(secondDriverSecOccupationDrivers);
    }

    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nextQuestionsButton)).click();
    }

    public QuestionsPage clickQuestionsPage() {
        clickNextButton();
        return new QuestionsPage(driver);
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
