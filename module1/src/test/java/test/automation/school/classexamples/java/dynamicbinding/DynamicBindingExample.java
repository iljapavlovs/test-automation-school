package test.automation.school.classexamples.java.dynamicbinding;


import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicBindingExample {

    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        HomePage homePage = new HomePage(driver);
    }
}
