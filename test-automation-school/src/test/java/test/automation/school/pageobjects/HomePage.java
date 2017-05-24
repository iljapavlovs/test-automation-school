package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

//    @FindBy(xpath = "//*[@class='a1'][@href='/ru/electronics/']")
    @FindBy(css = ".a1[href*='/electronics/']")
    public WebElement electronicsCategoryLink;

//    @FindBy(xpath = "//*[@class='page_header_head']/h1")
    @FindBy(css = ".page_header_head h1")
    public WebElement pageHeaderHead;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(electronicsCategoryLink));
    }

    public String getPageHeaderHeadText(){
        return pageHeaderHead.getText();
    }

}


