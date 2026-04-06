package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "login"})
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        loginPage.verifyHomePage();
    }

    @Test(groups = {"regression", "login"})
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "locked_out_user");
        loginPage.verifyErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }
}