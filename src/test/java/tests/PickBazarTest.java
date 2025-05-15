package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PickBazarPage;

import static utils.TestDriver.getDriver;

public class PickBazarTest {

    PickBazarPage page;
    Logger logger;
    @Test
    public void TC_001_01() throws InterruptedException {

        logger = LogManager.getLogger(PickBazarTest.class);
        page = new PickBazarPage(getDriver("chrome"));

        getDriver("chrome").get("http://shop.clarusway.net/");
        logger.info("http://shop.clarusway.net/   sayfası açıldı");

        Assert.assertTrue(page.isWebElementDisplayed(page.getPickBazarLogo()),"Logo görüntülenemedi");
        logger.info("PickBazar logosu görüntülendi");

        logger.info("Ana ekranda PickBazar butonuna basilir ve Home Page ekranina gidilir. ");
        page.getPickBazarLogo().click();

        Thread.sleep(3000);

    }

    @Test
    public void TC_001_02(){

    }
}
