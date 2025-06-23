package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;
import utils.ConfigReader;
import utils.ReusableMethods;

import static utils.TestDriver.getDriver;

public class LoginPage extends BaseTest {

    boolean isDisplayed;
    protected LoginPage loginPage;
    protected UserPage userPage;
    Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//div/input[@name='emailAndPhone']")
    private WebElement emailAndPhoneElement;

    @FindBy (css = "button.navigateToLoginPage-form__button.navigateToLoginPage-form__button--bg-blue")
    private WebElement continueForPasswordButton;


    @FindBy (xpath = "//div/input[@name='password']")
    private WebElement passwordElement;

    @FindBy (xpath = "//form/button[text()='Giriş Yap']")
    private WebElement loginButton;

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
        loginButton.click();
        logger.info("Login butonuna tıklandı.");
    }
    public boolean isDisplayedEmailAndPhoneElement(){
        isDisplayed = ReusableMethods.waitForClickability(getDriver("browser"),emailAndPhoneElement,10).isDisplayed();
        logger.info("Login sayfasına geçildiği doğrulandı mı? " + isDisplayed );
        return isDisplayed;
    }

    public void clickContinueButton() {
        ReusableMethods.waitForClickability(getDriver("browser"),continueForPasswordButton,10);
//        continueForPasswordButton.click();
        logger.info("Password girilmesi için Devam butonuna tıklandı");
    }
public void login(){

}
    public boolean isUserSuccesfullyLoggedIn() {
        userPage = new UserPage(getDriver("browser"));
        setEmailAndPhoneElement(ConfigReader.getProperty("email"));
        clickContinueButton();
        setPasswordElement(ConfigReader.getProperty("password"));
        clickLoginButton();
        ReusableMethods.waitForSeconds(5000);
        return userPage.isDisplayedMyAccountButton();
    }
}
