package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LCWHomePage;
import utils.JavascriptUtils;

public class LCWHomeTest extends BaseTest {

    Logger logger = LogManager.getLogger(LCWHomeTest.class);
    protected LCWHomePage lcwHomePage;

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde anasayfa 3 saniye icinde yüklenmelidir")
    @Story("US01")
    @Parameters( "3000" )  //3sn
    @Test(groups = {"Smoke"})
    public void TC01_01( long duration ) {
        lcwHomePage = new LCWHomePage(driver);

        //Sayfa tamamen yüklenene kadar beklenir
       long loadingTime = JavascriptUtils.pageLoadingTime();
       logger.info( "LCW anasayfa yüklenme süresi " + loadingTime +" milisaniye, "+ loadingTime / duration+" saniyedir");

        //Sayfanin maksimum 3 saniye icerisinde yüklendigi dogrulanir
        Assert.assertTrue(loadingTime <= duration, "Anasayfanın yüklenmesi "+duration+" saniyeden fazla sürdü");
        logger.info("Anasayfanin "+duration+" saniye icinde yüklendigi dogrulandi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde search box görünür olmali")
    @Story( "US01" )
    @Test( groups = {"Smoke"} )
    public void TC01_02() {
        lcwHomePage = new LCWHomePage(driver);
        // Anasayfada "arama kutusu" görünür olmalidir
        Assert.assertTrue(lcwHomePage.isWebElementDisplayed(lcwHomePage.getSearchBox()));
        logger.info("Homepage'teki search box'in görünürlügü test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde kategori menüsü görünür olmali")
    @Story("US01")
    @Test( groups = {"Regression","Smoke"} )
    public void TC01_03() {
        lcwHomePage = new LCWHomePage(driver);
        Assert.assertTrue(lcwHomePage.isWebElementDisplayed(lcwHomePage.getCategoryAllButton()));
        logger.info("Homepage'teki Category button görünürlügü test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde login buttonu görünür olmali")
    @Story("US01")
    @Test(groups = {"Regression","Smoke"})
    public void TC01_04() {
        lcwHomePage = new LCWHomePage(driver);
        Assert.assertTrue(lcwHomePage.isWebElementDisplayed(lcwHomePage.getLoginButton()));
        logger.info("Homepage'teki login button görünürlügü test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanici anasayfaya gittiginde promotion slides görünür olmali")
    @Story("US01")
    @Test(groups = "Regression")
    public void TC01_05() {
        lcwHomePage = new LCWHomePage(driver);
        Assert.assertTrue(lcwHomePage.isWebElementDisplayed(lcwHomePage.getPromotionSlides()));
        logger.info("Homepage'teki Promotion slides görünürlügü test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanici anasayfaya gittiginde language-country button görünür olmali")
    @Story("US01")
    @Test(groups = "Regression")
    public void TC01_06() {
        lcwHomePage = new LCWHomePage(driver);
        Assert.assertTrue(lcwHomePage.isWebElementDisplayed(lcwHomePage.getLanguageButton()));
        logger.info("Homepage'teki language-Country button görünürlügü test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde search box tiklanabilir olmali")
    @Story("US01")
    @Test(groups = {"Regression","Smoke"})
    public void TC01_07() {
        lcwHomePage = new LCWHomePage(driver);
        Assert.assertTrue(lcwHomePage.isElementClickable(lcwHomePage.getSearchBox()));
        logger.info("Homepage'teki search box button'in tiklanabilir oldugu test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde Category All button tiklanabilir olmali")
    @Story("US01")
    @Test(groups = {"Regression","Smoke"})
    public void TC01_08() {
        lcwHomePage = new LCWHomePage(driver);
        Assert.assertTrue(lcwHomePage.isElementClickable(lcwHomePage.getCategoryAllButton()));
        logger.info("Homepage'teki Category All button'in tiklanabilir oldugu test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanici anasayfaya gittiginde Login button tiklanabilir olmali")
    @Story("US01")
    @Test(groups = {"Regression","Smoke"})
    public void TC01_09() {
        lcwHomePage = new LCWHomePage(driver);
        Assert.assertTrue(lcwHomePage.isElementClickable(lcwHomePage.getLoginButton()));
        logger.info("Homepage'teki Login button'in tiklanabilir oldugu test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanici anasayfaya gittiginde promotion slides tiklanabilir olmali")
    @Story("US01")
    @Test(groups = "Regression")
    public void TC01_10() {
        lcwHomePage = new LCWHomePage(driver);
        Assert.assertTrue(lcwHomePage.isElementClickable(lcwHomePage.getPromotionSlides()));
        logger.info("Homepage'teki Promotion slides'in tiklanabilir oldugu test edildi");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanici anasayfaya gittiginde Language-Country button tiklanabilir olmali")
    @Story("US01")
    @Test(groups = "Regression")
    public void TC01_11() {
        lcwHomePage = new LCWHomePage(driver);
        Assert.assertTrue(lcwHomePage.isElementClickable(lcwHomePage.getLanguageButton()));
        logger.info("Anasayfadaki Language-Country button'in tiklanabilir oldugu test edildi");
    }
}
