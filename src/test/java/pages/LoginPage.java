package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;


    private final By userInput = By.id("user-name");
    private final By passInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By appLogo = By.className("app_logo");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userInput));
        driver.findElement(userInput).sendKeys(username);
        driver.findElement(passInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void verifyHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(appLogo));
        Assert.assertTrue(driver.findElement(appLogo).isDisplayed(), "App logo is not displayed");
    }

    public void verifyErrorMessage(String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        String actual = driver.findElement(errorMessage).getText();
        Assert.assertEquals(actual, expectedMessage, "Error message does not match");
    }

}