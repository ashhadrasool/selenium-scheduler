package kwoter.CollingwoodCourier.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class QuestionsPage {

    private WebDriver driver;

    public QuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Main Driver - Proposer
    private By hasProposerConditionDisqualifiedDropdown = By.id("A324");
    private By hasProposerDeclinedDropdown = By.id("A326");
    private By hasProposerDisqualifiedDropdown = By.id("A327");

    //First Driver
    private By hasFirstDriverConditionDisqualifiedDropdown = By.id("A328");
    private By hasFirstDriverDeclinedDropdown = By.id("A329");
    private By hasFirstDriverDisqualifiedDropdown = By.id("A330");

    //Second Driver
    private By hasSecondDriverConditionDisqualifiedDropdown = By.id("A331");
    private By hasSecondDriverDeclinedDropdown = By.id("A332");
    private By hasSecondDriverDisqualifiedDropdown = By.id("A333");

    //Button
    private By nextButton = By.id("A325");


    //Main Driver - Proposer
    public void setHasProposerConditionDisqualified(String hasProposerConditionDisqualified) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hasProposerConditionDisqualifiedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(hasProposerConditionDisqualified);
    }

    public void setHasProposerDeclined(String hasProposerDeclined) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hasProposerDeclinedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(hasProposerDeclined);
    }

    public void setHasProposerDisqualified(String hasProposerDisqualified) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hasProposerDisqualifiedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(hasProposerDisqualified);
    }

    //First Driver
    public void setHasFirstDriverConditionDisqualified(String hasFirstDriverConditionDisqualified) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hasFirstDriverConditionDisqualifiedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(hasFirstDriverConditionDisqualified);
    }

    public void setHasFirstDriverDeclined(String hasFirstDriverDeclined) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hasFirstDriverDeclinedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(hasFirstDriverDeclined);
    }

    public void setFirstDriverHasFirstDriverDisqualified(String hasFirstDriverDisqualified) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hasFirstDriverDisqualifiedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(hasFirstDriverDisqualified);
    }

    //Second Driver
    public void setHasSecondDriverConditionDisqualified(String hasSecondDriverConditionDisqualified) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hasSecondDriverConditionDisqualifiedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(hasSecondDriverConditionDisqualified);
    }

    public void setHasSecondDriverDeclined(String hasSecondDriverDeclined) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hasSecondDriverDeclinedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(hasSecondDriverDeclined);
    }

    public void setHasSecondDriverDisqualified(String hasSecondDriverDisqualified) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement el = driver.findElement(hasSecondDriverDisqualifiedDropdown);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(hasSecondDriverDisqualified);
    }

    //Button
    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public AccidentPage clickAccidentPage() {
        clickNextButton();
        return new AccidentPage(driver);
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