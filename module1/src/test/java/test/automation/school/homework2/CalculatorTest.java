package test.automation.school.homework2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {
    /*
    * * Write simple test that navigates to http://juliemr.github.io/protractor-demo/ and checks its title
* Sum up some two values and wait for the result
    * Use Thread.sleep() to wait for element to load (but use it only ofr this homework, since "Waiting" topic will be discussed in upcoming sessions)
* Do multiple mathematical actions and count the number of actions


1. Think about - how to make the tests Small, Atomic (One test - one clear goal, TC should verify only one functionality) and Autonomous. In order to do that, examine
 * how many features are tested
 * can or should those features be divided into separate test
2. Try to use CSS Selectors instead of XPath

    * */

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver_v2.39_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://juliemr.github.io/protractor-demo/");
    }

//    @AfterClass
//    public void tearDown() throws Exception {
//        driver.quit();
//    }

    @Test
    public void  checkPageTitle() throws Exception {
        assertEquals( driver.getTitle(), "Super Calculator");
        System.out.println(driver.getTitle());

    }

    @Test
    public void  sumTwoValuesResult() throws Exception {
        WebElement input1 = driver.findElement(By.xpath("/html/body/div/div/form/input[1]"));
        input1.sendKeys("27");

        WebElement input2 = driver.findElement(By.xpath("/html/body/div/div/form/input[2]"));
        input2.sendKeys("34");

        Select select = new Select(driver.findElement(By.xpath("/html/body/div/div/form/select")));
        select.selectByValue("ADDITION");

        WebElement calculateBtn = driver.findElement(By.className("btn"));
        calculateBtn.click();

        Thread.sleep(3000);

        WebElement recentResult = driver.findElement(By.xpath("/html/body/div/div/form/h2"));
        System.out.println(recentResult.getText());

        assertEquals((recentResult.getText()), "61"); //text, check converstion to int
    }

    @Test
    public void  availableOperNum() throws Exception {
        Select select = new Select(driver.findElement(By.xpath("/html/body/div/div/form/select")));

        System.out.println("number of availabe operations: " +select.getOptions().size());

        WebElement input1 = driver.findElement(By.xpath("/html/body/div/div/form/input[1]"));
        input1.sendKeys("27");
        WebElement input2 = driver.findElement(By.xpath("/html/body/div/div/form/input[2]"));
        input2.sendKeys("34");
        select = new Select(driver.findElement(By.xpath("/html/body/div/div/form/select")));
        select.selectByValue("SUBTRACTION");

        WebElement calculateBtn = driver.findElement(By.className("btn"));
        calculateBtn.click();

        Thread.sleep(3000);

        input1.sendKeys("10");
        input2.sendKeys("3");
        select.selectByValue("MODULO");
        calculateBtn.click();

        Thread.sleep(3000);

        input1.sendKeys("7");
        input2.sendKeys("8");
        select.selectByVisibleText("*");
        calculateBtn.click();

    }

}