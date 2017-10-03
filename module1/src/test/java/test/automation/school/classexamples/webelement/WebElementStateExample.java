package test.automation.school.classexamples.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementStateExample {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        WebElement searchInputElement = driver.findElement(By.name("q"));

        //isDisplayed()
        System.out.println(searchInputElement.isDisplayed());

        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckBox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));

        //isSelected()
        System.out.println("isSelected(): " + firstCheckBox.isSelected());
        //getAttribute()
        System.out.println("getAttribute(): " + firstCheckBox.getAttribute("checked"));
        firstCheckBox.click();
        //isSelected()
        System.out.println("isSelected() :" + firstCheckBox.isSelected());
        //getAttribute()
        System.out.println("getAttribute(): " + firstCheckBox.getAttribute("checked"));


    }
}
