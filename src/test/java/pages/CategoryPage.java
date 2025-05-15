package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JavascriptUtils;

import java.time.Duration;
import java.util.List;

import static utils.JavascriptUtils.clickElementByJS;

public class CategoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement allButton;

    @FindBy(xpath = "//a/div[text()='Electronics']")
    private WebElement electronicsSubMenu;

    @FindBy(xpath = "//a[text()='Computers & Accessories']")
    private WebElement computersAndAccessoriesMenu;

    @FindBy(xpath = "//ul[contains(@class,'hmenu')]//a[@aria-label='Back to main menu']")
    private WebElement backToMainMenu;

    @FindBy(xpath = "//a[@data-menu-id='2' or @data-menu-id='3' or @data-menu-id='4' or @data-menu-id='5']")
    private List<WebElement> digitalContentDevices;

    @FindBy(xpath = "//a[@data-menu-id='6' or @data-menu-id='7' or @data-menu-id='8' or @data-menu-id='9']")
    private List<WebElement> shopByDepartment;

    @FindBy(xpath = "//a[@data-menu-id='28' or @data-menu-id='29' or @data-menu-id='30']")
    private List<WebElement> programsFeatures;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void allCategoryClick(WebDriver driver) {
        wait.until(ExpectedConditions.elementToBeClickable(allButton)).click();
    }

    public void clickElectronicsSubMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(electronicsSubMenu)).click();
    }

    public void clickComputerAndAccessoriesMenu() {
        wait.until(ExpectedConditions.visibilityOf(computersAndAccessoriesMenu));
        clickElementByJS(computersAndAccessoriesMenu);
    }

    public boolean isElectronicsSubMenuVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(electronicsSubMenu));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isComputerAndAccessoriesMenuVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(computersAndAccessoriesMenu));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areShopByDepartmentVisible() {
        return shopByDepartment != null && !shopByDepartment.isEmpty();
    }

    public boolean clickThroughSection(List<WebElement> sectionElements, int maxIndex) {
        int index = 1;

        for (WebElement item : sectionElements) {
            if (item.isDisplayed() && item.isEnabled()) {
                clickElementByJS(item);
            }

            try {
                wait.until(ExpectedConditions.visibilityOf(backToMainMenu));
                clickElementByJS(backToMainMenu);
            } catch (Exception e) {
                System.out.println("Back button not found or not clickable: " + e.getMessage());
            }

            if (index == maxIndex) {
                return true;
            }
            index++;
        }
        return true;
    }

    public boolean clickFirstHeadElements() {
        return clickThroughSection(digitalContentDevices, 4);
    }

    public boolean clickSecondHeadElements() {
        return clickThroughSection(shopByDepartment, 4);
    }

    public boolean clickThirdHeadElements() {
        return clickThroughSection(programsFeatures, 3);
    }
}
