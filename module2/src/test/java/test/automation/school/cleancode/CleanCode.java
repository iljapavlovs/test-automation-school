package test.automation.school.cleancode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class CleanCode {


    //* Each test is Autonomous - test is not dependant on any other tests and can be run in parallel
    // Note how important to set the initial state before every test - calculator state is changed after each operation and it will affect 'testMathAction' test
    //* Each test is Atomic - tests only one functionality
    //* Each test is Small - does not


    private static final By FIRST_NUMBER_INPUT_LOCATOR = By.cssSelector("[ng-model='first']");
    private static final By SECOND_NUMBER_INPUT_LOCATOR = By.cssSelector("[ng-model='second']");
    private static final By OPERATION_DROPDOWN_LOCATOR = By.cssSelector("[ng-model='operator']");
    private static final By GO_BUTTON_LOCATOR = By.cssSelector("#gobutton");
    private static final By RESULT_LIST_LOCATOR = By.cssSelector("[ng-repeat='result in memory']");
    private static final By RESULT_LABEL_LOCATOR = By.cssSelector("h2");
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://juliemr.github.io/protractor-demo/");
        wait = new WebDriverWait(driver, 5);
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
        WebElement firstNumberInput = driver.findElement(FIRST_NUMBER_INPUT_LOCATOR);
        WebElement secondNumberInput = driver.findElement(SECOND_NUMBER_INPUT_LOCATOR);
        WebElement operationDropdown = driver.findElement(OPERATION_DROPDOWN_LOCATOR);
        selectOperation(operationDropdown, Operation.MULTIPLICATION);


        WebElement goButton = driver.findElement(GO_BUTTON_LOCATOR);

        firstNumberInput.sendKeys("1");
        secondNumberInput.sendKeys("2");


        goButton.click();


        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("h2")), "2"));

        String resultLabelText = driver.findElement(RESULT_LABEL_LOCATOR).getText();
        assertEquals(resultLabelText, "2");
    }


    //todo 3. Do multiple mathematical actions and count the number of actions


    @Test
    public void testListOfActionsPerformed() throws Exception {
        WebElement firstNumberInput = driver.findElement(FIRST_NUMBER_INPUT_LOCATOR);
        WebElement secondNumberInput = driver.findElement(SECOND_NUMBER_INPUT_LOCATOR);
        WebElement goButton = driver.findElement(GO_BUTTON_LOCATOR);

        WebElement operationDropdown = driver.findElement(OPERATION_DROPDOWN_LOCATOR);
        selectOperation(operationDropdown, Operation.SUBTRACTION);

        firstNumberInput.sendKeys("2");
        secondNumberInput.sendKeys("1");
        goButton.click();

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(RESULT_LABEL_LOCATOR), "1"));

        firstNumberInput.sendKeys("3");
        secondNumberInput.sendKeys("1");
        selectOperation(operationDropdown, Operation.SUBTRACTION);

        goButton.click();

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(RESULT_LABEL_LOCATOR), "2"));

        List<WebElement> resultList = driver.findElements(RESULT_LIST_LOCATOR);

        assertEquals(resultList.size(), 2);
    }

    private void selectOperation(WebElement operationDropdown, Operation operation) {
        Helper.selectByValueFromDropdown(operationDropdown, operation.getOperation());
    }

    private enum Operation {
        ADDITION("ADDITION"),
        DIVISION("DIVISION"),
        MODULO("MODULO"),
        MULTIPLICATION("MULTIPLICATION"),
        SUBTRACTION("SUBTRACTION");

        private String dropdownValue;

        Operation(String dropdownValue) {
            this.dropdownValue = dropdownValue;
        }

        public String getOperation() {
            return dropdownValue;
        }
    }
}
