package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * GoogleSearchPage class describe Google Search Page at site Google
 */
public class GoogleSearchPage extends BasePage {

    /**
     * Declaration variable from data type WebElement by name: googleSearchButton
     */
    @FindBy(xpath = "//center/input[@name='btnK']")
    private WebElement googleSearchButton;

    /**
     * Declaration variable from data type WebElement by name: googleSearchField
     */
    @FindBy(xpath = ".//*[@id='sb_ifc0']")
    private WebElement googleSearchField;

    /**
     * Common method to try Search use Google search
     *
     * @param whatNeedToSearch String with phrase which we need search
     * @param <T> Type of page which must be defined later
     * @return Page of the site we are on
     */
    public <T> T search(String whatNeedToSearch){
        googleSearchField.sendKeys(whatNeedToSearch);
        googleSearchButton.click();
        //googleSearchField.sendKeys(Keys.ENTER);
        boolean resultPageTitleRus = driver.getTitle().contains("ITEA - Поиск в Google");
        boolean resultPageTitleUkr = driver.getTitle().contains("ITEA - Пошук Google");
        boolean resultPageTitleEng = driver.getTitle().contains("ITEA - Google Search");

        boolean resultPageTitle;

        if(resultPageTitleRus || resultPageTitleUkr || resultPageTitleEng){
            resultPageTitle = true;
        } else resultPageTitle=false;

        if (resultPageTitle==false){
            return (T) this ;
        } else return (T) new GoogleResultOfSearchPage(driver);
    }


    /**
     * Constructor to GoogleSearchPage class
     *
     * @param driver variable of WebDriver which we Declaration in BasePage class
     */
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitForElementIsDisplay(googleSearchField,10);
    }

}
