package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;
import pages.LoginPage;

import static utils.TestDriver.getDriver;

public class HomePageTest extends BaseTest {

    Logger logger = LogManager.getLogger(HomePageTest.class);
    protected HomePage lcwHomePage;

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Anasayfa 15 saniye icinde yüklenmelidir")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_01( ) {
        lcwHomePage = new HomePage(driver);
        long duration = 15000;
        long actualDuration = lcwHomePage.pageLoadingTime();
        Assert.assertTrue(actualDuration <= duration, "Sayfa yüklenme süresi fazla: " + actualDuration + " ms");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("UI bileşen testi - Searchbox görünür olmali")
    @Story( "US01" )
    @Test( groups = {"Regression"} )
    public void TC01_02() {
        lcwHomePage = new HomePage( getDriver("browser"));
        Assert.assertTrue(lcwHomePage.isSearchBoxDisplayed(),"search box bulunmadı");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("UI bileşen testi - Login buttonu görünür olmali")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_03() {
        lcwHomePage = new HomePage( getDriver("browser"));
        Assert.assertTrue(lcwHomePage.isLoginLinkDisplayed());
        logger.info("Homepage'teki Giriş butonunun görünürlügü test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("UI bileşen testi - Navigation menu listesi görünür olmali")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_04() {
        lcwHomePage = new HomePage( getDriver("browser"));
        Assert.assertTrue(lcwHomePage.isNavMenuDisplayed(),"Navigation menü bar görüntülenemedi");
        logger.info("Homepage'teki Navigation Menu listesinin görünürlüğü test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("UI bileşen testi - Sepet buttonu görünür olmali")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_05() {
        lcwHomePage = new HomePage( getDriver("browser"));
        Assert.assertTrue(lcwHomePage.isBasketLinkDisplayed()," sepet linki görüntülenemedi");
        logger.info("Homepage'teki Sepetim butonunun görünürlügü test edildi ");
    }
    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("UI bileşen testi - Footer'daki iletişim/kargo bilgileri\n")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_06() {
        lcwHomePage = new HomePage( getDriver("browser"));
        Assert.assertTrue(lcwHomePage.isFooterContentDisplayed()," Footer Content görüntülenemedi");
        logger.info("Homepage'teki Footer alanının görünürlügü test edildi");
    }
    //****************************************UI Bileşen Testi Sonu**************************************//

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Giriş Yap linkine tıklanınca login sayfasına yönlendirilmeli")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_07() {
        lcwHomePage = new HomePage( getDriver("browser"));
        LoginPage loginPage = lcwHomePage.goToLoginPage();
        Assert.assertTrue( loginPage.isDisplayedEmailAndPhoneElement(),"Giriş sayfası görüntülenemedi");
        logger.info("Anasayfadan Login sayfasının açıldığı test edildi");
    }
    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sepetim linkine tıklanınca Sepet sayfasına yönlendirilmeli")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_08() {
        lcwHomePage = new HomePage( getDriver("browser"));
        BasketPage basketPage = lcwHomePage.goToBasket();
        Assert.assertTrue( basketPage.isCurrentUrlBasket(),"sepet sayfası görüntülenemedi");
        logger.info("Anasayfadan Sepet sayfasının açıldığı test edildi");
    }

}
