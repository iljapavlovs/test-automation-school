package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class WebElementActionTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Users\\valentina.tonko\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    //TODO - tests should use new browser instance for each test method
    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
    //TODO 3 - Create TestNg Test method which navigates to Contact info page (click()) and verify that user is navigated to other page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications

    //TODO 3
    @Test
    public void navigateContactTest() throws Exception {

        WebElement linkContactUs = driver.findElement(By.linkText("Contact us"));
        linkContactUs.click();
//        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Contact us - My Store");

    }


    //TODO 4 -Create TestNg Test method which inputs some value into search input field and then clear the inputted text. Try do it in 2 possible ways.
    @Test
    public void clearSearchFiledTest() throws Exception {
        WebElement inptSearch = driver.findElement(By.cssSelector(".search_query.form-control.ac_input"));
//       Var 1
        inptSearch.sendKeys("Search criteria");
        inptSearch.clear();
//       Var 2
        Thread.sleep(3000);
        inptSearch.sendKeys("New search criteria");
        inptSearch.sendKeys(Keys.CONTROL + "a");
        inptSearch.sendKeys(Keys.BACK_SPACE);
        Assert.assertEquals(inptSearch.getAttribute("value"), "");
        Thread.sleep(3000);
    }
    //TODO 4 - Also verify inputted text after each input action.


    //TODO 4


    //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result. Verify that user is navigated to new page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
    @Test
    private void navigateAfterSearchTest() throws Exception {

        WebElement inptSearch = driver.findElement(By.cssSelector(".search_query.form-control.ac_input"));
        inptSearch.sendKeys("T-shirt");
        inptSearch.submit();
//        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "My Store");
    }
    //TODO 5

}
