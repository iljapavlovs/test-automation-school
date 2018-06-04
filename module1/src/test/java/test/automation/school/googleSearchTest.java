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

public class googleSearchTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver_v2.39_win32/chromedriver.exe");
         driver = new ChromeDriver();

        driver.get("http://google.com");
    }
    /*
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_v2.39_win32/chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("http://google.com");
   //     chromeDriver.findElement(By.name("q"));

       //  chromeDriver.findElement(By.xpath("//*[@name='q']"));
        // or by CSS selector ch
        WebElement element = chromeDriver.findElement(By.cssSelector("[name='q']"));
        element.sendKeys("chees!");
        element.sendKeys(Keys.ENTER); //simulate pressing Enter ...

        chromeDriver.quit();
    } */

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void googleSearch() {

        //     chromeDriver.findElement(By.name("q"));

        //  chromeDriver.findElement(By.xpath("//*[@name='q']"));
        // or by CSS selector ch
        WebElement element = driver.findElement(By.cssSelector("[name='q']"));
        element.sendKeys("chees!");
        element.sendKeys(Keys.ENTER); //simulate pressing Enter

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();

            List<WebElement> searchResultElements = driver.findElements(By.className("g"));

            assertTrue(searchResultElements.size()>0);

        }
    }
}
