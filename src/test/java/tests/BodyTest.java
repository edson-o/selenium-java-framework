package tests;

import org.testng.annotations.Test;
import pages.BodyPage;
import pages.LoginPage;
import utils.BaseTest;
import utils.ConfigReader;

public class BodyTest extends BaseTest {

    @Test(groups = {"regression", "cart"})
    public void addProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        BodyPage bodyPage = new BodyPage(driver);

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
        loginPage.verifyHomePage();

        bodyPage.addFirstProductToCart();
        bodyPage.openCart();
        bodyPage.verifyCartIsDisplayed();
    }
}