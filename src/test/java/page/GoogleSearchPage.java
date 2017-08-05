package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by QA on 05.08.2017.
 */
public class GoogleSearchPage extends BasePage {

    @FindBy(xpath = "//center/input[@name='btnK']")
    private WebElement googleSearchButton;

    @FindBy(xpath = ".//*[@id='sb_ifc0']")
    private WebElement googleSearchField;

    public <T> T search(String whatNeedToSearch){
        googleSearchField.sendKeys(whatNeedToSearch);
        googleSearchButton.click();
        //googleSearchField.sendKeys(Keys.ENTER);
        boolean resultPageTitle = driver.getTitle().contains("ITEA - Google Search");
        if (resultPageTitle==false){
            return (T) this ;
        } else return (T) new GoogleResultOfSearchPage(driver);
    }



    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitForElementIsDisplay(googleSearchField,10);
    }

}
