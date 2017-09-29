package test.automation.school.classexamples;

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
        searchInputElement.sendKeys("apple", Keys.ENTER);


        List<WebElement> elements = driver.findElements(By.className("g"));
        System.out.println(elements.size() > 0);

        searchInputElement = driver.findElement(By.name("q"));

        //when using sendkeays multiple times, then it will append the text
        searchInputElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "banana");
        searchInputElement.sendKeys("new banana");
        //need to clear the input
        searchInputElement.clear();

        searchInputElement.sendKeys("apple", Keys.ENTER);
        List<WebElement> elementList = driver.findElements(By.className("g"));
        System.out.println(elementList.size());
        //chaining
        elementList.get(0).findElement(By.tagName("a")).click();
    }
}
