package test.automation.school.classexamples.elementpresence;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementPresenceExample {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        // element is not displayed, but is present in the DOM - hence findElement() does not throw NoSuchElemenetException
        WebElement notDisplayedButPresentElement = driver.findElement(By.id("finish"));
        //returns 'false'
        System.out.println(notDisplayedButPresentElement.isDisplayed());


        //TODO - Don`t forget to close the browser manually
    }

}
