package test.automation.school.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SelectedAdvertismentsPage {

    private WebDriverWait wait;
    private WebDriver driver;

    //@FindBy(xpath = "//tr[contains(@id,'tr_') and not(contains(@id,'tr_bnr'))]")
    @FindBy(name = "filter_frm")
    private WebElement selectedAdvertismentsTable;

    @FindBy(css = "[id*='tr_']:not([id*='tr_bnr_'])")
    private List<WebElement> selectedAdsElementsList;

    //assume that it`s stable locator
    private static final String SELECTED_ITEMS_TEXT_CSS_SELECTOR = "[id*='dm_']";

    public SelectedAdvertismentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(selectedAdvertismentsTable));
    }


    public List<String> getSelectedAdsElementsText(int checkCount) {
        List<String> searchResultElementsTextList = new ArrayList<String>();
        for (int i = 0; i < checkCount; i++) {
            String searchResultElementsText = this.selectedAdsElementsList.get(i).findElement(By.cssSelector(SELECTED_ITEMS_TEXT_CSS_SELECTOR))
                    .getText();
            System.out.println("Search Items - " + searchResultElementsText);
            searchResultElementsTextList.add(searchResultElementsText);
        }
        return searchResultElementsTextList;
    }
}
