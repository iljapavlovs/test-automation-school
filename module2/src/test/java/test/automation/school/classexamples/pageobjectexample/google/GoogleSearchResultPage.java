package test.automation.school.classexamples.pageobjectexample.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleSearchResultPage {
    /*
    Page Object Locators for page elements
    */
    private static final By SEARCH_RESULT_ELEMENTS_LOCATOR = By.className("g");
    private static final By INPUT_FIELD_LOCATOR = By.name("q");
    private WebDriver driver;

    public GoogleSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    /*
    Page Object methods for interacting with the page
    */
    public String getFirstSearchResultElementText() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SEARCH_RESULT_ELEMENTS_LOCATOR));

        return driver.findElements(SEARCH_RESULT_ELEMENTS_LOCATOR).get(0).getText();
    }

    ;
}
