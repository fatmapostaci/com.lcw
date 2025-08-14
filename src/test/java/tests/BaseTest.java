package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BasketPage;
import pages.HomePage;
import pages.LoginPage;
import pages.UserPage;
import utils.ConfigReader;
import utils.ReusableMethods;

import static utils.TestDriver.getDriver;
import static utils.TestDriver.quitDriver;

public class BaseTest {
    protected WebDriver driver;
    private final Logger logger = LogManager.getLogger(BaseTest.class);

    private HomePage lcwHomePage;
    private LoginPage loginPage;
    private UserPage userPage;
    private BasketPage basketPage;

    public HomePage lcwHomePage() {

        if(lcwHomePage==null){

            lcwHomePage = new HomePage(driver);
        }
        return lcwHomePage;
    }

    public LoginPage loginPage(){
        if(loginPage==null){
            loginPage=new LoginPage(driver);
        }
        return loginPage;
    }

    public UserPage userPage(){
        if(userPage()==null){
            userPage=new UserPage(driver);
        }
        return userPage;
    }

    public BasketPage basketPage(){
        if(basketPage==null){
            basketPage = new BasketPage(driver);
        }
        return basketPage;
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser ){
        logger.info("Driver açıldı");
        driver= getDriver(browser);
        driver.get(ConfigReader.getProperty("homepage_url"));

        //caphta çıkarsa geçmek için
        try {
            ReusableMethods.waitForElementToBeClickable(driver, By.xpath("//div//span[@class='ins-web-opt-in-reminder-close-button']"),10).click();
            logger.info("Captha geçildi");
        } catch (Exception e) {
            System.out.println("Captha bulunamadı");
        }
//        try {
//            ReusableMethods.waitForElementToBeClickable(driver, By.cssSelector("span.a-button-inner input.a-button-input"),10).click();
//            logger.info("captha geçildi");
//        } catch (Exception e) {
//            System.out.println("Dismiss button not found");
//        }
    }
    @AfterMethod
    public void tearDown(){
        logger.info(("Driver kapatıldı"));
        quitDriver();
    }


}
