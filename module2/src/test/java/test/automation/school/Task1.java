package test.automation.school;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
 System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe"); ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);

////      todo 1. Открыть браузер и развернуть на весь экран.
      //  driver.manage().window().maximize();

//        todo 2. Зайти на ss.com
        driver.get("http://ss.com");
    }

    @AfterMethod
    public void tereDown(){
        driver.quit();
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
