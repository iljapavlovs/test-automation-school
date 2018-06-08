package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class WaitTest {
    private WebDriver driver;

    //TODO - tests should use new browser instance for each test method

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/

    //TODO 1


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
//    @AfterClass
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
    //TODO 2

    //TODO 3 - Create TestNg Test method which
    //TODO 3 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 3 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 3 - Use Explicit Wait without Implicit Wait
    @Test
    public void verifyAddRemoveElement() throws Exception {
        //TODO 1 - locate search input field by ID and assign to a variable named elementById

        WebElement btnRemove = driver.findElement(By.id("btn"));
        btnRemove.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));

//        WebElement checkbox = driver.findElement(By.id("checkbox"));
//
//        assertTrue (checkbox.isDisplayed());
//
//
//        Assert.assertTrue(elementById.isDisplayed());
//        //TODO 1
    }

    //TODO 3


    //TODO 4 - Create TestNg Test method which
    //TODO 4 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 4 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 4 - Use Implicit Wait without Explicit Wait

    //TODO 4


    //TODO 5 - examine both approaches! which one is better?
}

