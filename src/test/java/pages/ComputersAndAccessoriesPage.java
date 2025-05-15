package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReusableMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputersAndAccessoriesPage {

    private final Logger logger = LogManager.getLogger(ComputersAndAccessoriesPage.class);
    private WebDriver driver;

    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    private WebElement sortByButton;

    @FindBy(xpath = "//li[@class='a-dropdown-item']")
    private List<WebElement> listOfSortByItems;

    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']//*[@class='a-price-whole']")
    private List<WebElement> productPrices;

    public ComputersAndAccessoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sortByButtonisVisible() {
        return sortByButton.isDisplayed();
    }

    public boolean sortByLowToHighItem() {
        sortByButton.click();
        logger.info("Clicked on the 'Sort by' dropdown.");

        listOfSortByItems.get(1).click(); // Assuming index 1 is 'Price: Low to High'
        logger.info("Selected 'Price: Low to High'.");

        ReusableMethods.waitForSeconds(3); // Prefer WebDriverWait in real-time, dummy wait here as fallback

        List<Integer> prices = extractPrices();
        List<Integer> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        boolean isSorted = prices.equals(sortedPrices);
        logger.info(isSorted ? "Products are sorted from low to high." : "Product sorting is incorrect.");
        return isSorted;
    }

    public boolean sortByHighToLowItem() {
        sortByButton.click();
        logger.info("Clicked on the 'Sort by' dropdown.");

        listOfSortByItems.get(2).click(); // Assuming index 2 is 'Price: High to Low'
        logger.info("Selected 'Price: High to Low'.");

        ReusableMethods.waitForSeconds(3); // Prefer WebDriverWait in real-time

        List<Integer> prices = extractPrices();
        List<Integer> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Collections.reverseOrder());

        boolean isSorted = prices.equals(sortedPrices);
        logger.info(isSorted ? "Products are sorted from high to low." : "Product sorting is incorrect.");
        return isSorted;
    }

    private List<Integer> extractPrices() {
        List<Integer> priceList = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            try {
                priceList.add(ReusableMethods.convertElementTextIntoInteger(priceElement));
            } catch (Exception e) {
                logger.warn("Failed to convert price element: " + priceElement.getText());
            }
        }
        return priceList;
    }

    // Placeholder for future implementation
    public void sortByCustomerReview() {
        // Not implemented yet
    }
}
