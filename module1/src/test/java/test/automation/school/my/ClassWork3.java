package test.automation.school.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassWork3 {
    private WebDriver driver;
    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers//chromedriver-v2.30-win32/chromedriver.exe");
    }
    @BeforeMethod
    public void setUpBeforeMethod() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://jedwatson.github.io/react-select/");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void dropdownTest() throws Exception {


        WebElement statesDropdown = driver.findElement(By.cssSelector(".State-NSW"));

        System.out.println("Is dropdown enabled: " + statesDropdown.isEnabled());
        WebElement disableStatesDropdownCheckbox = driver.findElement(By.xpath("//input[following-sibling::*[text()='Disabled']]"));
        System.out.println("isSelected() :" + disableStatesDropdownCheckbox.isSelected());

        disableStatesDropdownCheckbox.click();

        statesDropdown = driver.findElement(By.cssSelector(".State-NSW"));

        System.out.println("Is dropdown enabled: " + statesDropdown.isEnabled());
        System.out.println("isSelected() :" + disableStatesDropdownCheckbox.isSelected());
        System.out.println("getCssValue(visibility): " + statesDropdown.getCssValue("visibility"));
        System.out.println("getCssValue(opacity): " + statesDropdown.getCssValue("opacity"));


    }
}
