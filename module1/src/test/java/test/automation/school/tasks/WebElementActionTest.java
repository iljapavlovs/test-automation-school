package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WebElementActionTest {
    // Tell about instance field
    private WebDriver driver;


    //TODO - tests should be


    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
    //
    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
//        driver.get("http://automationpractice.com/index.php");

    }
    //TODO 1


    @BeforeMethod
    public void setUpBeforeMethod() throws Exception {
        driver.get("http://automationpractice.com/index.php");
    }


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();

    }
    //TODO 2


    //TODO 3 - Create TestNg Test method which navigates to Contact info page (click()) and verify that user is navigated to other page
    @Test
    public void testClickAction() throws Exception {
        WebElement contactUsButton = driver.findElement(By.id("contact-link"));
        contactUsButton.click();
        assertEquals(driver.getTitle(), "Contact us - My Store");
    }
    //TODO 3


    //TODO 4 -Create TestNg Test method which inputs some value into search input field and then clear the inputted text. Try do it in 2 possible ways.
    @Test
    public void testInputActions() throws Exception {
        WebElement searchInput = driver.findElement(By.id("search_query_top"));
        String inputText = "test";

        searchInput.sendKeys(inputText);
        assertEquals(searchInput.getAttribute("value"), inputText);
        searchInput.clear();
        assertEquals(searchInput.getText(), "");
        searchInput.sendKeys(inputText);
        assertEquals(searchInput.getAttribute("value"), inputText);
        searchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        assertEquals(searchInput.getText(), "");
    }
    //TODO 4


    //TODO 5 - input some value into search input field and submit the result. Verify that user is navigated to new page
    @Test
    public void testSubmitActions() throws Exception {
        WebElement searchInput = driver.findElement(By.id("search_query_top"));
        String inputText = "test";
        searchInput.sendKeys(inputText);
        searchInput.submit();
        assertEquals(driver.getTitle(), "Search - My Store");
    }
    //TODO 5

}
