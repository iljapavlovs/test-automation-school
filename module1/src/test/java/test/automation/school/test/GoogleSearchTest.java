package test.automation.school.test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {
    FirefoxDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }


    @Test
    public void testSearchResult(){

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("cheese" + Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // will find all elements with class='g'
        List<WebElement> list =  driver.findElements(By.cssSelector(".g"));
        assertTrue(list.size()>0);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
