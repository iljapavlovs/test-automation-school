package test.automation.school.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.testng.Assert.assertTrue;

public class WebElementStateExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.firefox.bin", "C:/tools/Firefox/firefox.exe");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.20.1-win64/geckodriver.exe");


        WebDriver driver = new FirefoxDriver();

       /* driver.get("http://www.google.com");
        WebElement inptSearch = driver.findElement(By.cssSelector("[name='q']"));

        System.out.println("Search input: " + inptSearch.isDisplayed());
        */
       /* driver.get("http://the-internet.herokuapp.com/checkboxes");

        WebElement chxbFirstInput = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        System.out.println("First checkbox displayed: " + chxbFirstInput.isSelected());
        System.out.println("First cbx attribute" + chxbFirstInput.getAttribute("checked"));

        WebElement chxbSecondInput = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        System.out.println("First checkbox displayed: " + chxbSecondInput.isSelected());
        System.out.println("First cbx attribute: " + chxbSecondInput.getAttribute("checked"));

        WebElement headerTitle = driver.findElement(By.cssSelector("h3"));
        System.out.println("Headre text: "+ headerTitle.getText());

        WebElement headerSectionText = driver.findElement(By.cssSelector("div.example"));
        System.out.println("Headre section text: "+ headerSectionText.getText());*/

       driver.get("https://jedwatson.github.io/react-select/");
       driver.findElement(By.cssSelector(".State-NSW"));
    }

}
