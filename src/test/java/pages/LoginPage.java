package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.JavascriptUtils;
import utils.ReusableMethods;

import java.time.Duration;

import static utils.TestDriver.getDriver;

public class LoginPage {

    boolean isDisplayed;
    Logger logger = LogManager.getLogger(LoginPage.class);
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//div/input[@name='emailAndPhone']")
    private WebElement emailAndPhoneElement;

    @FindBy (xpath = "//div/button[text()='Devam Et']")
    private WebElement continueForPasswordButton;


    @FindBy (xpath = "//div/input[@name='password']")
    private WebElement passwordElement;

    @FindBy (xpath = "//form/button[text()='Giriş Yap']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='cookieseal-banner']")
    private WebElement messageBanner;

    //***********************************Getter Methods*******************************************

    public WebElement getEmailAndPhoneElement() {
        return emailAndPhoneElement;
    }

    public WebElement getContinueForPasswordButton() {
        return continueForPasswordButton;
    }
    public WebElement getPasswordElement() {
        return passwordElement;
    }
    public WebElement getLoginButton() {
        return loginButton;
    }
    //***********************************Setter Methods*******************************************

    public void setEmailAndPhoneElement(String emailOrPhone){
        emailAndPhoneElement.sendKeys( emailOrPhone );
        logger.info("Email yada telefon bilgisi girildi " + emailAndPhoneElement.getText());
    }

    public void setPasswordElement(String password) {
        ReusableMethods.waitForVisibility(getDriver("browser"),passwordElement,10);
        passwordElement.sendKeys(password);
        logger.info("Password bilgisi girildi " + passwordElement.getText());
    }
    public void clickLoginButton(){
        JavascriptUtils.clickElementByJS(loginButton);
        logger.info("Login butonuna tıklandı.");
    }
    public boolean isDisplayedEmailAndPhoneElement(){
        isDisplayed = ReusableMethods.waitForVisibility(getDriver("browser"),emailAndPhoneElement,10).isDisplayed();
        logger.info("Login sayfasına geçildiği doğrulandı mı? " + isDisplayed );
        return isDisplayed;
    }

    public void clickContinueButton() {
//        ReusableMethods.waitForClickability(getDriver("browser"),continueForPasswordButton,10);
        continueForPasswordButton.click();
        logger.info("Password girilmesi için Devam butonuna tıklandı");
    }

    public boolean isUserSuccesfullyLoggedIn() {
        setEmailAndPhoneElement(ConfigReader.getProperty("email"));
        clickContinueButton();
        setPasswordElement(ConfigReader.getProperty("password"));
        clickLoginButton();
        ReusableMethods.waitForSeconds(5);
        //todo messageBanner geçilmesi için telefona gelen mesajı alacak bir düzenleme eklenmeli
        ReusableMethods.waitForSeconds(40);
        return new UserPage(getDriver("browser")).isDisplayedMyAccountButton();
    }
}
