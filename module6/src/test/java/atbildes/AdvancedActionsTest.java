package atbildes;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class AdvancedActionsTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void hoverOverTest() throws Exception {

        //TODO 1 - navigate to http://the-internet.herokuapp.com/hovers and hover over any image and click on the poped out "View profile" link
        //TODO 1 - verify that you have been redirected to a new page

        driver.get("http://the-internet.herokuapp.com/hovers");
        String currentUrl = driver.getCurrentUrl();

        WebElement imageElement = driver.findElement(By.cssSelector(".figure img"));

        Actions builder = new Actions(driver);

        builder.moveToElement(imageElement)
                .moveToElement(driver.findElement(By.linkText("View profile")))
                .click()
                .build()
                .perform();


        assertFalse(currentUrl.equals(driver.getCurrentUrl()));

    }

//    @Test
//    public void multipleSelectTest() throws Exception {
//
//        driver.get("https://html.com/attributes/select-multiple/");
//        driver.manage().window().maximize();
//
//
//        WebElement lesserFlamingoOption = driver.findElement(By.cssSelector("[value='Lesser']"));
//        WebElement chileanFlamingoOption = driver.findElement(By.cssSelector("[value='Chilean']"));
//        assertFalse(lesserFlamingoOption.isSelected());
//        assertFalse(chileanFlamingoOption.isSelected());
//
//        // Configure the action
//        Actions builder = new Actions(driver);
//
//        builder.keyDown(Keys.CONTROL)
//                .click(lesserFlamingoOption)
//                .click(chileanFlamingoOption)
//                .keyUp(Keys.CONTROL);
//
//        // Then get the action:
//        Action selectMultiple = builder.build();
//        // And execute it:
//        selectMultiple.perform();
//
//        assertTrue(lesserFlamingoOption.isSelected());
//        assertTrue(chileanFlamingoOption.isSelected());
//
//    }


    @Test
    public void dragAndDropTestOne() throws Exception {

        //TODO 2 - drag 1st element from left column to 2nd element in right column on http://jqueryui.com/resources/demos/sortable/connect-lists.html
        //TODO 2 - use dragAndDrop() method

        driver.get("http://jqueryui.com/resources/demos/sortable/connect-lists.html");
        List<WebElement> dragList = driver.findElements(By.cssSelector("ul#sortable1 li"));
        List<WebElement> dropList = driver.findElements(By.cssSelector("ul#sortable2 li"));

        new Actions(driver).dragAndDrop(dragList.get(0), dropList.get(1)).perform();

    }

    @Test
    public void dragAndDropTestTwo() throws Exception {


        //TODO 3 - http://jqueryui.com/resources/demos/droppable/default.html - drag and drop left box into right box
        //TODO 3 - use clickAndHold, moveToElement, release methods
        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

        // Create object of actions class
        Actions act = new Actions(driver);

        // find element which we need to drag
        WebElement drag = driver.findElement(By.id("draggable"));

        // find element which we need to drop
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(drag)
                .moveToElement(drop)
                .release(drop)
                .build();

        dragAndDrop.perform();

        String actualText = driver.findElement(By.cssSelector("#droppable p")).getText();

        assertEquals(actualText, "Dropped!");


    }

    @Test
    public void dragAndDropTestThree() throws Exception {
        //TODO 3 - http://jqueryui.com/resources/demos/droppable/default.html - drag and drop left box into right box
        //TODO 3 - use clickAndHold, moveToElement, release methods
        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

        // Create object of actions class
        Actions action = new Actions(driver);

        // find element which we need to drag
        WebElement drag = driver.findElement(By.id("draggable"));

        // find element which we need to drop
        WebElement drop = driver.findElement(By.id("droppable"));

        // this will drag element to destination
        action.dragAndDrop(drag, drop).build().perform();

        String actualText = driver.findElement(By.cssSelector("#droppable p")).getText();

        assertEquals(actualText, "Dropped!");
    }


    @Test
    public void sliderTestOne() throws Exception {


        //TODO 4 http://the-internet.herokuapp.com/horizontal_slider - slide slider by 30 pixels to the right. Verify that result range is "3.5"
        // TODO 4 - use dragAndDropBy method
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.cssSelector(".sliderContainer input"));

        // Create object of actions class
        Actions builder = new Actions(driver);

        Action action = builder.dragAndDropBy(slider, 30, 0).build();
        action.perform();

        assertEquals(driver.findElement(By.id("range")).getText(), "3.5");
    }


    @Test
    public void sliderTestTwo() throws Exception {

        driver.get("http://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.cssSelector(".sliderContainer input"));

        //
        moveSliderToPercent(slider, 100);

//        assertEquals(driver.findElement(By.id("range")).getText(), "3.5");
    }

    @Test
    public void sliderTestThree() throws Exception {

        driver.get("http://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.cssSelector(".sliderContainer input"));

        //
        moveSliderToPercent(slider, 100);

//        assertEquals(driver.findElement(By.id("range")).getText(), "3.5");
    }


    public void moveSliderToPercent(WebElement slider, int percent) {

        Actions builder = new Actions(this.driver);

        Action dragAndDrop;

        int height = slider.getSize().getHeight();
        int width = slider.getSize().getWidth();


        if (width > height) {
            //high likely a horizontal slider
            dragAndDrop = builder.clickAndHold(slider).moveByOffset(-(width / 2), 0).
                    moveByOffset((int) ((width / 100) * percent), 0).
                    release().build();
        } else {
            //high likely a vertical slider
            dragAndDrop = builder.clickAndHold(slider).moveByOffset(0, -(height / 2)).
                    moveByOffset(0, (int) ((height / 100) * percent)).
                    release().build();
        }


        dragAndDrop.perform();

    }
}
