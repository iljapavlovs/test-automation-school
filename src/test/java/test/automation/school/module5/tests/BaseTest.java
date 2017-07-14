package test.automation.school.module5.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import test.automation.school.module5.utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseTest {

    private static final String APPLICATION_URL = ConfigReader.getConfigValue("application.url");

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
//        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        File file = new File("C:\\tools\\Firefox\\", "firefox.exe");
        if (file.exists()) {
            System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
//        driver = new ChromeDriver();

        FirefoxOptions options = new FirefoxOptions().setLegacy(true);
        driver = new FirefoxDriver(options);

        driver.get(APPLICATION_URL);
        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target" + File.separator
                    + "errorScreenshots" + File.separator
                    + testResult.getName() + "-"
                    + new SimpleDateFormat("yyyy-MM-dd_HHmm").format(new Date()) + ".png"));
        }

        driver.quit();
    }
}
