package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionExample {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("banana");
        element.submit();

        /* *WebElement*
        All method calls will do a freshness check to ensure that the element reference is still valid.
        This essentially determines whether or not the element is still attached to the DOM.
        If this test fails, then an StaleElementReferenceException is thrown, and all future calls to this instance will fail.
         */

        //following action will throw StaleElementReferenceException since previos action invoked page
        element.sendKeys("new banana");


    }
}