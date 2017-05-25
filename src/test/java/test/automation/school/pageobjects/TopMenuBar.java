package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.school.enums.Language;
import test.automation.school.enums.Location;

import static test.automation.school.enums.Language.LV;
import static test.automation.school.enums.Language.RU;

public class TopMenuBar {
	private WebDriverWait wait;
	private WebDriver driver;

	//    @FindBy(xpath = "//img[@class='page_header_logo']")
	@FindBy(css = "img.page_header_logo")
	public WebElement pageHeaderLogo;

	//    @FindBy(xpath = "//*[@href='/ru/']")
	@FindBy(css = "[href='/ru/']")
	public WebElement switchLangToRuLink;

	//    @FindBy(xpath = "//*[@href='/lv/']")
	@FindBy(css = "[href='/lv/']")
	public WebElement switchLangToLvLink;

	//xpath = '//*[text()=\"Поиск\"]'
	@FindBy(css = "#main_table a[href*='search']")
	private WebElement searchLink;

	public TopMenuBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(searchLink));
	}

	public SearchPage goToSearchPage() {
		wait.until(ExpectedConditions.elementToBeClickable(searchLink));
		searchLink.click();
		return new SearchPage(driver);
	}

	public TopMenuBar switchLangTo(Language language) {
		switch (language) {
			case LV:
				if (switchLangToLvLink.isDisplayed()) {
					switchLangToLvLink.click();
					break;
				}
			case RU:
				if (switchLangToRuLink.isDisplayed()) {
					switchLangToRuLink.click();
				}
		}
		return this;
	}
}
