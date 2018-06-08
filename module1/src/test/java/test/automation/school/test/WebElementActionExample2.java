package test.automation.school.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WebElementActionExample2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.google.com");
        WebElement inptSearch = driver.findElement(By.cssSelector("[name='q']"));
        inptSearch.sendKeys("apple", Keys.ENTER);
               //inptSearch.sendKeys("banana"); page reloaded and will cause StaleElementException exception

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inptSearch  =driver.findElement(By.cssSelector("[name='q']"));

        inptSearch.clear();

        inptSearch.sendKeys("banana");
        inptSearch.sendKeys(Keys.CONTROL + "a");
        inptSearch.sendKeys("new banana");

        List<WebElement> divSearchResults = driver.findElements(By.cssSelector(".g"));
        divSearchResults.get(0).findElement(By.cssSelector("a")).click();

        //driver.quit();

    }

}
