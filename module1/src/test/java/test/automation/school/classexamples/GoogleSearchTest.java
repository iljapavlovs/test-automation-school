package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }

    @Test
    public void testSearch() throws Exception {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("cheese");
        element.submit();
//        assertTrue(driver.findElements(By.className("g")).get(0).getText().toLowerCase().contains("cheese"));
        assertTrue(driver.getTitle().contains("cheese"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
