package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BodyPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BodyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By firstItemAddToCart = By.cssSelector(".inventory_item button");
    private final By shoppingCart = By.className("shopping_cart_link");

    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstItemAddToCart));
        driver.findElement(firstItemAddToCart).click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCart));
        driver.findElement(shoppingCart).click();
    }

    public void verifyCartIsDisplayed() {
        wait.until(ExpectedConditions.urlContains("cart"));
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page is not displayed");
    }
}