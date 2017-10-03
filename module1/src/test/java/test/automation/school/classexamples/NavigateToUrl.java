package test.automation.school.classexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToUrl {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        // when we create new webdriver instance then a new browser is opened
        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");
    }
}
