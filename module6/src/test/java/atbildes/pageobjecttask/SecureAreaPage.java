package atbildes.pageobjecttask;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureAreaPage {

    private static final By NOTIFICATION_SECTION_LOCATOR = By.id("flash-messages");
    private static final By LOGOUT_BUTTON_LOCATOR = By.cssSelector("[href='/logout']");

    private WebDriver driver;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_SECTION_LOCATOR));
        return driver.findElement(NOTIFICATION_SECTION_LOCATOR).isDisplayed();
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON_LOCATOR));
        driver.findElement(LOGOUT_BUTTON_LOCATOR).click();
    }

}
