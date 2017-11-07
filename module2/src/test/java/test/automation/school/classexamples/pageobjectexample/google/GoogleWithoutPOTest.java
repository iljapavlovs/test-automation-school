package test.automation.school.classexamples.pageobjectexample.google;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GoogleWithoutPOTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://google.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGoogleSearchCheese() throws Exception {
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.clear();
        inputField.sendKeys("Cheese!");
        inputField.submit();
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("g")));
        List<WebElement> searchResultElements = driver.findElements(By.className("g"));
        WebElement firstSearchResultLink = searchResultElements.get(0).findElement(By.cssSelector(".r a"));
        assertTrue(firstSearchResultLink.getText().toLowerCase().contains("cheese"));
    }

    @Test
    public void testGoogleSearchApple() throws Exception {
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.clear();
        inputField.sendKeys("Apple!");
        inputField.submit();
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("g")));
        List<WebElement> searchResultElements = driver.findElements(By.className("g"));
        WebElement firstSearchResultLink = searchResultElements.get(0).findElement(By.cssSelector(".r a"));
        assertTrue(firstSearchResultLink.getText().toLowerCase().contains("apple"));
    }
}
