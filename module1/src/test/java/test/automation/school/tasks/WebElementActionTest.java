package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WebElementActionTest {
         //TODO - tests should use new browser instance for each test method
    private WebDriver driver;

         //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
    }
        //TODO 1

        //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
        //TODO 2

    @Test
    public void contactUs() {

        //TODO 3 - Create TestNg Test method which navigates to Contact info page (click()) and verify that user is navigated to other page
        // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
        WebElement contractInfoPage = driver.findElement(By.cssSelector("div#contact-link>a"));
        contractInfoPage.click();
        assertEquals(driver.getTitle(), "Contact us - My Store");
        //TODO 3

        //TODO 4 -Create TestNg Test method which inputs some value into search input field and then clear the inputted text. Try do it in 2 possible ways.
        WebElement inptSearch = driver.findElement(By.cssSelector("input#search_query_top"));
        String firstSearchItem = "The best dress";
        inptSearch.sendKeys(firstSearchItem, Keys.ENTER);

        //TODO 4 - Also verify inputted text after each input action.
        inptSearch = driver.findElement(By.cssSelector("input#search_query_top"));
        assertEquals(inptSearch.getAttribute("value"), firstSearchItem);

        inptSearch.sendKeys(Keys.CONTROL + "a");
        String secondSearchItem = "Black dress";
        inptSearch.sendKeys(secondSearchItem);
        inptSearch.submit();

        inptSearch = driver.findElement(By.cssSelector("input#search_query_top"));
        assertEquals(inptSearch.getAttribute("value"), secondSearchItem);
        inptSearch.clear();
        //TODO 4

        //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result. Verify that user is navigated to new page
        // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
        inptSearch = driver.findElement(By.cssSelector("input#search_query_top"));
        String thirdSearchItem = "jeans";
        inptSearch.sendKeys(thirdSearchItem);
        inptSearch.submit();

        assertEquals(driver.getTitle(), "Search - My Store");
        //TODO 5
    }
}
