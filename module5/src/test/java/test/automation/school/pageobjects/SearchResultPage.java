package test.automation.school.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.school.utils.WebDriverHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {
    //assume that it`s stable locator
    private static final String SEARCH_ITEMS_TEXT_CSS_SELECTOR = "[id*='dm_']";
    private static final String CHECKBOX_LIST_LOCATOR = "[name='mid[]'][type='checkbox']";
    private WebDriverWait wait;
    private WebDriver driver;
    //@FindBy(xpath = "//tr[contains(@id,'tr_') and not(contains(@id,'tr_bnr'))]")
    @FindBy(css = "[id*='tr_']:not([id*='tr_bnr_'])")
    private List<WebElement> searchResultElementsList;
    @FindBy(id = "page_main")
    private WebElement searchResultMainSection;
    //assume that it`s stable locator
    @FindBy(css = "[id *= 'tr_'] .msga2-o")
    private List<WebElement> searchResultElementsPriceList;
    //assume that it`s stable locator
    @FindBy(css = ".filter_opt_dv:nth-child(3) select")
    private WebElement dealTypeDropdown;
    @FindBy(xpath = "//*[text()='Цена' or text()='Cena'][ancestor::*[@id='head_line']]")
    private WebElement priceSortingButton;
    @FindBy(xpath = "//*[text()='Расширенный поиск' or text()='Paplašināta meklēšana']")
    private WebElement extendedSearchLink;
    @FindBy(id = "show_selected_a")
    private WebElement showSelectedAdvertismentsLink;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(searchResultMainSection));
    }

    public int getSearchResultElementCount() {
        return searchResultElementsList.size();
    }

    public SearchResultPage sortByPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(priceSortingButton));
        priceSortingButton.click();
        return this;
    }

    public ArrayList<Integer> getSearchElementsPriceList() {

        ArrayList<Integer> searchElementsPricInDigitList = new ArrayList<>();
        for (WebElement e : searchResultElementsPriceList) {

            String fullSearchElementPrice = e.getText();
            //remove non-digits
            String searchElementPriceInDigit = fullSearchElementPrice.replaceAll("[^0-9]", "");
            Integer x = Integer.valueOf(searchElementPriceInDigit);
            searchElementsPricInDigitList.add(x);
        }
        return searchElementsPricInDigitList;
    }

    public ArrayList<String> getSearchElementsPriceStringList() {

        ArrayList<String> serachElementsPriceList = new ArrayList<>();
        for (WebElement e : searchResultElementsList) {
            serachElementsPriceList.add(e.getText());
        }
        return serachElementsPriceList;
    }

    public SearchResultPage selectDealType(String dropdownValue) {
        WebDriverHelper.selectDropdownValueByText(dealTypeDropdown, dropdownValue);
        return this;
    }

    public ExtendedSearchPage goToExtendedSearch() {
        extendedSearchLink.click();
        return new ExtendedSearchPage(driver);
    }

    public SearchResultPage checkCheckboxes(int checkCount) {
        for (int i = 0; i < checkCount; i++) {
            this.searchResultElementsList.get(i).findElement(By.cssSelector(CHECKBOX_LIST_LOCATOR)).click();
        }
        return this;
    }

    public SelectedAdvertismentsPage showSelectedAdvertisments() {
        showSelectedAdvertismentsLink.click();
        return new SelectedAdvertismentsPage(driver);
    }


    public List<String> getSearchResultElementsText(int checkCount) {
        List<String> searchResultElementsTextList = new ArrayList<String>();
        for (int i = 0; i < checkCount; i++) {
            String searchResultElementsText = this.searchResultElementsList.get(i).findElement(By.cssSelector(SEARCH_ITEMS_TEXT_CSS_SELECTOR))
                    .getText();
            System.out.println("Search Items - " + searchResultElementsText);
            searchResultElementsTextList.add(searchResultElementsText);
        }
        return searchResultElementsTextList;
    }


}
