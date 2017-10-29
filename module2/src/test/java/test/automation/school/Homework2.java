package test.automation.school;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Homework2 {

    //* Each test is Autonomous - test is not dependant on any other tests and can be run in parallel
    // Note how important to set the initial state before every test - calculator state is changed after each operation and it will affect 'testMathAction' test
    //* Each test is Atomic - tests only one functionality
    //* Each test is Small - does not


    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://juliemr.github.io/protractor-demo/");
    }

    //* todo 1. Write simple test that navigates to http://juliemr.github.io/protractor-demo/ and checks its title
    @Test
    public void testTitle() throws Exception {
        assertEquals(driver.getTitle(), "Super Calculator");
    }

    //todo 2. Sum up some two values and wait for the result * Use Thread.sleep() to wait for element to load (but use it only ofr this homework,
    // since "Waiting" topic will be discussed in upcoming sessions)
    @Test
    public void testMathAction() throws Exception {
        WebElement firstNumberInput = driver.findElement(By.cssSelector("[ng-model='first']"));
        WebElement secondNumberInput = driver.findElement(By.cssSelector("[ng-model='second']"));
        WebElement goButton = driver.findElement(By.id("gobutton"));

        firstNumberInput.sendKeys("1");
        secondNumberInput.sendKeys("2");
        goButton.click();

        Thread.sleep(5000);
        String resultLabelText = driver.findElement(By.cssSelector("h2")).getText();

        assertEquals(resultLabelText, "3");
    }

    //todo 3. Do multiple mathematical actions and count the number of actions
    @Test
    public void testListOfActionsPerfomed() throws Exception {
        WebElement firstNumberInput = driver.findElement(By.cssSelector("[ng-model='first']"));
        WebElement secondNumberInput = driver.findElement(By.cssSelector("[ng-model='second']"));
        WebElement goButton = driver.findElement(By.id("gobutton"));

        firstNumberInput.sendKeys("1");
        secondNumberInput.sendKeys("2");
        goButton.click();

        Thread.sleep(5000);

        //no need to have following asserts, since it is verified in other test
//        assertEquals(result, "3");
//        assertEquals(resultLabelText, "3");

        firstNumberInput.sendKeys("1");
        secondNumberInput.sendKeys("2");
        goButton.click();

        Thread.sleep(5000);

        List<WebElement> resultList = driver.findElements(By.cssSelector("[ng-repeat='result in memory']"));

        assertEquals(resultList.size(), 2);

        //TODO - NOTE that no StaleElementException is thrown, since app is not rerenderred every time

    }


}
