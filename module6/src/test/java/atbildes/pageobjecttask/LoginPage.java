package atbildes.pageobjecttask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static final By USER_NAME_INPUT_LOCATOR = By.id("username");
    private static final By PASSWORD_INPUT_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        WebElement userNameInput = driver.findElement(USER_NAME_INPUT_LOCATOR);
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        WebElement passwordInput = driver.findElement(PASSWORD_INPUT_LOCATOR);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
    }
}
