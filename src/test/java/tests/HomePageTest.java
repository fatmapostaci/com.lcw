package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.JavascriptUtils;

import static utils.TestDriver.getDriver;

public class HomePageTest extends BaseTest {

    Logger logger = LogManager.getLogger(HomePageTest.class);
    protected HomePage lcwHomePage;

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde anasayfa 3 saniye icinde yüklenmelidir")
    @Story("US01")
    @Parameters( "3000" )  //3sn
    @Test(groups = {"Smoke"})
    public void TC01_01( long duration ) {
        lcwHomePage = new HomePage(driver);

        //Sayfa tamamen yüklenene kadar beklenir
       long loadingTime = JavascriptUtils.pageLoadingTime();
       logger.info( "LCW anasayfa yüklenme süresi " + loadingTime +" milisaniye, "+ loadingTime / duration+" saniyedir");

        //Sayfanin maksimum 3 saniye icerisinde yüklendigi dogrulanir
        Assert.assertTrue(loadingTime <= duration, "Anasayfanın yüklenmesi "+duration+" saniyeden fazla sürdü");
        logger.info("Anasayfanin "+loadingTime+" saniye icinde yüklendigi dogrulandi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanici anasayfaya gittiginde search box görünür olmali")
    @Story( "US01" )
    @Test( groups = {"Smoke"} )
    public void TC01_02() {
        lcwHomePage = new HomePage( getDriver("browser"));
        // Anasayfada "arama kutusu" görünür olmalidir
        Assert.assertTrue(lcwHomePage.isSearchBoxDisplayed(),"search box bulunmadı");

    }

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde .. menüsü görünür olmali")
    @Story("US01")
    @Test( groups = {"Regression","Smoke"} )
    public void TC01_03() {
        lcwHomePage = new HomePage( getDriver("browser"));
    //    Assert.assertTrue(lcwHomePage.()));
        logger.info("Homepage'teki Category button görünürlügü test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde navigateToLoginPage buttonu görünür olmali")
    @Story("US01")
    @Test(groups = {"Regression","Smoke"})
    public void TC01_04() {
        lcwHomePage = new HomePage( getDriver("browser"));
        Assert.assertTrue(lcwHomePage.isLoginLinkDisplayed());
        logger.info("Homepage'teki navigateToLoginPage button görünürlügü test edildi");
    }
    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanici anasayfaya gittiginde menu nav listesi görünür olmali")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_11() {
        lcwHomePage = new HomePage( getDriver("browser"));
        Assert.assertTrue(lcwHomePage.isMenuNavMenuDisplayed(),"menu nav görüntülenemedi");
        logger.info("Anasayfadan menu nav listesinin görünürlüğü test edildi");
    }
    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanici anasayfaya gittiginde navigateToLoginPage buttonu görünür olmali")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_12() {
        lcwHomePage = new HomePage( getDriver("browser"));
        Assert.assertTrue(lcwHomePage.isLoginLinkDisplayed(),"navigateToLoginPage linki görüntülenemedi");
        logger.info("Anasayfadan Login sayfasının açıldığı test edildi");
    }
    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanici navigateToLoginPage linkine tıklayınca navigateToLoginPage sayfasına yönlendirilmeli")
    @Story("US01")
    @Test(groups = {"Regression"})
    public void TC01_13() {
        lcwHomePage = new HomePage( getDriver("browser"));
        LoginPage loginPage = lcwHomePage.navigateToLoginPage();
        Assert.assertTrue( loginPage.isDisplayedEmailAndPhoneElement(),"Login linki görüntülenemedi");
        logger.info("Anasayfadan Login sayfasının açıldığı test edildi");
    }
}
