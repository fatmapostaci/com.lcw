package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.JavascriptUtils;
import utils.ReusableMethods;
import java.util.List;
import static utils.TestDriver.getDriver;

public class HomePage {

    Logger logger = LogManager.getLogger(HomePage.class);
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    boolean isDisplayed;

    @FindBy (id = "search-form__input-field__search-input")
    private WebElement searchBoxElement;

    @FindBy( xpath = "//ul/li[@class='menu-header-item']")
    private List<WebElement> menuNavList;

    //@FindBy ( xpath = "//ul[li[@class='menu-header-item']]")
    @FindBy ( xpath = "//nav/ul[@class='menu-nav__lists']")
    private WebElement mainNavElement;

    @FindBy ( xpath = "//*[@id='content-layout']/div/div[@class='full-width-slider full-width-slider--horizontal']")
    private WebElement swiperSlideBarElement;

    @FindBy (className = "hm-icon-label")
    private WebElement categoryAllButton;

    @FindBy (xpath = "//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']")
    private WebElement languageButton;

    @FindBy (xpath= "//a/span[text()='Giriş Yap']")
    private WebElement loginLink;

    @FindBy (xpath = "//div//span[text()='Sepetim']")
    private WebElement basketLink;

    @FindBy (xpath = "div[class='footer-content']")
    private WebElement footerContent;



    //***********************************Getter Methods*******************************************


    //******************************is Displayed Method***********************************

    public boolean isWebElementDisplayed(WebElement element){
        ReusableMethods.waitForVisibility(getDriver(ConfigReader.getProperty("browser")),element,10);
        logger.info(element.getTagName() + " -> elementi görüntülendi");
        return element.isDisplayed();
    }

 //*********************************is Clickable Method*********************************************

    public boolean clickElementWithExplicitWait(WebElement element){
        try {
            ReusableMethods.waitForClickability(getDriver(ConfigReader.getProperty("browser")),element,10);
            return true;
        } catch (Exception e) {
           return false;
        }
    }

    //***********************************Extra methods***************************


    public LoginPage goToLoginPage() {
        clickElementWithExplicitWait(loginLink);
        logger.info("Login sayfasına geçiş yapılıyor....");
        return new LoginPage(getDriver("browser"));
    }
    public boolean isLoginLinkDisplayed() {
        isDisplayed = isWebElementDisplayed(loginLink);
        logger.info("Homepage'teki goToLoginPage linki görüntülendi mi? " + isDisplayed);
        return isDisplayed;
    }
    public boolean isNavMenuDisplayed(){
        isDisplayed = isWebElementDisplayed(mainNavElement);
        logger.info("Homepage'teki main nav menu görüntülendi mi? " + isDisplayed);
        return isDisplayed;
    }
    public boolean isSearchBoxDisplayed() {
        isDisplayed = isWebElementDisplayed(searchBoxElement);
        logger.info("Homepage'teki search box görüntülendi mi? " + isDisplayed);
        return isDisplayed;
    }

    public long pageLoadingTime() {
        //Sayfa tamamen yüklenene kadar beklenir
        long actualDuration = JavascriptUtils.pageLoadingTime();
        logger.info( "LCW anasayfa yüklenme süresi " + actualDuration/1000 + " saniyedir");
        return actualDuration;
    }

    public boolean isBasketLinkDisplayed() {
        isDisplayed = isWebElementDisplayed(basketLink);
        logger.info("Homepage'teki sepet butonu görüntülendi mi? " + isDisplayed);
        return isDisplayed;
    }
    public boolean isFooterContentDisplayed(){
        isDisplayed = isWebElementDisplayed(footerContent);
        logger.info("Homepage'teki Footer alanı görüntülendi mi? " + isDisplayed);
        return isDisplayed;
    }

    public BasketPage goToBasket() {
        clickElementWithExplicitWait(basketLink);
        logger.info("Sepet sayfasına geçiş yapılıyor....");
        return new BasketPage(getDriver("browser"));
    }
}
