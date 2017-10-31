package atbildes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
//        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\s1eamk\\AppData\\Local\\Microsoft\\AppV\\Client\\Integration\\590455D7-2D2E-48A6-9412-DD2A08B56F24\\Root\\VFS\\ProgramFilesX86\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver(options);
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

    @Test
    public void nonSelectDropdownTest() throws Exception {
        //TODO 4 - https://jqueryui.com/selectmenu/" - from the Speed dropdown select "Fast" option and verify that this option was selected
        //Hint - iFrame doesn`t have any id nor name, but there are no iframes in the page. Hence, you can switch to the frame by index. But regardless, always ping UI devs to add name or id for such cases!
        // Hint - Dropdown is not a <select> element, hence you can`t use Select class
        driver.get("https://jqueryui.com/selectmenu/");

        String speedOption = "Fast";

        driver.switchTo().frame(0);
        WebElement selectSpeedDropdown = driver.findElement(By.id("speed-button"));

        selectSpeedDropdown.click();

        /*
        //NOTE - verify how dropdown options appear -
        // 1. they already might be in the DOM before clicking the dropdown.
                -> Then you may locate elements (driver.findElement()) in the top of the script
        // 2. they appear in the DOM only when clicking on the dropdown.
                -> Then you need to locate elements only after the dropdown click action
        */
        List<WebElement> speedDropdownOptions = driver.findElements(By.cssSelector("#speed-menu li"));
        for (WebElement element : speedDropdownOptions) {
            if (element.findElement(By.cssSelector("[role='option']")).getText().equals(speedOption)) {
                element.click();
            }
        }

        assertEquals(driver.findElement(By.cssSelector("#speed-button .ui-selectmenu-text")).getText(), speedOption);
        //TODO 4
    }


}
