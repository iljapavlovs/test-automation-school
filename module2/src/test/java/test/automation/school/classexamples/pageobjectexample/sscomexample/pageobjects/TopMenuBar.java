package test.automation.school.classexamples.pageobjectexample.sscomexample.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuBar {
    private WebDriver driver;

    @FindBy(css = ".menu_lang .a_menu")
    private WebElement changeLanguageLink;

    @FindBy(xpath = "//*[@class='page_header_head']/h1")
    private WebElement pageHeaderHead;

    @FindBy(css = "#main_table a[href*='search']")
    private WebElement searchLink;

    private WebDriverWait wait;

    public TopMenuBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        wait.until(ExpectedConditions.elementToBeClickable(changeLanguageLink));
    }

    public void changeLanguage() {

//        wait.until(ExpectedConditions.elementToBeClickable(changeLanguageLink));
        changeLanguageLink.click();
    }

    public String getPageHeaderHeadText() {
        return pageHeaderHead.getText();
    }


    public void goToSearch() {
        searchLink.click();
    }

}


