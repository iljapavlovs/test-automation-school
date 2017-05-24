package test.automation.school.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.school.utils.WebDriverHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {
	private WebDriverWait wait;
	private WebDriver driver;

	//@FindBy(xpath = "//tr[contains(@id,'tr_') and not(contains(@id,'tr_bnr'))]")
	@FindBy(css = "[id*='tr_']:not([id*='tr_bnr_'])")
	private List<WebElement> searchResultElements;

	@FindBy(how = How.CSS, using = "input[name=\"mid[]\"].mchk")
	private WebElement searchResultCheckbox;

	@FindBy(id = "page_main")
	private WebElement searchResultMainSection;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(searchResultMainSection));
	}

	public int getSearchResultElementCount(){
		return searchResultElements.size();
	}


//
//	public SearchResultPage sortBy(String sortingCriteria) {
//		WebDriverHelper.selectDropdownValueByText(sortByDropdown, sortingCriteria);
//		return this;
//	}
//
//	public SearchResultPage selectDealType(String dealType) {
//
//		dealTypeDropdown = (new WebDriverWait(driver, 10))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEAL_TYPE_DROPDOWN_XPATH)));
//
//		WebDriverHelper.selectDropdownValueByText(dealTypeDropdown, dealType);
//		return this;
//	}
//
//	public SearchPage gotToAdvancedSearch() {
//		try{
//		this.advancedSearchLink = (new WebDriverWait(driver, 10))
//				.until(ExpectedConditions.presenceOfElementLocated(By.linkText(ADVANCED_SEARCH_LINK_TEXT)));
//
//		this.advancedSearchLink.click();
//		}
//		catch(org.openqa.selenium.StaleElementReferenceException ex)
//		{
//			System.out.println(ex.getMessage());
//			WebElement advancedSearchLink = driver.findElement(By.linkText(ADVANCED_SEARCH_LINK_TEXT));
//			advancedSearchLink.click();
//			}
//		return new SearchPage(driver);
//	}
//
//	public List<String> getSearchItemsText(int checkCount) {
//		this.searchItemTextList = new ArrayList<String>();
//		for (int i = 0; i < checkCount; i++) {
//			String searchItemText = this.searchResultElements.get(i).findElement(By.xpath(SEARCH_ITEMS_TEXT_XPATH))
//					.getText();
//			System.out.println("Search Items - " + searchItemText);
//			this.searchItemTextList.add(searchItemText);
//		}
//		return this.searchItemTextList;
//	}
//
//	public SearchPage checkCheckboxes(int checkCount) {
//
//		for (int i = 0; i < checkCount; i++) {
//			this.searchResultElements.get(i).findElement(By.cssSelector("input[name=\"mid[]\"].mchk")).click();
//		}
//		return new SearchPage(driver);
//	}
//
//	public SelectedAdsPage showSelectedAds() {
//
//		this.showSelectedAdsLink = (new WebDriverWait(driver, 10))
//				.until(ExpectedConditions.presenceOfElementLocated(By.id(SHOW_SELECTED_ADS_LINK_ID)));
//
//		this.showSelectedAdsLink.click();
//		return new SelectedAdsPage(driver);
//	}



}
