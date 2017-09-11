package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.school.enums.Language;

public class TopMenuBar {
    //    @FindBy(xpath = "//img[@class='page_header_logo']")
    @FindBy(css = "img.page_header_logo")
    public WebElement pageHeaderLogo;
    //    @FindBy(xpath = "//*[@href='/ru/']")
    @FindBy(css = "[href='/ru/']")
    public WebElement switchLangToRuLink;
    //    @FindBy(xpath = "//*[@href='/lv/']")
    @FindBy(css = "[href='/lv/']")
    public WebElement switchLangToLvLink;
    private WebDriverWait wait;
    private WebDriver driver;
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
        this.searchLink.click();
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
