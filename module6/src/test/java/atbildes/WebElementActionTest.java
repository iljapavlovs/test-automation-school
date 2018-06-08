package atbildes;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class WebElementActionTest {


    // * All fixtures should be placed is in the beginning of the test
    // * Use variables for making your tests more DRY (Dont Repeat Yourself)

    // * WebDriver should be made as a instance variable
    private WebDriver driver;

    //TODO - tests should use new browser instance for each test method

    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
    //
    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
    }
    //TODO 1


    @BeforeMethod
    public void setUpBeforeMethod() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
    }


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
    @AfterMethod
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
        String inputText = "test"; //reuse ot text further on so not to enter it all the times

        searchInput.sendKeys(inputText);
        assertEquals(searchInput.getAttribute("value"), inputText);
        searchInput.clear();
        assertEquals(searchInput.getAttribute("value"), "");
        searchInput.sendKeys(inputText);
        assertEquals(searchInput.getAttribute("value"), inputText);
        searchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        assertEquals(searchInput.getAttribute("value"), "");
    }
    //TODO 4


    //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result. Verify that user is navigated to new page
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
