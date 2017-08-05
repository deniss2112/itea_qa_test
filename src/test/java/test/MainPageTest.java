package test;

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
 * Created by QA on 05.08.2017.
 */
public class MainPageTest {
    /**
     * Declaration variable driver
     */
    private WebDriver driver;

    /**
     * Common method that performed before each test method, to open browser window,
     * setup it by window size and go to site URL
     */
    // Run this method before the first test method in the current class is invoked
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.google.com.ua/");
    }

    @Test
    public void testSearchIteaSiteInGoogle(){

        int expectedSearchResultsOnFirstPage =13;

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        GoogleResultOfSearchPage googleResultOfSearchPage = googleSearchPage.search("ITEA");

        Assert.assertTrue(googleResultOfSearchPage.isResultOfSearchPageLoaded(), "No search result");

        Assert.assertEquals(googleResultOfSearchPage.getResultSearchCount(),expectedSearchResultsOnFirstPage, "Expected numbers of search result isnt same to Actual");

        List<String> searchItemList  = googleResultOfSearchPage.getTextListOfEachResultSearchItem();

        for (String eachElementFromSearchList: searchItemList) {
            boolean ifcontains = eachElementFromSearchList.contains("ITEA");
            Assert.assertTrue(ifcontains, "Not all search results contains search term");
        }






    }










    /**
     * Common method that performed after each test method, to close browser window
     */
    // Run this method after all the test methods in the current class have been run
    @AfterMethod
    public  void closeWindow(){
        driver.quit();
    }




}
