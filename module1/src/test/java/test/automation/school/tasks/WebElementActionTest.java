package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WebElementActionTest {
    //TODO - tests should use new browser instance for each test method
    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
    private WebDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.39-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
    }

    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    //TODO 2

    @Test
    public void locateElementByIdTest() throws Exception {
        //TODO 1 - locate search input field by ID and assign to a variable named elementById
        WebElement elementById = driver.findElement(By.id("search_query_top"));
        assertTrue(elementById.isDisplayed());
        //TODO 1
    }
    //TODO 1

    //TODO 3 - Create TestNg Test method which navigates to Contact info page (click()) and verify that user is navigated to other page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
    @Test
    public void navigateToContactPageTest() throws Exception {
        WebElement contactElement = driver.findElement(By.xpath("//li[@class='item']//a[@href='http://automationpractice.com/index.php?controller=contact']"));
        contactElement.click();
        Thread.sleep(3000);
        WebElement contactUsHeader = driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']"));
        assertTrue(contactUsHeader.getText().equals("CUSTOMER SERVICE - CONTACT US"));
        assertTrue(driver.getTitle().equals("Contact us - My Store"));
    }
    //TODO 3


    //TODO 4 -Create TestNg Test method which inputs some value into search input field and then clear the inputted text. Try do it in 2 possible ways.
    //TODO 4 - Also verify inputted text after each input action.
    @Test
    public void clearInputedSearchValueTest() throws Exception {
        WebElement searchElement = driver.findElement(By.id("search_query_top"));
        searchElement.sendKeys("test");
        Thread.sleep(1500);
        searchElement.clear();
        assertTrue(searchElement.getText().equals(""));
    }
    //TODO 4


    //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result. Verify that user is navigated to new page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
    @Test
    public void submitEnteredValueTest() throws Exception {
        WebElement searchElement = driver.findElement(By.id("search_query_top"));
        searchElement.sendKeys("test", Keys.ENTER);
        Thread.sleep(3000);
        assertTrue(driver.getTitle().equals("Search - My Store"));
    }
    //TODO 5

}
