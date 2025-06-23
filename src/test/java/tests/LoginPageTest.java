package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginPageTest extends BaseTest {

    Logger logger = LogManager.getLogger(HomePageTest.class);
    protected LoginPage loginPage;

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici siteye login olmalı")
    @Story( "US02" )
    @Test(groups = {"Smoke"})
    public void TC02_01(){
        driver.navigate().to(ConfigReader.getProperty("loginpage_url"));
        loginPage = new LoginPage( driver);
        Assert.assertTrue(loginPage.isUserSuccesfullyLoggedIn(),"Kullanıcı login olamadı");
    }


}
