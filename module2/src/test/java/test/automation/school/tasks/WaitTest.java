package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class WaitTest {

    WebDriver driver;

    //TODO - tests should use new browser instance for each test method

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    //TODO 1

    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    //TODO 2

    @Test
    public void chbxElementDisapearsOnClickRemoveTest() {
      //  WebDriver wait = new WebDriver();

        assertTrue(driver.findElement(By.cssSelector("button#btn")).isDisplayed());

        //TODO 3 - Create TestNg Test method which
        //TODO 3 - 1. verifies that checkbox element dissapears after hitting "Remove" button
        WebElement btnRemove = driver.findElement(By.cssSelector("button#btn"));
        btnRemove.click();

        WebElement chbxA = driver.findElement(By.cssSelector("#checkbox"));
        assertTrue(chbxA.isDisplayed());

//        assertFalse(btnRemove.isDisplayed());

        //TODO 3 - 2. verifies that checkbox element appears after hitting "Add" button

       WebElement btnAdd = driver.findElement(By.cssSelector(""));
        //TODO 3 - Use Explicit Wait without Implicit Wait

        //TODO 3
    }


    //TODO 4 - Create TestNg Test method which
    //TODO 4 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 4 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 4 - Use Implicit Wait without Explicit Wait

    //TODO 4


    //TODO 5 - examine both approaches! which one is better?
}

