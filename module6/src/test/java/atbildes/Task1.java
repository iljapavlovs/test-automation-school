package atbildes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Task1 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
//        System.setProperty("webdriver.chrome.bin", "C:\\Users\\s1eamk\\AppData\\Local\\Microsoft\\AppV\\Client\\Integration\\590455D7-2D2E-48A6-9412-DD2A08B56F24\\Root\\VFS\\ProgramFilesX86\\Google\\Chrome\\Application\\chrome.exe");
//        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Users\\s1eamk\\AppData\\Local\\Microsoft\\AppV\\Client\\Integration\\590455D7-2D2E-48A6-9412-DD2A08B56F24\\Root\\VFS\\ProgramFilesX86\\Google\\Chrome\\Application\\chrome.exe");

//        driver = new ChromeDriver(options);
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
////      todo 1. Открыть браузер и развернуть на весь экран.
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
//        todo 2. Зайти на ss.com
        driver.get("http://ss.com");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) throws Exception {

        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target" + File.separator
                    + "errorScreenshots" + File.separator
                    + testResult.getName() + "-"
                    + new SimpleDateFormat("yyyy-MM-dd_HHmm").format(new Date()) + ".png"));
        }
        driver.quit();
    }

    @Test
    public void testSearch() throws Exception {

        WebElement switchLanguageLink = driver.findElement(By.cssSelector(".menu_lang a"));
//        3. todo Поменять язык на русский.
        // change language only if
        if (switchLanguageLink.getAttribute("href").contains("ru")) {
            switchLanguageLink.click();
            WebDriverWait wait = new WebDriverWait(driver, 5);
            //added wait until page is loaded and elements are rerendered in order to avoid StaleElementException on searchLink element
            wait.until(ExpectedConditions.titleIs("Объявления - SS.COM"));
        }

//       todo 4. в поиске ввести искомую фразу(напр.Компьютер....)

        WebDriverWait searchLinkWait = new WebDriverWait(driver, 5);

        //added explicit wait since test was flaky on this step
        searchLinkWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main_table a[href*='search']")));


        // NOTE - smart locator - it contains #main_table as an anchor since there are multiple a[href*='search'] elements on the page
        WebElement searchLink = driver.findElement(By.cssSelector("#main_table a[href*='search']"));

        searchLink.click();

        WebDriverWait searchCriteriaInputWait = new WebDriverWait(driver, 5);
        // cannot use WebElement, need to use By locator since test is failing on NoSuchElementException, meaning that it`s not present in DOM
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ptxt"))));
        searchCriteriaInputWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ptxt")));

        // assume that locator is not dynamic
        WebElement searchCriteriaInput = driver.findElement(By.id("ptxt"));
        searchCriteriaInput.sendKeys("Компьютер");

        // this is done in order to close suggested list of search criterias (auto-complete)
        // workaraound since auto-complete on ss.lv is implemented incorrectly
        WebElement searchCriteriaTitle = driver.findElement(By.xpath("//*[contains(text(),'Искать за период')]"));
        searchCriteriaTitle.click();

//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(d -> d.findElements(By.id("preload_txt")).size()==0);

//        todo 5. выбрать разные параметры поиска.

        // assume that locator is not dynamic
        WebElement subDivisionDropdown = driver.findElement(By.name("cid_0"));
        Select subDivisionSelect = new Select(subDivisionDropdown);

        //selectByVisibleText is used since 'value' doesnt look like stable locator
        subDivisionSelect.selectByVisibleText("Электротехника");

        // assume that locator is not dynamic
        WebElement categoryDropdown = driver.findElement(By.name("cid_1"));
        Select categorySelect = new Select(categoryDropdown);
        //not possible to select by Value since there are randomly generated numbers
        categorySelect.selectByVisibleText("Компьютеры, оргтехника");

        WebElement locationDropdown = driver.findElement(By.id("s_region_select"));
        Select locationSelect = new Select(locationDropdown);
        // better to use value since text value can change in future or other language will be used
        locationSelect.selectByValue("riga_f");

        // assume that locator is not dynamic
        WebElement timePeriodDropdown = driver.findElement(By.name("pr"));
        Select timePeriodSelect = new Select(timePeriodDropdown);
        // better to use value since text value can change in future or other language will be used
        // 0 - <option value="0" selected="">Среди всех объявлений</option>
        timePeriodSelect.selectByValue("30");

//      todo  6. Нажать кнопку Искать
        WebElement searchButton = driver.findElement(By.id("sbtn"));
        WebDriverWait searchButtonWait = new WebDriverWait(driver, 5);
        //added wait until page is loaded and elements are rerendered in order to avoid StaleElementException on searchLink element
        searchButtonWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();


//      todo 7. удостовериться что отображается хотя бы одно объявление

        WebDriverWait listWait = new WebDriverWait(driver, 5);
        //added wait until page is loaded and elements are rerendered in order to avoid StaleElementException on searchLink element
//        listWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[id*='tr_']:not([id*='tr_bnr_'])")));

        //xpath locator - "//tr[contains(@id,'tr_') and not(contains(@id,'tr_bnr'))]"
        List<WebElement> searchResultElementsList = driver.findElements(By.cssSelector("[id*='tr_']:not([id*='tr_bnr_'])"));
        assertTrue(searchResultElementsList.size() > 0);
    }


}
