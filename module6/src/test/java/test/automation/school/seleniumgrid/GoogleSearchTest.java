package test.automation.school.seleniumgrid;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        DesiredCapabilities cap = DesiredCapabilities.chrome();       // Request the desired browser (internetExplorer or chrome)
        cap.setCapability("project","test");                        // Project name for logging
        cap.setCapability("video", true);                                           // Set the video capability to true to capture the video
        driver = new RemoteWebDriver(new URL("http://selenium-hub:8080/wd/hub"),cap);


        String sessionId = ((RemoteWebDriver)driver).getSessionId().toString();                                            // Get the session id for the test
        String videoURL = "http://selenium-hub:8080/grid/resources/remote?session=" + sessionId;   // Get the Url for the video
        System.out.println("live, then video recording can be viewed @ " + videoURL);                   // Print the video Url to the console

        driver.get("http://www.google.com");
    }

    @Test
    public void testSearch() throws Exception {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        assertTrue(driver.getTitle().contains("Cheese!"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
