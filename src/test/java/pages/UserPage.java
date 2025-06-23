package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;
import utils.ReusableMethods;

import static utils.TestDriver.getDriver;

public class UserPage extends BaseTest {

    boolean isDisplayed;
    Logger logger = LogManager.getLogger(UserPage.class);
    public UserPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//button[@class='header-dropdown-toggle striped-button']")
    private WebElement myAcoountButton;

    public boolean isDisplayedMyAccountButton(){
        isDisplayed = ReusableMethods.waitForVisibility(getDriver("browser"),myAcoountButton,10).isDisplayed();
        logger.info("Hesabım butonu görüntülendi mi? " + isDisplayed);
        return isDisplayed;
    }
}
