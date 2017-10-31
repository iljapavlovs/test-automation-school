package test.automation.school.seleniumgrid;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        //no need to set browser driver and browser binary path, since execution will be remote
//        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        DesiredCapabilities cap = DesiredCapabilities.firefox();       // Request the desired browser (internetExplorer or chrome)
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


    @Test
    public void googleMilkExample() throws Exception {


        // And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.clear();
        element.sendKeys("Milk!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("milk!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
