package test.automation.school.classexamples.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebElementActionExample {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement searchInputElement = driver.findElement(By.name("q"));

        // sendKeys() and Selenium`s Keys enum
        searchInputElement.sendKeys("apple", Keys.ENTER);
        searchInputElement = driver.findElement(By.name("q"));

        //when using sendkeys multiple times, then it will append the text
        searchInputElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "banana");
        searchInputElement.sendKeys("new banana");

        // clear()
        // need to clear the input first if smth already is written. Otherwise, text will be concatenated
        searchInputElement.clear();
        searchInputElement.sendKeys("apple");

        //submit()
        searchInputElement.submit();
        List<WebElement> elementList = driver.findElements(By.className("g"));

        // click()
        //chaining example
        elementList.get(0).findElement(By.tagName("a")).click();
    }
}
