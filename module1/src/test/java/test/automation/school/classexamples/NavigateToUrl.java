package test.automation.school.classexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToUrl {
    public static void main(String[] args) {
        // If Firefox is installed other than in 'Program Files' folder, then Selenium needs to know where to find the Firefox binary file (firefox.exe)
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        // Selenium needs to know wehere to find Browser`s Driver. Sets by 'webdriver.<driver name>.driver' env variable
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");

        // when we create new webdriver instance then a new browser is opened depending on which driver was used (e.g. in this case Chrome)
        WebDriver driver = new ChromeDriver();

        // driver.get("<URL>") navigates to desired URL in the opened browser type- in this case Chrome
        driver.get("http://www.google.com");
    }
}
