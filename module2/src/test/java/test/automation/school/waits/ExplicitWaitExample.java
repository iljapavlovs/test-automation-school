package test.automation.school.waits;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {
    public static void main(String[] args) {

        //todo - show first without explicit wait

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        // creating WebDriverWait instance and providing time to wait
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // providing condition to wait for into until() method
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish")));

//        WebElement helloWorldText = driver.findElement(By.cssSelector("#finish"));
//        System.out.println("Is element displayed: " + helloWorldText.isDisplayed());

        System.out.println("Is element displayed: " + element.isDisplayed());
    }
}
