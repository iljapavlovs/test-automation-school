package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaleElementExceptionExample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.firefox.bin", "C:/tools/Firefox/firefox.exe");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.20.1-win64/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("banana");
        element.submit();

        //wait for page to load
        Thread.sleep(3000);

        /* *WebElement*
        All method calls will do a freshness check to ensure that the element reference is still valid.
        This essentially determines whether or not the element is still attached to the DOM.
        If this test fails, then an StaleElementReferenceException is thrown, and all future calls to this instance will fail.
         */

        //following action will throw StaleElementReferenceException since previous action invoked page
        element.sendKeys("new banana");


    }
}