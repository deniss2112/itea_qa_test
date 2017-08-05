package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by QA on 05.08.2017.
 */
public class GoogleResultOfSearchPage extends BasePage {

    /**
     * Common method to verify that esultOfSearchPageLoaded loaded
     *
     * @return Boolean statement about verify result
     */
    public boolean isResultOfSearchPageLoaded(){
        boolean resultPageTitle = driver.getTitle().contains("ITEA - Google Search");
        if(resultPageTitle){
            return true;
        } else {
            return false;
        }
    }

    public GoogleResultOfSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //waitForElementIsDisplay(googleSearchField,10);
    }
}
