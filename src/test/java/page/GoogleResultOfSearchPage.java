package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by QA on 05.08.2017.
 */
public class GoogleResultOfSearchPage extends BasePage {

    @FindBy(xpath = "//*[@class='r']")
    private List<WebElement> resultSearchList;

    /**
     * Common method to verify that esultOfSearchPageLoaded loaded
     *
     * @return Boolean statement about verify result
     */
    public boolean isResultOfSearchPageLoaded(){
        boolean resultPageTitle = driver.getTitle().contains("ITEA - Поиск в Google");
        if(resultPageTitle){
            return true;
        } else {
            return false;
        }
    }

    public int getResultSearchCount() {
        int resultSearchCount = resultSearchList.size();
        return resultSearchCount;
    }

    public List<String> getTextListOfEachResultSearchItem() {
        List<String> list =  new ArrayList<String>();
        for(int i=0; i<resultSearchList.size(); i++){
                String searchItemText =resultSearchList.get(i).getText();
                list.add(searchItemText);
            }
        return list;
    }

    public GoogleResultOfSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
}
