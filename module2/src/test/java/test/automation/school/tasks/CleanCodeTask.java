package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CleanCodeTask {


    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\s1eamk\\AppData\\Local\\Microsoft\\AppV\\Client\\Integration\\590455D7-2D2E-48A6-9412-DD2A08B56F24\\Root\\VFS\\ProgramFilesX86\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("http://ss.com");
    }


    @Test
    public void tesSmth() throws Exception {


    }

    @Test
    public void test1() throws Exception {
        WebElement lang = driver.findElement(By.cssSelector(".menu_lang .a_menu"));
        if (!lang.getText().equals("RU")) {
            lang.click();

        }
        Assert.assertEquals(lang.getText(), "RU");
        Assert.assertEquals(lang.getAttribute("title"), "По-русски");

    }

    @Test
    public void test2() {
        WebElement lang = driver.findElement(By.cssSelector(".menu_lang .a_menu"));
        lang.click();

        WebElement search_link = driver.findElement(By.cssSelector(".menu_main a[href='/ru/search/']"));
        search_link.click();
        WebElement search_button = driver.findElement(By.cssSelector("[type='submit']"));
        WebElement search_word = driver.findElement(By.cssSelector(".in1"));

        WebElement search_cid = driver.findElement(By.cssSelector("[name='cid_0']"));
        Select select_cid = new Select(search_cid);

        WebElement search_city = driver.findElement(By.cssSelector("#s_region_select"));
        Select select_city = new Select(search_city);

        WebElement search_period = driver.findElement(By.cssSelector("[name='pr']"));
        Select select_period = new Select(search_period);

        String text = "компьютер";

        search_word.sendKeys(text);
        select_cid.selectByIndex(1);
        select_city.selectByIndex(1);
        select_period.selectByIndex(4);

        search_button.submit();

        List<WebElement> result = driver.findElements(By.cssSelector("[name='mid[]']"));
        assertTrue(result.size() > 0);
        assertTrue(result.get(0).isDisplayed());

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
