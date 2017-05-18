package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lina.pugo on 5/17/2017.
 */
public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='ptxt']")
    public WebElement findSearchfield;

    @FindBy(xpath = "//input[@value='Искать']")
    public WebElement searchButton;

    @FindBy(xpath = "//select[@name='search_region']")
    public WebElement findSearchRegion;

    @FindBy(xpath = "//select[@name='pr']")
    public WebElement findSearchPeriod;

    @FindBy(xpath = "//select[@name='cid_0']")
    public WebElement findSearchCategory;

    @FindBy(xpath = "//select[@name='cid_1']")
    public WebElement findSearchSubCategory;

    @FindBy(xpath = " //a[text() = 'Цена']")
    public WebElement searchResultsPresent;



    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(findSearchfield));
    }


    public SearchPage inputSearchParameter(String name){
        if (findSearchfield.isDisplayed()) {
            findSearchfield.sendKeys(name);
        }
        return this;
    }

    public SearchPage selectSearchParamaterFromDropdown(String name, WebElement parameter){
        if (parameter.isDisplayed()) {
            Select dropdown= new Select(parameter);
            dropdown.selectByVisibleText(name);
        }
        return this;
    }


    public SearchPage clickSearchButton () {
        if (searchButton.isDisplayed()) {
            searchButton.click();
        }
        return this;
    }


}