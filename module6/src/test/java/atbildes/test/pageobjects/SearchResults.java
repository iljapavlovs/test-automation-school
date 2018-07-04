package atbildes.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResults extends Page{
    private WebDriver driver;
    private WebDriverWait wait;

    private final static By SEARCH_RESULTS_ELEMENTS_LOCATOR = By.cssSelector("[id*=tr_]:not([id*='tr_bnr_'])");
    private final static By PAGE_MAIN_LOCATOR = By.cssSelector("#page_main");


    public SearchResults(WebDriver driver) {
      super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_MAIN_LOCATOR));
    }

    public int getSearchResultElementCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_RESULTS_ELEMENTS_LOCATOR));
      return driver.findElements(SEARCH_RESULTS_ELEMENTS_LOCATOR).size();
    }
}
