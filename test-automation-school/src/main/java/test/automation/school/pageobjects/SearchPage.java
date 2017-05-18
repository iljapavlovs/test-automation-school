package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Max on 5/17/2017.
 */
public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@name='btn'] [@value='Искать' or @value='Meklēt']")
    @CacheLookup
    public WebElement searchBtn;

    @FindBy(xpath = "//input[@id='ptxt']")
    public WebElement lookupTxt;

    @FindBy(xpath = "//select[@name='cid_0']")
    public WebElement themeDrDwn;

    @FindBy(xpath = "//select[@name='cid_1']")
    public WebElement categoryDrDwn;

    @FindBy(xpath = "//select[@name='search_region']")
    public WebElement regionDrDwn;

    @FindBy(xpath = "//select[@name='pr']")
    public WebElement periodDrDwn;

    public void selectDrDwnValue(WebElement drpdwn, String option) {
        Select select = new Select(drpdwn);
        select.selectByVisibleText(option);
    }

/*    public void selectDrDwnValue(WebElement drpdwn, String option) {
        List<WebElement> values = drpdwn.findElements(By.xpath(".//option"));
        for (WebElement e : values) {
            System.out.println(e.getText().toString());
            if (e.getText().toString() == option) {
            e.submit();
            }
        }
    }*/

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
    }

}
