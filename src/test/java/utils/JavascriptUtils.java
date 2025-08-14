package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtils extends TestDriver {

    // Belirtilen WebElement'i JavaScript kullanarak tıklar.
    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) getDriver("browser"));
        jsexecutor.executeScript("arguments[0].click();", element);
    }

    // JavaScript kullanarak sayfa başlığını alır.
    public static String getTitleByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) getDriver("browser"));
        String title = jsexecutor.executeScript("return document.title;").toString();
        return title;
    }

    // Sayfayı en alta doğru kaydırır.
    public static void scrollDownByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) getDriver("browser"));
        jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    // Sayfayı en üste doğru kaydırır.
    public static void scrollAllUpByJS() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver("browser");
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    public static void scrollToBottomJS() {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) getDriver("browser");
        jsexecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    // Belirtilen WebElement'e JavaScript kullanarak odaklanır, yani görünür hale getirir.
    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) getDriver("browser");
        jsexecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    // Belirtilen WebElement'in arkaplan rengini değiştirir ve ardından eski rengine geri döner, bir tür "flash" efekti oluşturur.
    public static void changeBackgroundColorByJS(WebElement element, String color) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) getDriver("browser"));
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Belirtilen WebElement'in arkaplan rengini hızlı bir şekilde değiştirir, bir tür "flash" efekti oluşturur.
    public static void flash(WebElement element, String color) {
        String bgColor = element.getCssValue("backgroundcolor");
        for (int i = 0; i < 5; i++) {
            changeBackgroundColorByJS(element, color);
            changeBackgroundColorByJS(element, bgColor);
        }
    }

    // Belirtilen mesaj ile bir JavaScript uyarısı oluşturur.
    public static void generateAlert(String message) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) getDriver("browser"));
        javascriptExecutor.executeScript("alert('" + message + "')");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Belirtilen JavaScript komutunu belirtilen WebElement üzerinde çalıştırır.
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver("browser");
        jse.executeScript(command, element);
    }

    // Belirtilen JavaScript komutunu çalıştırır.
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver("browser");
        jse.executeScript(command);
    }

    // Belirtilen WebElement'in değerini JavaScript kullanarak ayarlar.
    public static void setValueByJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver("browser");
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    // Belirtilen elementin değerini JavaScript kullanarak alır ve ekrana yazdırır.
    public static void getValueByJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver("browser");
        String value = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println(value);
    }

    // Belirtilen WebElement'e belirtilen kenarlık stiliyle bir kenarlık ekler.
    public static void addBorderWithJS(WebElement element, String borderStyle) {
        JavascriptExecutor js = (JavascriptExecutor)getDriver("browser");
        js.executeScript("arguments[0].style.border='" + borderStyle + "'", element);
    }

    // Belirtilen WebElement'in değerini JavaScript kullanarak alır.
    public static Object getElementValueJS(WebElement element) {
        return ((JavascriptExecutor) getDriver("browser")).executeScript("return arguments[0].value", element);
    }

    public static long pageLoadingTime(){ //Javascript methodlarina eklenebilir. Melisa hoca'ya sor.
        JavascriptExecutor js = (JavascriptExecutor) getDriver("browser");
        return (Long) js.executeScript(
                "return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart;"); //Sayfa yüklenme süresini milisaniye ve long olarak döner
    }
}
