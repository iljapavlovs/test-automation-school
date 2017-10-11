package test.automation.school.classexamples.java;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DynamicBinding {

//    @Test
//    public void testSearch() throws Exception {
//        //assigning new object ('new FirefoxDriver()') to a variable ('driver') with a concrete type ('FirefoxDriver')
//        FirefoxDriver driver = new FirefoxDriver();
//        driver.get("http://www.google.com");
//
//        // COMPILATION ERROR: Incompatible types
//        driver = new ChromeDriver();
//    }

    @Test
    public void testSearch2() throws Exception {
        //assigning new object ('new FirefoxDriver()') to a variable ('driver') with a concrete type ('FirefoxDriver')
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        // NO COMPILATION ERROR
        driver = new ChromeDriver();
    }
}
