package test;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GoogleResultOfSearchPage;
import page.GoogleSearchPage;

import java.util.List;



/**
 * GoogleSearchTest class describe Tests methods for Google search
 */
public class GoogleSearchTest {
    /**
     * Declaration variable driver
     */
    private WebDriver driver;

    /**
     * Common method that performed before each test method, to open browser window and go to site URL
     */
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.google.com.ua/");
    }

    /**
     * Common test method to testing Google search for a given phrase, in this case -ITEA
     */
    @Test
    public void testSearchIteaSiteInGoogle(){

        int expectedSearchResultsOnFirstPage =10;

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        GoogleResultOfSearchPage googleResultOfSearchPage = googleSearchPage.search("ITEA");

        Assert.assertTrue(googleResultOfSearchPage.isResultOfSearchPageLoaded(), "No search result");

        Assert.assertEquals(googleResultOfSearchPage.getResultSearchCount(),expectedSearchResultsOnFirstPage, "Expected numbers of search result isnt same to Actual");

        List<String> searchItemList  = googleResultOfSearchPage.getTextListOfEachResultSearchItem();

        for (String eachElementFromSearchList: searchItemList) {
            boolean ifcontains = StringUtils.containsIgnoreCase(eachElementFromSearchList, "ITEA");
            Assert.assertTrue(ifcontains, "Not all search results contains search term");
        }

        googleResultOfSearchPage.changeSearchResultPage(2);

        Assert.assertEquals(googleResultOfSearchPage.getResultSearchCount(),expectedSearchResultsOnFirstPage, "Expected numbers of search result isnt same to Actual");

        List<String> searchItemList2  = googleResultOfSearchPage.getTextListOfEachResultSearchItem();

        for (String eachElementFromSearchList: searchItemList2) {
            boolean ifcontains = StringUtils.containsIgnoreCase(eachElementFromSearchList, "ITEA");
            Assert.assertTrue(ifcontains, "Not all search results contains search term");
        }

    }

    /**
     * Common method that performed after each test method, to close browser window
     */
    @AfterMethod
    public  void closeWindow(){
        driver.quit();
    }
}
