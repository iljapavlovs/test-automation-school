package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownExample {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByVisibleText("Option 1");
        System.out.println("getFirstSelectedOption(): " + selectDropdown.getFirstSelectedOption().getText());
        selectDropdown.selectByValue("2");
        System.out.println("getAllSelectedOptions(): " + selectDropdown.getAllSelectedOptions().get(0).getText());
        System.out.println("getFirstSelectedOption(): " + selectDropdown.getFirstSelectedOption().getText());


        for (WebElement element : selectDropdown.getOptions()) {
            System.out.println("JAVA 7 getOptions(): " + element.getText());
        }

        //JAVA 8 example
        System.out.println("JAVA 8 getOptions: " + selectDropdown.getOptions().stream().map(WebElement::getText).collect(Collectors.toList()));

        System.out.println("Is dropdown multiple: " + selectDropdown.isMultiple());


        List<WebElement> allOptions = dropdown.findElements(By.tagName("option"));

        //JAVA 7
        for (WebElement option : allOptions) {
//            if (option.getAttribute("value").equals("1"))
            if (option.getText().equals("Option 1")) {
                System.out.println(String.format("Value is: %s", option.getAttribute("value")));
                option.click();
            }

        }

        System.out.println("JAVA 7 getFirstSelectedOption(): " + selectDropdown.getFirstSelectedOption().getText());


        //JAVA 8 - utilizing Java Stream API and Lambdas
        allOptions.stream()
                .filter(elem -> elem.getText().equals("Option 2"))
                .findFirst()
                .ifPresent(elem -> elem.click());
        System.out.println("JAVA 8 getFirstSelectedOption(): " + selectDropdown.getFirstSelectedOption().getText());


        //TODO - Don`t forget to close the browser manually
    }
}
