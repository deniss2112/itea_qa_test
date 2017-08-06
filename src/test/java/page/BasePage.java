package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage class describe base elements on WebPage site
 */
public class BasePage {

    /**
     * Declaration variable driver
     */
    protected WebDriver driver;

    /**
     * Waits until element is displayed using specific max timeout
     *
     * @param element WebElement to wait for
     * @param timesec max timeout in seconds
     * @return WebElement after expected condition
     */
    protected WebElement waitForElementIsDisplay (WebElement element, int timesec) {
        WebDriverWait wait = new WebDriverWait(driver, timesec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until element is clickable using specific max timeout
     *
     * @param element WebElement to wait for
     * @param timesec max timeout in seconds
     * @return WebElement after expected condition
     */
    protected WebElement waitForElementToClick(WebElement element, int timesec) {
        WebDriverWait wait = new WebDriverWait(driver, timesec);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Constructor to BasePage class
     *
     * @param driver initialized WebDriver in Base page class
     */
    public  BasePage(WebDriver driver){
        this.driver=driver;
    }
}
