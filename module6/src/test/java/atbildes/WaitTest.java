package atbildes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class WaitTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private By actionButtonLocator = By.id("btn");
    private By checkBoxLocator = By.id("checkbox");
    private By textLocator = By.id("message");

    // NOTE how execution time increased when using implicit wait
    // dont tie to element text if it`s not needed, just check for "isDisplayed()"
    // -> text may change with time, but id of the element should stay

    //all class fields should comply to encapsulation rules (private)

    // it`s better to move repeating locators to the instances of the class.
    // If locator will change, then you will change it in one place
    @BeforeClass
    public void globalSetUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");

    }

    @BeforeMethod
    public void setUp() throws Exception {
//
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        wait = new WebDriverWait(driver, 5);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }


    //TODO - tests should use new browser instance for each test method

    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/

    //TODO 1


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)

    //TODO 2

    //TODO 3 - Create TestNg Test method which
    //TODO 3 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 3 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 3 - Use Explicit Wait without Implicit Wait
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications

    //TODO 3

    @Test
    public void testName() throws Exception {
        assertTrue(driver.findElement(checkBoxLocator).isDisplayed());
        WebElement actionButton = driver.findElement(actionButtonLocator);
        actionButton.click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBoxLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
        assertTrue(driver.findElement(textLocator).isDisplayed());
        assertTrue(driver.findElements(checkBoxLocator).size() == 0);
        actionButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxLocator));
        assertTrue(driver.findElement(checkBoxLocator).isDisplayed());
    }


    //TODO 4 - Create TestNg Test method which
    //TODO 4 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 4 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 4 - Use Implicit Wait without Explicit Wait
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications

    //TODO 4
    @Test
    public void testName2() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(driver.findElement(checkBoxLocator).isDisplayed());
        WebElement actionButton = driver.findElement(actionButtonLocator);
        actionButton.click();

        assertTrue(driver.findElement(textLocator).isDisplayed());
        assertTrue(driver.findElements(checkBoxLocator).size() == 0);
        actionButton.click();
        assertTrue(driver.findElement(checkBoxLocator).isDisplayed());

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }


    //TODO 5 - examine both approaches! which one is better?
}

