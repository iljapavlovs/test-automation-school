package test.automation.school.api;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementApi {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");

        // .getText()
        WebElement logoWebElement = driver.findElement(By.name("hplogo"));
        System.out.println("Text of a web element: " + logoWebElement.getText());


        // .click()
        WebElement inputFieldWebElement = driver.findElement(By.name("q"));


        // .isDisplayed
        inputFieldWebElement.isDisplayed();
        inputFieldWebElement.isEnabled();

        inputFieldWebElement.sendKeys("text for inputting into input field");


        inputFieldWebElement.click();

    }

}
