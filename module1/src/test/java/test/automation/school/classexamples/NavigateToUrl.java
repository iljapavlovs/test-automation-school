package test.automation.school.classexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToUrl {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");

        // when we create new webdriver instance then a new browser is opened depending on which driver was used (e.g. in this case Chrome)
        WebDriver driver = new ChromeDriver();

        // driver.get("<aut URL>") navigates to desired URL
        driver.get("http://www.google.com");
    }
}
