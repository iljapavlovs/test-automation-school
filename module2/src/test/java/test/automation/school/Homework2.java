package test.automation.school;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class Homework2 {

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

    //* todo 1. Write simple test that navigates to http://juliemr.github.io/protractor-demo/ and checks its title

    //todo 2. Sum up some two values and wait for the result * Use Thread.sleep() to wait for element to load (but use it only ofr this homework,
    // since "Waiting" topic will be discussed in upcoming sessions)


    //todo 3. Do multiple mathematical actions and count the number of actions



}
