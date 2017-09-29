package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NewBrowserSessionForEachTestExample {
    private WebDriver driver;

    /*
    Driver is initialized inside of BeforeMethod method, which means that new driver instance will be created each time new test method is executed.
    Hence, new browser will opened for each test method
    PROs:
        * This strategy allows avoid session and memory leaks.
        * Allows running test methods of one class in parallel
    CONs: Longer time execution, but this is mitigated by parallel execution
    */
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }

    /*
    After each test - close and destroy browser instance.
     */
    @AfterMethod
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
