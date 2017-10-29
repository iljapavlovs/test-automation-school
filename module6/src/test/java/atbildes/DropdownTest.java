package atbildes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class DropdownTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void selectByTextTest() throws Exception {
        //TODO 1 - select dropdown option by "Option 2" text and verify that this element was selected
        String dropdownOptionText = "Option 2";
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByVisibleText(dropdownOptionText);
        assertEquals(selectDropdown.getFirstSelectedOption().getText(), dropdownOptionText);
        //TODO 1
    }


    @Test
    public void selectByValueTest() throws Exception {
        //TODO 2 - select dropdown option by value of "Option 1" element and verify that this element was selected
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByValue("1");
        assertEquals(selectDropdown.getFirstSelectedOption().getText(), "Option 1");
        //TODO 2
    }


    @Test
    public void retrieveAllOptionsTest() throws Exception {
        //TODO 3 - check that actual dropdown options have following text values and order: 'Please select an option', 'Option 1', 'Option 2'
        // NOTE - recall how to compare Collections in Java
        // remember - List is an ordered data structure so the order of elements matters.
        // hence - "two Lists are defined to be equal if they contain the same elements in the same order.", hence you can use assertEquals for comparing 2 lists
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select selectDropdown = new Select(dropdown);

        List<String> actualList = new ArrayList<>();
        for (WebElement element : selectDropdown.getOptions()) {
            actualList.add(element.getText());
        }

        List<String> expectedList = Arrays.asList("Please select an option", "Option 1", "Option 2");
        assertEquals(actualList, expectedList);

        //TODO 3
    }


}
