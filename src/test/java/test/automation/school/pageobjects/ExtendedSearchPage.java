package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.school.enums.Location;
import test.automation.school.enums.TimePeriod;
import test.automation.school.utils.WebDriverHelper;

public class ExtendedSearchPage extends SearchPage {

	// assume that locator is not dynamic
	@FindBy(name = "sid")
	private WebElement dealTypeDropdown;

	public ExtendedSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ExtendedSearchPage selectDealType(String division) {
		WebDriverHelper.selectDropdownValueByText(dealTypeDropdown, division);
		return this;
	}

}
