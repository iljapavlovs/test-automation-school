package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

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
        assertTrue(elementById.isDisplayed());
        //TODO 1
    }


    @Test
    public void locateElementByClassNameTest() throws Exception {
        //TODO 2 - locate *all* (also that are not visible on the screen) products by class name and put them into ArrayList Collection and check that elements list size is 14
        List<WebElement> elements = driver.findElements(By.className("ajax_block_product "));
        int i = elements.size();
        assertEquals(i, 14);
        //TODO 2
    }


    @Test
    public void locateElementByTagNameTest() throws Exception {
        //TODO 3 - locate all images by tag name and put them into ArrayList Collection
        List<WebElement> img = driver.findElements(By.tagName("img"));
        assertTrue(img.size() > 0);
    }


    @Test
    public void locateElementByNameTest() {
        //TODO 4 - locate newsletter subscription input element by name
        WebElement newsletter = driver.findElement(By.name("search_query_top"));
        assertTrue(newsletter.isDisplayed());
        //TODO 4
    }


    @Test
    public void locateElementByLinkTextTest() throws Exception {
        //TODO 5 - locate "T-Shirts" element by link text
        WebElement tShirtsTab = driver.findElement(By.linkText("T-SHIRTS"));
        assertTrue(tShirtsTab.isDisplayed());
        //TODO 5
    }


    @Test
    public void locateElementByCssSelctorTest() throws Exception {
        //TODO 6 - locate only *visible* products element by CSS and put them into ArrayList Collection and check that elements list size is 7
        List<WebElement> visibleElements = driver.findElements(By.cssSelector("#homefeatured>li"));
        int i = visibleElements.size();
        assertEquals(i, 7);
        //TODO 6

    }

    @Test
    public void locateElementByXpathTest() throws Exception {
        //TODO 7 - locate only *visible* products element by XPATH and put them into ArrayList Collection and check that elements list size is 7
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='homefeatured']//li[contains(@class,'ajax_block_product')]"));
        assertEquals(elements.size(), 7);
        //TODO 7
    }

}
