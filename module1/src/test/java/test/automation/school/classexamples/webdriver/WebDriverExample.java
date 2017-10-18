package test.automation.school.classexamples.webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");

        //There are bunch of elements with link text 'delete'
        // findElement() - will find only one and the first weblement with link text 'delete'
        driver.findElement(By.linkText("delete")).click();

        // findElements() - will find all elements with link text 'delete'
        System.out.println("WebElement List size: " + driver.findElements(By.linkText("delete")).size());

        // since findElements() returns a List of WebElements, then we can work with it as with a Collection (List)
        driver.findElements(By.linkText("delete")).get(1).click();

        System.out.println("Page Title: " + driver.getTitle());

        System.out.println("Page URL: " + driver.getCurrentUrl());

        driver.quit();

    }
}
