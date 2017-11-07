package test.automation.school.classexamples.pageobjectexample.google;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleWithPOTest {
    private WebDriver driver;


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://google.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGoogleSearchCheese() throws Exception {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.searchFor("cheese");
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(driver);
        assertTrue(googleSearchResultPage.getFirstSearchResultElementText().toLowerCase().contains("cheese"));
    }

    @Test
    public void testGoogleSearchApple() throws Exception {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.searchFor("apple");
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(driver);
        assertTrue(googleSearchResultPage.getFirstSearchResultElementText().toLowerCase().contains("apple"));
    }
}
