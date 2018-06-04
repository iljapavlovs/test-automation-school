package test.automation.school;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class GoogleSearchTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();


        driver.get("http://www.google.com");

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test

    public void googleSearch() throws InterruptedException {


        //driver.findElement(By.name("q"));
        WebElement element = driver.findElement(By.cssSelector("[name='q']"));
        element.sendKeys("cheese");
        element.sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//*[@name='q']"));
        Thread.sleep(3000);
        List<WebElement> searchResultElements = driver.findElements(By.className("g"));

        assertTrue(searchResultElements.size()>0);

    }
}


