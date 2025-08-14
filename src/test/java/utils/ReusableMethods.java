package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

import static utils.TestDriver.getDriver;

public class ReusableMethods {
    static Logger logger = LogManager.getLogger(ReusableMethods.class);
    // Waits for the visibility of a specific element
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Waits for all elements in a list to be visible
    public static List<WebElement> waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> elements, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    // Waits until a specific element is clickable
    public static WebElement waitForClickability(WebDriver driver, WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Waits until a specific element located by a locator is clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By by, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // Logs and returns the text of a WebElement
    public static String getElementText(WebElement element) {
        String text = element.getText().trim();
        System.out.println("Element Text: " + text);
        return text;
    }

    // Converts a numeric string inside a WebElement to an integer (e.g. "$1,234" → 1234)
    public static int convertElementTextIntoInteger(WebElement element) {
        String text = element.getText().replaceAll("[^0-9]", "");
        if (text.isEmpty()) {
            throw new NumberFormatException("Element text does not contain any numeric characters: " + element.getText());
        }
        return Integer.parseInt(text);
    }

    // Simple wait (not recommended for real tests, prefer explicit waits)
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep was interrupted");
        }
    }
    //******************************is Displayed Method***********************************

    public static boolean isWebElementDisplayed(WebElement element){
        waitForVisibility(getDriver(ConfigReader.getProperty("browser")),element,10);
    //    logger.info(element.getTagName() + " -> elementi görüntülendi");
        return element.isDisplayed();
    }

    //*********************************is Clickable Method*********************************************

    public static boolean clickElementWithExplicitWait(WebElement element){
        try {
            waitForClickability(getDriver(ConfigReader.getProperty("browser")),element,10);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
