package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.ComputersAndAccessoriesPage;
import utils.ConfigReader;

import java.time.Duration;

public class FilterTest extends BaseTest {

    private final Logger logger = LogManager.getLogger(FilterTest.class);
    protected ComputersAndAccessoriesPage compAndAccPage;
    protected CategoryPage categoryPage;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUpPages() {
        categoryPage = new CategoryPage(driver);
        compAndAccPage = new ComputersAndAccessoriesPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("User should see the 'Sort by: Featured' menu.")
    @Story("US04")
    @Test(groups = {"Regression"})
    public void shouldDisplaySortByFeaturedOption() {
        categoryPage.allCategoryClick(driver);
        logger.info("Clicked on the 'All' button at the top of the homepage.");

        wait.until(driver -> categoryPage.isElectronicsSubMenuVisible());
        categoryPage.clickElectronicsSubMenu();
        logger.info("Clicked on the 'Electronics' sub-category.");

        wait.until(driver -> categoryPage.isComputerAndAccessoriesMenuVisible());
        categoryPage.clickComputerAndAccessoriesMenu();
        logger.info("Clicked on the 'Computers & Accessories' category.");

        Assert.assertTrue(compAndAccPage.sortByButtonisVisible(), "'Sort by: Featured' button is not visible.");
        logger.info("'Sort by: Featured' should be visible on the right side of the page.");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Products should be sorted from low to high when 'Price: Low to High' is selected.")
    @Story("US04")
    @Test(groups = {"Regression", "Smoke"})
    public void shouldSortItemsByLowToHighPrice() {
        driver.get(ConfigReader.getProperty("filterPageUrl"));
        logger.info("Navigated to Computers and Accessories category page.");

        Assert.assertTrue(compAndAccPage.sortByLowToHighItem(), "Products are not sorted from low to high price.");
        logger.info("Products should be sorted from low to high when selected.");
    }

    @Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Products should be sorted from high to low when 'Price: High to Low' is selected.")
    @Story("US04")
    @Test(groups = {"Regression", "Smoke"})
    public void shouldSortItemsByHighToLowPrice() {
        driver.get(ConfigReader.getProperty("filterPageUrl"));
        logger.info("Navigated to Computers and Accessories category page.");

        Assert.assertTrue(compAndAccPage.sortByHighToLowItem(), "Products are not sorted from high to low price.");
        logger.info("Products should be sorted from high to low when selected.");
    }


@Owner("Fatma")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanıcı, \"Avg. Customer Review\" seçeneğini seçtiğinde ürünler koşula uygun olarak güncellenmelidir.")
    @Story("US04")
    @Test(groups = {"Regression", "Smoke"})
    public void TC04_04() throws InterruptedException {
        categoryPage = new CategoryPage(driver);
        compAndAccPage = new ComputersAndAccessoriesPage(driver);

        driver.get(ConfigReader.getProperty("filterPageUrl"));


        logger.info("Computers And Accessories Kategori seçim sayfası görüntülenecektir.\n");
        logger.info("Sayfanın sağ tarafında Sıralama Ölçütü görüntülenecektir.\n");
        logger.info("Drop down menüye tıklanır\n");
        logger.info("\"Sort by:Avg. Customer Review\" seçilir\n");
        logger.info("Seçim yapıldığında ürün listesi yenilenir.\n");
          compAndAccPage.sortByCustomerReview();


    }

}
