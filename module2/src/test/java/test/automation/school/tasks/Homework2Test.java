package test.automation.school.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Homework2Test {

    //* Each test is Autonomous - test is not dependant on any other tests and can be run in parallel
    // Note how important to set the initial state before every test - calculator state is changed after each operation and it will affect 'testMathAction' test
    //* Each test is Atomic - tests only one functionality
    //* Each test is Small - does not


    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://juliemr.github.io/protractor-demo/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

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

        WebElement operationDropdown = driver.findElement(By.cssSelector("[ng-model='operator']"));
        Select operationDropdownSelect = new Select(operationDropdown);
        operationDropdownSelect.selectByValue("MULTIPLICATION");


        WebElement goButton = driver.findElement(By.cssSelector("#gobutton"));

        firstNumberInput.sendKeys("1");
        secondNumberInput.sendKeys("2");


        goButton.click();


        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("h2")), "2"));

        String resultLabelText = driver.findElement(By.cssSelector("h2")).getText();
        assertEquals(resultLabelText, "2");
    }


    //todo 3. Do multiple mathematical actions and count the number of actions


    @Test
    public void testListOfActionsPerformed() throws Exception {
        WebElement firstNumberInput = driver.findElement(By.cssSelector("[ng-model='first']"));
        WebElement secondNumberInput = driver.findElement(By.cssSelector("[ng-model='second']"));
        WebElement goButton = driver.findElement(By.cssSelector("#gobutton"));

        WebElement operationDropdown = driver.findElement(By.cssSelector("[ng-model='operator']"));
        Select operationDropdownSelect = new Select(operationDropdown);
        operationDropdownSelect.selectByValue("SUBTRACTION");

        firstNumberInput.sendKeys("2");
        secondNumberInput.sendKeys("1");
        goButton.click();

        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("h2")), "1"));

        firstNumberInput.sendKeys("3");
        secondNumberInput.sendKeys("1");
        operationDropdownSelect.selectByValue("SUBTRACTION");
        goButton.click();

        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("h2")), "2"));

        List<WebElement> resultList = driver.findElements(By.cssSelector("[ng-repeat='result in memory']"));

        assertEquals(resultList.size(), 2);
    }

}
