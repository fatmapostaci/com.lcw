package tests;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CategoryPage;
import static org.testng.Assert.assertTrue;

public class CategoryTest extends BaseTest {

    private final Logger logger = LogManager.getLogger(CategoryTest.class);
    private CategoryPage categoryPage;

    @Parameters("browser")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mertay")
    @Description("User should be able to access the 4 main categories from the 'All' menu.")
    @Story("US06")
    @Test(groups = {"Regression", "Smoke"})
    public void TC06_01_verifyMainCategoriesVisible() {
        categoryPage = new CategoryPage(driver);
        categoryPage.allCategoryClick(driver);
        logger.info("Clicked on 'All' categories menu.");
        assertTrue(categoryPage.areShopByDepartmentVisible(), "Main category is not displayed.");
    }

    @Parameters("browser")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Fatma")
    @Description("Verify that subcategories under 'Digital Content & Devices' are clickable and reachable.")
    @Story("US06")
    @Test(groups = {"Regression", "Smoke"})
    public void TC06_02_verifyDigitalContentSubcategoriesClickable() {
        categoryPage = new CategoryPage(driver);
        categoryPage.allCategoryClick(driver);
        logger.info("Clicked on 'All' menu and verifying Digital Content subcategories.");
        assertTrue(categoryPage.clickFirstHeadElements(), "Not all subcategories under Digital Content are clickable.");
    }

    @Parameters("browser")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Fatma")  // Eklenmeli
    @Description("Verify that subcategories under 'Shop by Department' are clickable and reachable.")
    @Story("US06")
    @Test(groups = {"Smoke"})
    public void TC06_03_verifyShopByDepartmentSubcategoriesClickable() {
        categoryPage = new CategoryPage(driver);
        categoryPage.allCategoryClick(driver);
        logger.info("Verifying subcategories under 'Shop by Department'.");
        assertTrue(categoryPage.clickSecondHeadElements(), "Not all subcategories under Shop by Department are clickable.");
    }

    @Parameters("browser")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mertay")
    @Description("Verify that subcategories under 'Programs & Features' are clickable and reachable.")
    @Story("US06")
    @Test(groups = {"Regression", "Smoke"})
    public void TC06_04_verifyProgramsAndFeaturesSubcategoriesClickable() {
        categoryPage = new CategoryPage(driver);
        categoryPage.allCategoryClick(driver);
        logger.info("Verifying subcategories under 'Programs & Features'.");
        assertTrue(categoryPage.clickThirdHeadElements(), "Not all subcategories under Programs & Features are clickable.");
    }
}
