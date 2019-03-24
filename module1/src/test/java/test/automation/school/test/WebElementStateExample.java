package test.automation.school.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementStateExample {

    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.20.1-win64/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

//        driver.get("http://www.google.com");
//        WebElement inptSearch = driver.findElement(By.cssSelector("[name='q']"));
//
//        System.out.println("Search input: " + inptSearch.isDisplayed());

//        driver.get("http://the-internet.herokuapp.com/checkboxes");
//        //use xpath
//        WebElement chkbxFisrtInput = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
//        System.out.println("First checkbox: " + chkbxFisrtInput.isSelected());
//        System.out.println("First checkbox attr : "+chkbxFisrtInput.getAttribute("checked"));
//
//        chkbxFisrtInput.click();
//        System.out.println("First checkbox attr2 : "+chkbxFisrtInput.getAttribute("checked"));
//
//        WebElement headerElement  = driver.findElement(By.cssSelector("h3"));
//        System.out.println("header text: " + headerElement.getText());
//
//        WebElement divSection = driver.findElement(By.cssSelector("div.example"));
//        System.out.println("Section text: "+ divSection.getText());

        driver.get("https://jedwatson.github.io/react-select/");

        WebElement drpdwnFirts = driver.findElement(By.cssSelector(".State-NSW"));
        System.out.println("Drop down is enabled: " + drpdwnFirts.isEnabled());

        WebElement disableStatesDropdownCheckbox = driver.findElement(By.xpath("//input[following-sibling::*[text()='Disabled']]"));
        System.out.println("not enabled drop dows"+ disableStatesDropdownCheckbox.isEnabled());

        disableStatesDropdownCheckbox.click();

        drpdwnFirts = driver.findElement(By.cssSelector(".State-NSW"));
        System.out.println("Drop down after click is enabled: " + drpdwnFirts.isEnabled());


    }

}
