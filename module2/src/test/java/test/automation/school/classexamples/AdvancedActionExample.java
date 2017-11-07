package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvancedActionExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();


        driver.get("http://the-internet.herokuapp.com/hovers");
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Locate element which
        WebElement imageElement = driver.findElement(By.cssSelector(".figure img"));

        // Create object of Actions class
        Actions builder = new Actions(driver);

        // Configure the action
        builder.moveToElement(imageElement)
                .moveToElement(driver.findElement(By.linkText("View profile")))
                .click()
                //get all actions as one
                .build()
                //perform the action
                .perform();


        System.out.println("Current URL: " + driver.getCurrentUrl());
    }
}
