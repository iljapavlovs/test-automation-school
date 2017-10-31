package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchingFramesExample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://the-internet.herokuapp.com/iframe");

        /* NOTE -this action would throw NoSuchElementException since driver does not see the child iFrame
         you have to switch to the frame first
         //System.out.println(driver.findElement(By.cssSelector("#tinymce p")).getText());
          */

        //using HTML id - id='mce_0_ifr'
        driver.switchTo().frame("mce_0_ifr");
        System.out.println(driver.findElement(By.cssSelector("#tinymce p")).getText());


    }

}
