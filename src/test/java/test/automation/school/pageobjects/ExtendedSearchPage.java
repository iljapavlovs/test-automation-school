package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.automation.school.utils.WebDriverHelper;

public class ExtendedSearchPage extends SearchPage {

	// assume that locator is not dynamic
	@FindBy(name = "sid")
	private WebElement dealTypeDropdown;

	@FindBy(name = "topt[8][min]")
	protected WebElement minPriceInput;

	@FindBy(name = "topt[8][max]")
	protected WebElement maxPriceInput;

	public ExtendedSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ExtendedSearchPage selectDealType(String division) {
		WebDriverHelper.selectDropdownValueByText(dealTypeDropdown, division);
		return this;
	}

	public ExtendedSearchPage setPriceBoundaries(String minPrice, String maxPrice) {
		setMinPrice(minPrice);
		setMaxPrice(maxPrice);
		return this;
	}

	public ExtendedSearchPage setMinPrice(String minPrice) {
		minPriceInput.sendKeys(minPrice);
		return this;
	}

	public ExtendedSearchPage setMaxPrice(String maxPrice) {
		maxPriceInput.sendKeys(maxPrice);
		return this;
	}
}
