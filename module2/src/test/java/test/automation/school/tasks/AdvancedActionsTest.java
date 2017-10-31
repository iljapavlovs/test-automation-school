package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdvancedActionsTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
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


    }

    @Test
    public void dragAndDropTestOne() throws Exception {
        //TODO 2 - drag 1st element from left column to 2nd element in right column on http://jqueryui.com/resources/demos/sortable/connect-lists.html
        //TODO 2 - use dragAndDrop() method


    }

    @Test
    public void dragAndDropTestTwo() throws Exception {
        //TODO 3 - http://jqueryui.com/resources/demos/droppable/default.html - drag and drop left box into right box
        //TODO 3 - use clickAndHold, moveToElement, release methods


    }

    @Test
    public void dragAndDropTestThree() throws Exception {

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

    }




    @Test
    public void sliderTestThree() throws Exception {

        driver.get("http://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.cssSelector(".sliderContainer input"));

        //
        moveSliderToPercent(slider, 100);

//        assertEquals(driver.findElement(By.id("range")).getText(), "3.5");
    }


    /*
    NOTE - This method does not work properly on some sliders
     */
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

//        @Test
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
}
