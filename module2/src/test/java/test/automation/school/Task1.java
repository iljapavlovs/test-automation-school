package test.automation.school;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
//        System.setProperty("webdriver.chrome.bin", "C:\\Users\\s1eamk\\AppData\\Local\\Microsoft\\AppV\\Client\\Integration\\590455D7-2D2E-48A6-9412-DD2A08B56F24\\Root\\VFS\\ProgramFilesX86\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\s1eamk\\AppData\\Local\\Microsoft\\AppV\\Client\\Integration\\590455D7-2D2E-48A6-9412-DD2A08B56F24\\Root\\VFS\\ProgramFilesX86\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver(options);
//        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        //        driver = new FirefoxDriver();
////      todo 1. Открыть браузер и развернуть на весь экран.

        driver.manage().window().maximize();
//        todo 2. Зайти на ss.com
        driver.get("http://ss.com");
    }


    @Test
    public void testSearch() throws Exception {

//       todo 3. Поменять язык на русский.


//       todo 4. в поиске ввести искомую фразу(напр.Компьютер....)


//      todo 5. выбрать разные параметры поиска.


//      todo  6. Нажать кнопку Искать


//      todo 7. удостовериться что отображается хотя бы одно объявление


    }


}
