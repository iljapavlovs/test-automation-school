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
        searchInputElement.sendKeys("banana", Keys.ENTER);


        List<WebElement> elements = driver.findElements(By.className("g"));
        System.out.println(elements.size() > 0);

        searchInputElement = driver.findElement(By.name("q"));

        searchInputElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "new banana", Keys.ENTER);


    }
}
