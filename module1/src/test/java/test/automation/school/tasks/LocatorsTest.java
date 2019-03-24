package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LocatorsTest {
    /*
    * add assert for all tests - check for visibility
    * in order to run individual test, you need to hover over the required test and right click ->Run
    * check that variables named correctly
    * import correct List
    * use findElements for retrieving multiple elements, not findElement
    * css selector ->
       * .class .class - 'space' means nesting (one element is a children or grandchildren of another)
       * .class.class - when written in conjunction then it means that this element has multiple classes and
           * in HTML it is viewed via space 'class class'
    * 2nd task - search for all elements, not possible to search for visible
    * 6th and 7th - search only for visible elements
    * linkText() is case sensitive and should be selected as it is rendered on the screen, not in HTML
    * dont be afraid to check the stacktrace, it contains useful info - e.g. the line of code where it has failed
    * Use debug to see in which state AUT is at the moment of failure
    * consider how browser is initialized - in this example it is initialized once and killed once, so there is only one browser session for all tests
    */
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

   @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void locateElementByIdTest() throws Exception {
        //TODO 1 - locate search input field by ID and assign to a variable named elementById
        WebElement elementById = driver.findElement(By.id("search_query_top"));

        Assert.assertTrue(elementById.isDisplayed());
        //TODO 1
    }


    @Test
    public void locateElementByClassNameTest() throws Exception {
        //TODO 2 - locate *all* (also that are not visible on the screen) products by class name and put them into ArrayList Collection and check that elements list size is 14
       // List<WebElement> elements = driver.findElements(By.cssSelector(".ajax_block_product")); //done together
        List<WebElement> elements = driver.findElements(By.className("ajax_block_product"));
        assertEquals (elements.size(), 14);
        //search all products, Ctrl+Alt+V
        //TODO 2
    }


    @Test
    public void locateElementByTagNameTest() throws Exception {
        //TODO 3 - locate all images by tag name and put them into ArrayList Collection. Then check that first element in Collection is displayed
        List<WebElement> findImgByTag = driver.findElements(By.tagName("img"));
         assertTrue(findImgByTag.get(0).isDisplayed());
        //TODO 3
    }


    @Test
    public void locateElementByNameTest() throws Exception {
        //TODO 4 - locate newsletter subscription input element by name. Then check that element is displayed
        WebElement findNewsLtrSubsIn = driver.findElement(By.id("newsletter-input"));
        assertTrue(findNewsLtrSubsIn.isDisplayed());

        //TODO 4
    }


    @Test
    public void locateElementByLinkTextTest() throws Exception {
        //TODO 5 - locate "T-Shirts" element by link text. Then check that element is displayed
        // NOTE - linkText() is case sensitive and should be selected as it is rendered on the screen, not in HTML
        WebElement findTshirtsLinkText = driver.findElement(By.linkText("T-SHIRTS"));
        assertTrue(findTshirtsLinkText.isDisplayed());


        //TODO 5
    }


    @Test
    public void locateElementByCssSelctorTest() throws Exception {
        //TODO 6 - locate only *visible* products element by CSS and put them into ArrayList Collection and check that elements list size is 7
        List<WebElement> findVsblProd = driver.findElements(By.cssSelector(".active .ajax_block_product"));
        //  List<WebElement> findVsblProd = driver.findElements(By.cssSelector("#homefeatured .product_list grid row homefeatured tab-pane active"));
        assertEquals (findVsblProd.size(), 7);
//.active .ajax_block_product
        //TODO 6

    }

    @Test
    public void locateElementByXpathTest() throws Exception {
        //TODO 7 - locate only *visible* products element by XPATH and put them into ArrayList Collection and check that elements list size is 7
        //NOTE - you have to indicate all class names that are specified on the current element
        // This is contrary to CSS Selector where you can specify just one of the class names
        // TIP - use 'contains()'
        List<WebElement> fndVsblXpth = driver.findElements(By.xpath("//*[contains(@class,'active')]/*[contains(@class,'ajax_block_product')]"));
        assertEquals(fndVsblXpth.size(), 7);

// xpath to use  //*[contains(@class,'active')]/*[contains(@class,'ajax_block_product')]
        //TODO 7
    }

}
