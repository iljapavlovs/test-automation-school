package atbildes.tests2.pageobjects;

import atbildes.test.pageobjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults{
    private WebDriver driver;
    private WebDriverWait wait;

    private final static By SEARCH_RESULTS_ELEMENTS_LOCATOR = By.cssSelector("[id*=tr_]:not([id*='tr_bnr_'])");
    private final static By PAGE_MAIN_LOCATOR = By.cssSelector("#page_main");


    public SearchResults(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_MAIN_LOCATOR));
    }

    public int getSearchResultElementCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_RESULTS_ELEMENTS_LOCATOR));
      return driver.findElements(SEARCH_RESULTS_ELEMENTS_LOCATOR).size();
    }
}
