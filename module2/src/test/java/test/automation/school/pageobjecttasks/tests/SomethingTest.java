package test.automation.school.pageobjecttasks.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.automation.school.pageobjecttasks.pageobejcts.TopMenuBar;

import static org.testng.AssertJUnit.assertEquals;

public class SomethingTest {


    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

//        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Users\\s1eamk\\AppData\\Local\\Microsoft\\AppV\\Client\\Integration\\590455D7-2D2E-48A6-9412-DD2A08B56F24\\Root\\VFS\\ProgramFilesX86\\Google\\Chrome\\Application\\chrome.exe");
//
//        driver = new ChromeDriver(options);

        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        driver = new FirefoxDriver();


        driver.manage().window().maximize();
        driver.get("http://ss.com");
    }

    @AfterMethod
    public void teardown() throws Exception {

        driver.quit();
    }

    @Test
    public void testSmth() throws Exception {
        TopMenuBar topMenuBar = new TopMenuBar(driver);
        topMenuBar.changeLanguage();

        assertEquals(topMenuBar.getPageHeaderHeadText(), "ОБЪЯВЛЕНИЯ");


    }

    @Test
    public void testSmth2() throws Exception {
        TopMenuBar topMenuBar = new TopMenuBar(driver);
        topMenuBar.changeLanguage();
        topMenuBar.goToSearch();


    }

}
