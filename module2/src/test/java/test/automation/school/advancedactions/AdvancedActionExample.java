package test.automation.school.advancedactions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertFalse;

public class AdvancedActionExample {


    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();


        driver.get("http://the-internet.herokuapp.com/hovers/");
        String currentUrl = driver.getCurrentUrl();

        WebElement imageElement = driver.findElement(By.cssSelector(".figure img"));

        Actions builder = new Actions(driver);

        builder.moveToElement(imageElement)
                .moveToElement(driver.findElement(By.linkText("View profile")))
                .click()
                .build()
                .perform();


        assertFalse(currentUrl.equals(driver.getCurrentUrl()));
    }
}
