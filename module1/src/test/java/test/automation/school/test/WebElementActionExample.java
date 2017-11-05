package test.automation.school.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by S1EAMK on 2017.10.18..
 */
public class WebElementActionExample {


    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
//
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement searchInputElement = driver.findElement(By.name("q"));

        searchInputElement.sendKeys("apple" + Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        searchInputElement = driver.findElement(By.name("q"));

        searchInputElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "banana");

        searchInputElement.submit();

        List<WebElement> elementList = driver.findElements(By.className("g"));

        // click()
        //chaining example
        elementList.get(0).findElement(By.tagName("a")).click();

//        searchInputElement.clear();
//        searchInputElement.sendKeys("new apple");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
