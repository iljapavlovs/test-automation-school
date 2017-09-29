package test.automation.school;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class WaitExamples {
    WebDriver driver;
    WebDriverWait wait;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10);
        driver.get("http://www.google.com");

    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @Test
    public void mySecondTest() {
        driver.navigate().to("http://www.google.com");
        wait.until(d -> d.findElement(By.name("q"))).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @Test
    public void myThirdTest() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }


    public void waitUntilElemIsDisabled(WebElement element) {
        try {
            wait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return !element.isEnabled();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void waitUntilElemIsDisabledLambda(WebElement element) {

        wait.until(d -> !element.isEnabled());

    }
}
