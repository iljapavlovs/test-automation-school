package atbildes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class WebElementStateTest {


    private WebDriver driver;

    //TODO - tests should use new browser instance for each test method

    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance
    //
    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
    }
    //TODO 1


    @BeforeMethod
    public void setUpBeforeMethod() throws Exception {
        driver = new FirefoxDriver();

    }


    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    //TODO 2


    //TODO 3 - Create TestNg Test method which navigates http://the-internet.herokuapp.com/checkboxes
    //TODO 3 - verify that all checkboxes are displayed
    // Hint - you have to iterate through a Collection
    @Test
    public void isDisplayedTest() throws Exception {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//*[@id='checkboxes']/input"));

        for (WebElement element : checkBoxList) {
            assertTrue(element.isDisplayed());
        }
    }
    //TODO 3


    //TODO 4 - Create TestNg Test method which navigates http://the-internet.herokuapp.com/checkboxes
    //TODO 4 - test checkbox "selected" and "unselected" feature using 'isSelected()' method. You can check it on one checkbox
    @Test
    public void isSelectedTest() throws Exception {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckBox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        assertFalse(firstCheckBox.isSelected());
        firstCheckBox.click();
        assertTrue(firstCheckBox.isSelected());
        firstCheckBox.click();
        assertFalse(firstCheckBox.isSelected());
    }
    //TODO 4


    //TODO 5 - Create TestNg Test method which navigates http://the-internet.herokuapp.com/checkboxes
    //TODO 5 - test checkbox feature for 'checking' and 'unchecking' using 'getAttribute()' method. You can check it on one checkbox
    @Test
    public void getAttributeTest() throws Exception {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckBox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        assertNull(firstCheckBox.getAttribute("checked"));
        firstCheckBox.click();
        assertTrue(Boolean.parseBoolean(firstCheckBox.getAttribute("checked")));
        assertEquals(firstCheckBox.getAttribute("checked"), "true");
        firstCheckBox.click();
        assertNull(firstCheckBox.getAttribute("checked"));
    }
    //TODO 5


    //TODO 6 - Create TestNg Test method which navigates http://the-internet.herokuapp.com/checkboxes
    //TODO 6 - check that header text is equal to "Checkboxes"
    //TODO 6 - think how to retrieve all visible text on the page and verify it`s content
    @Test
    public void getTextTest() throws Exception {
        driver.get("http://the-internet.herokuapp.com/checkboxes");

        //getText()
        WebElement mainHeader = driver.findElement(By.cssSelector(".example h3"));
        assertEquals(mainHeader.getText(), "Checkboxes");

        //getText() from sub-elements (child elements)
        WebElement divElement = driver.findElement(By.cssSelector("div.example"));
        System.out.println(driver.findElement(By.cssSelector("div.example")));

        assertEquals(divElement.getText(), "Checkboxes\n" +
                "checkbox 1\n" +
                "checkbox 2");

    }
    //TODO 6

    //TODO 7 - Create TestNg Test method which navigates https://jedwatson.github.io/react-select/
    //TODO 7 - veri
    @Test
    public void dropdownTest() throws Exception {
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


    }
    //TODO 7


    //TODO 8 - Create TestNg Test method which navigates http://akveo.com/blur-admin-mint/#/ui/typography
    //TODO 8 - verify that red text paragraph is actually red
    // to check rgba use https://www.hexcolortool.com/#e85454 or other sites
    @Test
    public void getCssValue() throws Exception {
        driver.get("http://akveo.com/blur-admin-mint/#/ui/typography");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement redText = driver.findElement(By.cssSelector(".red-text p"));
        assertEquals(redText.getCssValue("color"), "rgb(232, 86, 86)");
    }

}
