package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * GoogleResultOfSearchPage class describe Google Result Of Search Page at site Google
 */
public class GoogleResultOfSearchPage extends BasePage {

    /**
     * Declaration variable from data type WebElement by name: resultSearchTitleList
     */
    @FindBy(xpath = "//*[@class='r']")
    private List<WebElement> resultSearchTitleList;

    /**
     * Declaration variable from data type WebElement by name: resultSearchTextList
     */
    @FindBy(xpath = ".//*[@class='st']")
    private List<WebElement> resultSearchTextList;

    /**
     * Common method to verify that resultOfSearchPageLoaded loaded
     *
     * Results are checked for three localizations: English, Russian, Ukrainian
     *
     * @return Boolean statement about verify result
     */
    public boolean isResultOfSearchPageLoaded(){
        boolean resultPageTitleRus = driver.getTitle().contains("ITEA - Поиск в Google");
        boolean resultPageTitleUkr = driver.getTitle().contains("ITEA - Пошук Google");
        boolean resultPageTitleEng = driver.getTitle().contains("ITEA - Google Search");

        boolean resultPageTitle;

        if(resultPageTitleRus || resultPageTitleUkr || resultPageTitleEng){
            resultPageTitle = true;
        } else resultPageTitle=false;

        if(resultPageTitle){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Common method to finding quantity of search results
     *
     * @return Int statement about quantity of search results
     */
    public int getResultSearchCount() {
        int resultSearchCount = resultSearchTitleList.size();
        return resultSearchCount;
    }

    /**
     * Common method to get list elements with title and text of search
     *
     * @return List with text which contains in each title and text of search
     */
    public List<String> getTextListOfEachResultSearchItem() {
        List<String> list =  new ArrayList<String>();
        for(int i=0; i<resultSearchTitleList.size(); i++){
                String searchItemText =resultSearchTitleList.get(i).getText()+" "+resultSearchTextList.get(i).getText();
                list.add(searchItemText);
            }
        return list;
    }

    /**
     * Common method to change search result pages
     *
     * @param pageNumber Int statement on what page we want go
     */
    public void changeSearchResultPage(int pageNumber){
        driver.findElement(By.cssSelector("[aria-label='Page " + pageNumber + "']")).click();
    }


    /**
     * Constructor to GoogleResultOfSearchPage class
     *
     * @param driver variable of WebDriver which we Declaration in BasePage class
     */
    public GoogleResultOfSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
}
