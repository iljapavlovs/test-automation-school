package test.automation.school.tasks;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


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

    }


    @Test
    public void selectByValueTest() throws Exception {
        //TODO 2 - select dropdown option by value of "Option 1" element and verify that this element was selected

    }


    @Test
    public void retrieveAllOptionsTest() throws Exception {
        //TODO 3 - check that actual dropdown options have following text values and order: 'Please select an option', 'Option 1', 'Option 2'
        // NOTE - recall how to compare Collections in Java
        // remember - List is an ordered data structure so the order of elements matters.
        // hence - "two Lists are defined to be equal if they contain the same elements in the same order.", hence you can use assertEquals for comparing 2 lists



    }


    @Test
    public void nonSelectDropdownTest() throws Exception {
        //TODO 4 - https://jqueryui.com/selectmenu/" - from the Speed dropdown select "Fast" option and verify that this option was selected
        //Hint - iFrame doesn`t have any id nor name, but there are no iframes in the page. Hence, you can switch to the frame by index. But regardless, always ping UI devs to add name or id for such cases!
        //Hint - Dropdown is not a <select> element, hence you can`t use Select class

    }

    //TODO - add tests for non <select> elements


}
