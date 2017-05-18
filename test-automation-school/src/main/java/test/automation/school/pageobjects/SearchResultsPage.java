package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Max on 5/17/2017.
 */
public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//b[contains(text(),'Результат поиска') or contains(text(),'Meklēšanas rezultāti')]")
    public WebElement searchResultsIndicator;

    @FindBy(xpath = "//tr[contains(@id,'tr_') and not(contains(@id,'tr_bnr'))]")
    public List<WebElement> searchResults;


    public SearchResultsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(searchResultsIndicator));
    }
/*
    public List<WebElement> searchResults() {
        return driver.findElements(By.xpath("//tr[contains(@id,'tr_') and not(contains(@id,'tr_bnr'))]"));
    }*/

}
