package test.automation.school;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_v2.39_win32/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();

        chromeDriver.get("http://google.com");
   //     chromeDriver.findElement(By.name("q"));

       //  chromeDriver.findElement(By.xpath("//*[@name='q']"));
        // or by CSS selector ch
        WebElement element = chromeDriver.findElement(By.cssSelector("[name='q']"));
        element.sendKeys("chees!");
        element.sendKeys(Keys.ENTER); //simulate pressing Enter


    }

}
