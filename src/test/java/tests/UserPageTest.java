package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserPage;
import utils.ConfigReader;
import utils.ReusableMethods;

import static utils.TestDriver.getDriver;

public class UserPageTest extends BaseTest{


    Logger logger = LogManager.getLogger(UserPageTest.class);
    protected UserPage userPage;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici siteye navigateToLoginPage olmalı")
    @Story( "US03" )
    @Test(groups = {"Smoke"})
    public void TC03_01(){
        driver.navigate().to(ConfigReader.getProperty("loginpage_url"));
        userPage = new UserPage(getDriver("browser"));
        homePage = new HomePage(getDriver("browser"));
        loginPage = new LoginPage(getDriver("browser"));

        homePage.navigateToLoginPage();
        loginPage.login();
        ReusableMethods.waitForSeconds(4000);
        userPage.isDisplayedMyAccountButton();

    }

}
