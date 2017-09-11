package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage {
    private WebDriverWait wait;
    private WebDriver driver;

    //@FindBy(xpath = "//tr[contains(@id,'tr_') and not(contains(@id,'tr_bnr'))]")
    @FindBy(css = "[id*='tr_']:not([id*='tr_bnr_'])")
    private List<WebElement> searchResultElements;

    @FindBy(id = "page_main")
    private WebElement searchResultMainSection;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(searchResultMainSection));
    }

    public int getSearchResultElementCount() {
        return searchResultElements.size();
    }
}
