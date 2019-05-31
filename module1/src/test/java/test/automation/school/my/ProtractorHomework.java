package test.automation.school.my;

import com.gargoylesoftware.htmlunit.html.impl.SelectionDelegate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProtractorHomework {
    private WebDriver driver;
    private WebElement leftNumberElement;
    private WebElement rightNumberElement;
    private WebElement computeButtonElement;
    @BeforeMethod
    public void setUp() throws Exception {
        PrepareDriver();
        PrepareElements();
    }

    private void PrepareElements() {
        leftNumberElement = driver.findElement(By.cssSelector("[ng-model='first']"));
        rightNumberElement = driver.findElement(By.cssSelector("[ng-model='second'"));
        computeButtonElement = driver.findElement(By.cssSelector("[ng-click='doAddition()']"));
    }

    private void PrepareDriver() {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.39-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://juliemr.github.io/protractor-demo/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void additionTest() throws Exception {
        leftNumberElement.sendKeys("5");
        rightNumberElement.sendKeys("5");
        computeButtonElement.click();

        Thread.sleep(4000);

        WebElement resultElement = driver.findElement(By.cssSelector("h2"));
        assertTrue(resultElement.getText().equals("10"));
    }

    @Test
    public void multipleOperationsTest() throws Exception {
        leftNumberElement.sendKeys("1");
        rightNumberElement.sendKeys("1");
        computeButtonElement.click();

        Thread.sleep(4000);

        leftNumberElement.sendKeys("2");
        rightNumberElement.sendKeys("2");
        computeButtonElement.click();

        Thread.sleep(4000);

        leftNumberElement.sendKeys("3");
        rightNumberElement.sendKeys("3");
        computeButtonElement.click();

        Thread.sleep(4000);

        List<WebElement> resultRows = driver.findElements(By.cssSelector("[ng-repeat='result in memory']"));
        assertTrue(resultRows.size() == 3);
    }

    @Test
    public void substractionTest() throws Exception {
        leftNumberElement.sendKeys("10");
        rightNumberElement.sendKeys("7");
        Select dropdownElement = new Select(driver.findElement(By.cssSelector("[ng-model='operator']")));
        dropdownElement.selectByVisibleText("-");
        computeButtonElement.click();

        Thread.sleep(4000);
        WebElement resultElement = driver.findElement(By.cssSelector("h2"));
        assertTrue(resultElement.getText().equals("3"));
    }
}
