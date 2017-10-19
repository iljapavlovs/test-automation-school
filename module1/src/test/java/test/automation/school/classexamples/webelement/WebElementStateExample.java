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
        //click()
        System.out.println("getAttribute(): " + firstCheckBox.getAttribute("checked"));
        firstCheckBox.click();
        //isSelected()
        System.out.println("isSelected() :" + firstCheckBox.isSelected());
        //getAttribute()
        System.out.println("getAttribute(): " + firstCheckBox.getAttribute("checked"));

        //getText()
        WebElement mainHeader = driver.findElement(By.cssSelector(".example h3"));
        System.out.println("Main Header text: " + mainHeader.getText());

        //getText() from sub-elements (child elements)
        WebElement divElement = driver.findElement(By.cssSelector("div.example"));
        System.out.println("Retrieving text also from sub-elements: " + divElement.getText());


        driver.get("https://jedwatson.github.io/react-select/");
        WebElement statesDropdown = driver.findElement(By.cssSelector(".State-NSW"));
        //isEnabled()
        System.out.println("Is dropdown enabled: " + statesDropdown.isEnabled());
        WebElement disableStatesDropdownCheckbox = driver.findElement(By.xpath("//input[following-sibling::*[text()='Disabled']]"));
        System.out.println("isSelected() :" + disableStatesDropdownCheckbox.isSelected());

        disableStatesDropdownCheckbox.click();

        statesDropdown = driver.findElement(By.cssSelector(".State-NSW"));
        //will return true since given dropdown is not a input field and isEnabled() method works only on <input> elements
        System.out.println("Is dropdown enabled: " + statesDropdown.isEnabled());
        System.out.println("isSelected() :" + disableStatesDropdownCheckbox.isSelected());
        System.out.println("getCssValue(visibility): " + statesDropdown.getCssValue("visibility"));
        System.out.println("getCssValue(opacity): " + statesDropdown.getCssValue("opacity"));


        driver.get("http://akveo.com/blur-admin-mint/#/ui/typography");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement redText = driver.findElement(By.cssSelector(".red-text p"));
        System.out.println("getCssValue(color): " + redText.getCssValue("color"));
    }
}
