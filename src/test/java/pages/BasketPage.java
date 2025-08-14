package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReusableMethods;

import static utils.TestDriver.getDriver;


public class BasketPage {

    Logger logger = LogManager.getLogger(BasketPage.class);
    public BasketPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    boolean isDisplayed;

    @FindBy(xpath = "//h2[text()='Sepetim ']")
    private WebElement titleOfBasket;

    public boolean isCurrentUrlBasket() {
       boolean isCurrentUrlBasket = (getDriver("browser").getCurrentUrl().contains("sepet") );
        System.out.println("Sepet sayfası açıldı mı? - " + isCurrentUrlBasket);
        return isCurrentUrlBasket;
    }


    public boolean isTitleVisible() {
        isDisplayed = ReusableMethods.isWebElementDisplayed(titleOfBasket);
        logger.info("BasketPage'teki Sepet başlığı görüntülendi mi? " + isDisplayed);
        return isDisplayed;
    }
}
