package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ParametrizationExample {
    private WebDriver driver;

    @DataProvider(name = "search")
    public static Object[][] provideSearchInputs() {
        return new Object[][]{{"banana"}, {"apple"}};
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    /*
    DDT in action - test will be executed 2 times with different search inputs
     */
    @Test(dataProvider = "search")
    public void testOne(String searchInput) throws Exception {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(searchInput);
        element.submit();
        assertTrue(driver.findElements(By.className("g")).size() > 0);
    }

}
