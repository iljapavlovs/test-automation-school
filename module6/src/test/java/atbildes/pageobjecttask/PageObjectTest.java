package atbildes.pageobjecttask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PageObjectTest {
    private WebDriver driver;
    private SecureAreaPage secureAreaPage;


    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions()
                .addPreference("security.insecure_field_warning.contextual.enabled", false)
                .addPreference("security.insecure_password.ui.enabled", false);
        driver = new FirefoxDriver(options);
        driver.get("http://the-internet.herokuapp.com/login");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        secureAreaPage.logout();
        driver.quit();
    }

    @Test
    public void testLogin() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");

        secureAreaPage = new SecureAreaPage(driver);
        assertTrue(secureAreaPage.isUserLoggedIn());
    }
}
