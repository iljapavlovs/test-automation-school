package test.automation.school;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class New {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\repo\\vt selenium\\test-automation-school-master\\drivers\\chromedriver-v2.39-win32\\chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.google.com");
//        String baseUrl = "https://www.google.com";chromeDriver.get(baseUrl);
//        chromeDriver.findElement(By.name("q"));
        WebElement searchField = chromeDriver.findElement(By.cssSelector("[name='q']"));
//        chromeDriver.findElement(By.xpath("//*[@[name='q']]"));

        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

    }
}
