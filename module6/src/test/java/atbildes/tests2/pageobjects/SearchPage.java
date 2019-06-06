package atbildes.tests2.pageobjects;

import atbildes.test.pageobjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage{
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By SEARCH_INPUT = By.cssSelector("#ptxt");
    private static final By SEARCH_BUTTON_LOCATOR = By.cssSelector("#sbtn");
    private static final By LABEL_LOCATOR = By.xpath("//*[contains(text(),'Искомое слово') or contains(text(),'Meklējamais vārds')]");


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT));
    }

    public void searchForPhrase(String phraseToSearch){
        driver.findElement(SEARCH_INPUT).sendKeys(phraseToSearch);
        driver.findElement(LABEL_LOCATOR).click();
    }

    public void performSearch() {
        driver.findElement(SEARCH_BUTTON_LOCATOR).click();

    }
}
