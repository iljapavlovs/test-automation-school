package test.automation.school.classexamples.browsermgmt;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OneBrowserSessionExample {
    private WebDriver driver;

    /*
    Driver is initialized inside of BeforeClass method, which means that driver will be created only once prior all tests.
    Hence, one browser session will be 'alive' throughout all tests inside this Test Class
    PROs: This strategy allows to significantly save test execution time on browser start/destroy
    CONs:
    * session leaks - e.g. you want to ensure that test is not affected by previous test session (cache, local storage)
    * memory leaks - browser memory is not cleared
    */

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void setUpBeforeMethod() throws Exception {
        driver.get("http://www.google.com");
    }

    /*
    After all tests finished - close and destroy browser instance.
     */
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testOne() throws Exception {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("banana");
        element.submit();
        assertTrue(driver.findElements(By.className("g")).size() > 0);
    }

    @Test
    public void testTwo() throws Exception {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("apple");
        element.submit();
        assertTrue(driver.findElements(By.className("g")).size() > 0);
    }
}
