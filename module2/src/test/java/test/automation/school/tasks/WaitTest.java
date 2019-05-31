package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class WaitTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.39-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    //TODO 3 - Create TestNg Test method which
    //TODO 3 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 3 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 3 - Use Explicit Wait without Implicit Wait

    //TODO 3
    @Test
    public void addRemoveCheckboxTest() throws Exception {

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        assertTrue(checkbox != null);

        WebElement actionButton = driver.findElement(By.id("btn"));
        actionButton.click();
        WebDriverWait waitDelete = new WebDriverWait(driver, 5);
        waitDelete.until(driver -> driver.findElements(By.id("checkbox")).size() == 0);
        assertTrue(driver.findElements(By.id("checkbox")).size() == 0);

        actionButton.click();
        WebDriverWait waitAdd = new WebDriverWait(driver, 10);
//        waitAdd.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));
        waitAdd.until(driver -> driver.findElements(By.id("checkbox")).size() == 2);
        assertTrue(driver.findElements(By.id("checkbox")).size() == 2);
    }

    //TODO 4 - Create TestNg Test method which
    //TODO 4 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 4 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 4 - Use Implicit Wait without Explicit Wait

    //TODO 4
    @Test
    public void elementDisappearTest() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement checkbox;

        WebElement actionButton = driver.findElement(By.id("btn"));
        actionButton.click();

        assertTrue(driver.findElement(By.id("message")).isDisplayed());

        actionButton.click();

        checkbox = driver.findElements(By.id("checkbox")).get(0);

        assertTrue(checkbox != null);
    }


    //TODO 5 - examine both approaches! which one is better?
}

