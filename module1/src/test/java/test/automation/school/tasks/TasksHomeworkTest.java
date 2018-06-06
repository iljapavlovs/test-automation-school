package test.automation.school.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TasksHomeworkTest {
    
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.bin", "C:/tools/Firefox/firefox.exe");
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
        
        driver = new FirefoxDriver();
        driver.get("http://juliemr.github.io/protractor-demo/");
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyPageTitleTest() {
        assertEquals(driver.getTitle(), "Super Calculator");
    }

    @Test
    public void sumUpTwoValuesTest() {
        WebElement inptFirstNumber = driver.findElement(By.cssSelector("input[ng-model='first']"));
        WebElement inptSecondNumber = driver.findElement(By.cssSelector("input[ng-model='second']"));
        WebElement btnOperator = driver.findElement(By.cssSelector("select[ng-model='operator']"));
        WebElement lblanswer = driver.findElement(By.cssSelector(".ng-binding"));

        inptFirstNumber.sendKeys("4");
        btnOperator.click();
        btnOperator.findElement(By.cssSelector("[value='MULTIPLICATION']")).click();
        inptSecondNumber.sendKeys("4", Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(lblanswer.getText(),"16");
    }

    @Test
    public void countTheNumberOfActionTest() throws InterruptedException {

        WebElement inptFirstNumber = driver.findElement(By.cssSelector("input[ng-model='first']"));
        WebElement inptSecondNumber = driver.findElement(By.cssSelector("input[ng-model='second']"));

        inptFirstNumber.sendKeys("4");
        inptSecondNumber.sendKeys("4", Keys.ENTER);
        Thread.sleep(3000);

        inptFirstNumber.sendKeys("4");
        inptSecondNumber.sendKeys("5", Keys.ENTER);
        Thread.sleep(3000);

        List<WebElement> actionsEntries = driver.findElements(By.cssSelector("[ng-repeat='result in memory']"));
        assertEquals(actionsEntries.size(),2);

    }
}
