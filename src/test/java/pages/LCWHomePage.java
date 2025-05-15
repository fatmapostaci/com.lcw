package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.ReusableMethods;

import java.time.Duration;

import static utils.TestDriver.getDriver;

public class LCWHomePage {

    public LCWHomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "search-form__input-field__search-input")
    private WebElement searchBoxElement;

    @FindBy ( xpath = "//div/nav[@class='menu-nav']")
    private WebElement menuBarElement;

    @FindBy ( xpath = "//a[@class='main-header-logo']")
    private WebElement mainHeaderElement;

    @FindBy ( xpath = "//*[@id='content-layout']/div/div[@class='full-width-slider full-width-slider--horizontal']")
    private WebElement swiperSlideBarElement;


    @FindBy (className = "hm-icon-label")
    private WebElement categoryAllButton;

    @FindBy (xpath = "//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']")
    private WebElement languageButton;

    @FindBy (xpath = "//span[.='English']")
    private WebElement languageEnglish;

    @FindBy (id= "nav-link-accountList-nav-line-1")
    private WebElement loginButton;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ol[1]/li[3]/div[1]/div[1]/a[1]/div[1]/img[1]")
    private WebElement promotionSlides;

    //***********************************Getter Methods*******************************************

    public WebElement getSearchBox() { return searchBoxElement; }

    public WebElement getMenuBarElement() { return menuBarElement; }

    public WebElement getCategoryAllButton() {
        return categoryAllButton;
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public WebElement getLanguageEnglish() {
        return languageEnglish;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getPromotionSlides() {
        return promotionSlides;
    }

    public WebElement getMainHeaderElement(){ return mainHeaderElement; }

    public WebElement getSwiperSlideBarElement(){ return swiperSlideBarElement; }

    //******************************is Displayed Method***********************************

    public boolean isWebElementDisplayed(WebElement element){
        ReusableMethods.waitForVisibility(getDriver(ConfigReader.getProperty("browser")),element,10);
        return element.isDisplayed();
    }

 //*********************************is Clickable Method*********************************************

    public boolean isElementClickable(WebElement element){
        try {
            ReusableMethods.waitForClickability(getDriver(ConfigReader.getProperty("browser")),element,10);
            return true;
        } catch (Exception e) {
           return false;
        }
    }

    //***********************************Extra methods***************************

    public void languageHandle(){
        Actions actions = new Actions(getDriver("browser"));
        ReusableMethods.waitForClickability(getDriver(ConfigReader.getProperty("browser")),languageButton,10);
        actions.moveToElement(languageButton).perform();
        actions.click(languageEnglish);
        actions.perform();
    }
}
