package test.automation.school.module1.api;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverApi {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();


        driver.manage().window().setSize(new Dimension(300, 450));

        driver.get("http://www.google.com");

        System.out.println("Current Page Title is: " + driver.getTitle());
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        WebElement webElement = driver.findElement(By.name("q"));
//        List<WebElement> webElementList = driver.findElements();


        driver.close();
        driver.quit();


    }
}
