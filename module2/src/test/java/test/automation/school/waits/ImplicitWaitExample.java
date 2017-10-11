package test.automation.school.waits;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //sets maximum 10 second wait for each 'findElement/s()' method
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.macys.com/");

        // waits under 10 seconds before element is located in the DOM, otherwise NuSuchElementException is thrown
        WebElement closeButton = driver.findElement(By.id("closeButton"));
        closeButton.click();

        //...

        // also waits under 10 seconds before element is located in the DOM, otherwise NuSuchElementException is thrown
        WebElement globalSearchInputField = driver.findElement(By.id("globalSearchInputField"));
        globalSearchInputField.sendKeys("smth");
    }


}
