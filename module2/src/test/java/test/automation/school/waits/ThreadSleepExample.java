package test.automation.school.waits;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadSleepExample {
    //Thread.sleep() throws 'InterruptedException'
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        //just stop code execution for 5 seconds
        Thread.sleep(5000);

        WebElement helloWorldText = driver.findElement(By.cssSelector("#finish"));
        System.out.println("Is element displayed: " + helloWorldText.isDisplayed());

    }
}
