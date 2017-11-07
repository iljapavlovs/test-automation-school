package test.automation.school.classexamples.pageobjectexample.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
    /*
    Page Object Locators for page elements
     */
    private static final By INPUT_FIELD_LOCATOR = By.name("q");
    private static final By SEARCH_BUTTON_LOCATOR = By.name("btnK");
    private static final By FEELING_LUCKY_BUTTON_LOCATOR = By.name("btnI");
    private WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    /*
     Page Object methods for interacting with the page
     */
    public void searchFor(String textToSearchFor) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_FIELD_LOCATOR));
        driver.findElement(INPUT_FIELD_LOCATOR).sendKeys(textToSearchFor, Keys.ENTER);
    }
}