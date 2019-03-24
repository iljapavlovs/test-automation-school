package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WebElementActionTest {


   private WebDriver driver;

    //TODO - tests should use new browser instance for each test method

    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver_v2.39_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        //TODO 1
    }


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)

//    @AfterClass
//    public void tearDown() throws Exception {
//        driver.quit();
//    }

    //TODO 2


    //TODO 3 - Create TestNg Test method which navigates to Contact info page (click()) and verify that user is navigated to other page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications

    @Test
    public void navigateToContactPage() throws Exception {

      WebElement contactUslink  =  driver.findElement(By.id("contact-link"));
      contactUslink.click();
     assertEquals (driver.getTitle(), "Contact us - My Store");

    }

    //TODO 3


    //TODO 4 -Create TestNg Test method which inputs some value into search input field and then clear the inputted text. Try do it in 2 possible ways.
    //TODO 4 - Also verify inputted text after each input action.
// get attribute . value
// get text

    @Test
    public void inputSearchField() throws Exception {

        String searchInput = "Blouse";
        WebElement searchInputBox  =  driver.findElement(By.name("search_query"));
        searchInputBox.sendKeys(searchInput);
        assertEquals(searchInputBox.getAttribute("value"),("Blouse"));

        System.out.println("input value1: " +searchInputBox.getAttribute("value"));

        searchInputBox.clear();
        System.out.println("clear input: " +searchInputBox.getAttribute("value"));
////// ----- ++++++++++++++++++++++++ ----------

        searchInput="Jacket";
        searchInputBox.sendKeys(searchInput);
        System.out.println("input value2: " +searchInputBox.getAttribute("value"));
        assertEquals(searchInputBox.getAttribute("value"),("Jacket"));


        searchInput="Suite";
        searchInputBox.sendKeys(Keys.CONTROL+"a");
        searchInputBox.sendKeys(searchInput);
        System.out.println("input value3: " +searchInputBox.getAttribute("value"));
        assertEquals(searchInputBox.getAttribute("value"),("Suite"));
        System.out.println("last input: " +searchInputBox.getAttribute("value"));
    }

    //TODO 4


    //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result. Verify that user is navigated to new page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications

    @Test
    public void inputSearchResults() throws Exception {

        String searchInput = "Blouse";
        WebElement searchInputBox  =  driver.findElement(By.id("search_query_top"));
        searchInputBox.sendKeys(searchInput);
        assertEquals(searchInputBox.getAttribute("value"),("Blouse"));
        System.out.println("input value1: " +searchInputBox.getAttribute("value"));

        WebElement searchBtn = driver.findElement(By.name("submit_search"));
        searchBtn.click();

        assertEquals(driver.getTitle(), "Search - My Store");
    }
    //TODO 5

}
