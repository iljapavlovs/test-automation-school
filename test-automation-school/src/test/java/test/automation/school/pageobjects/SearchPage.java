package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.school.enums.Location;
import test.automation.school.enums.TimePeriod;
import test.automation.school.utils.WebDriverHelper;

import java.sql.Time;

public class SearchPage {
	private WebDriverWait wait;
	private WebDriver driver;

	// dont like the locator either, but couldn`t find a better option
	@FindBy(xpath= "//*[contains(text(),'Искомое слово') or contains(text(),'Meklējamais vārds')]")
	private WebElement searchCriteriaTitle;

	// assume that locator is not dynamic
	@FindBy(id = "ptxt")
	private WebElement searchCriteriaInput;

	// assume that locator is not dynamic
	@FindBy(name = "cid_0")
	private WebElement subDivisionDropdown;

	// assume that locator is not dynamic
	@FindBy(name = "cid_1")
	private WebElement categoryDropdown;

	@FindBy(id = "s_region_select")
	private WebElement locationDropdown;

	// assume that locator is not dynamic
	@FindBy(name= "pr")
	private WebElement timePeriodDropdown;

	@FindBy(id = "sbtn")
	private WebElement searchButton;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(searchCriteriaInput));
	}

	public SearchPage searchForPhrase(String phraseToSearchFor) {
		this.searchCriteriaInput.sendKeys(phraseToSearchFor);

		// this is done in order to close suggested list of search criterias (auto-complete)
		// workaraound since auto-complete on ss.lv is implemented incorrectly
		this.searchCriteriaTitle.click();
		return this;
	}

	public SearchPage selectSubDivision(String division) {
		WebDriverHelper.selectDropdownValueByText(subDivisionDropdown, division);
		return this;
	}

	public SearchPage selectCategory(String category) {
		WebDriverHelper.selectDropdownValueByText(categoryDropdown, category);
		return this;
	}

	public SearchPage selectLocation(Location location) {
		WebDriverHelper.selectDropdownValueByValue(locationDropdown, location.getLocation());
		return this;
	}

	public SearchPage selectTimePeriod(TimePeriod timePeriod) {
		WebDriverHelper.selectDropdownValueByValue(timePeriodDropdown, timePeriod.getDayCount());
		return this;
	}

	public SearchResultPage performSearch() {
		this.searchButton.click();
		return new SearchResultPage(driver);
	}
}
