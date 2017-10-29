package test.automation.school.classexamples.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateToUrl {
    public static void main(String[] args) {
        // If Firefox is installed other than in 'Program Files' folder, then Selenium needs to know where to find the Firefox binary file (firefox.exe)
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");

        // Selenium needs to know wehere to find Browser`s Driver. Sets by 'webdriver.<driver name>.driver' env variable
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");

        // when we create new webdriver instance then a new browser is opened depending on which driver was used (e.g. in this case Firefox)
        WebDriver driver = new FirefoxDriver();

        /*
        The same for Chrome browser:
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        */

        // driver.get("<URL>") navigates to desired URL in the opened browser type- in this case Chrome
        driver.get("http://www.google.com");


        //TODO - Don`t forget to close the browser manually
    }
}
