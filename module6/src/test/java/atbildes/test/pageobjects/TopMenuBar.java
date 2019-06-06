package atbildes.test.pageobjects;

import atbildes.test.enums.Languages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuBar extends Page{
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By CHANGE_LANG_LOCATOR = By.cssSelector(".menu_lang .a_menu");
    private static final By CHANGE_LANG_LOCATOR_LV = By.cssSelector("[href='/lv/']");
    private static final By CHANGE_LANG_LOCATOR_RU = By.cssSelector("[href='/ru/']");
    private static final By TOP_MENU_SECTION_LOCATOR = By.cssSelector("#main_table");
    private static final By SEARCH_LINK_LOCATOR = By.cssSelector("#main_table [href*=search]");


    public TopMenuBar(WebDriver driver) {
      super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TOP_MENU_SECTION_LOCATOR));
    }

    public void changeLanguage(Languages language) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHANGE_LANG_LOCATOR));
        switch (language) {
            case RU:
                if (driver.findElements(CHANGE_LANG_LOCATOR_RU).size()>0) {
                    driver.findElement(CHANGE_LANG_LOCATOR_RU).click();
                }
                break;
            case LV:
                if (driver.findElements(CHANGE_LANG_LOCATOR_LV).size()>0) {
                    driver.findElement(CHANGE_LANG_LOCATOR_LV).click();
                }
                break;
        }
    }


    public Languages getCurrentLanguage() {
        if (driver.findElements(CHANGE_LANG_LOCATOR_RU).size()>0) {
            return Languages.LV;
        } else {
            return Languages.RU;
        }
    }

    public void navigateToSearchPage(){
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_LINK_LOCATOR));
        driver.findElement(SEARCH_LINK_LOCATOR).click();
    }

}
