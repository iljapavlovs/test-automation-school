package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WebElementChainingExample {

    private WebDriver driver;

    private WebElement getTableRowElement(String email) {
        return driver.findElement(By.xpath("//*[@id='table2']//tr[child::td[@class='email'][text()='" + email + "']]"));
    }

    private WebElement getTableWebSiteElement(String email) {
        return getTableRowElement(email).findElement(By.className("web-site"));
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testOne() throws Exception {
        WebElement element = getTableWebSiteElement("jsmith@gmail.com");
        assertEquals(element.getText(), "http://www.jsmith.com");
    }
}
