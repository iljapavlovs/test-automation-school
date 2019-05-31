package test.automation.school.my;

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

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver(); //ctrl+ alt+v new ChromeDriver()
        driver.get("http://google.com");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void googleSearch() {
        WebElement element = driver.findElement(By.name("q"));// driver.findElement(By.cssSelector("[name='q']"));
        element.sendKeys("cheese!");
        element.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> cheeseSearchResults = driver.findElements(By.className("g"));
        boolean areElementsVisible = false;
        for (WebElement e : cheeseSearchResults) {
            if (!e.isDisplayed()) {
                areElementsVisible = false;
                return;
            } else {
                areElementsVisible = true;
            }
        }
        assertTrue(areElementsVisible);

    }
}