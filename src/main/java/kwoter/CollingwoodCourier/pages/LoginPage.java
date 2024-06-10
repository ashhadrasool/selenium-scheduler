package kwoter.CollingwoodCourier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("A11");
    private By passwordField = By.id("A8");
    private By loginButton = By.id("A9");


    public void setName(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(username);
        //driver.findElement(emailField).sendKeys(username);
    }

    public void setPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
       //driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        //driver.findElement(loginButton).click();
    }

    public void logIn(String email, String password) {
        setName(email);
        setPassword(password);
        clickLoginButton();
    }

    public HomePage clickHomePage(String email, String password) {
        logIn(email,password);
        return new HomePage(driver);
    }
}
