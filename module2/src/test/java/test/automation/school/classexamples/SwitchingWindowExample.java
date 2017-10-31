package test.automation.school.classexamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class SwitchingWindowExample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://the-internet.herokuapp.com/windows");

        //Retrieving current Window handle id
        String windowHandleOne = driver.getWindowHandle();
        System.out.println(windowHandleOne);
        //New window is opened after following action
        driver.findElement(By.linkText("Click Here")).click();

        //need to wait since in this case Selenium is not waiting page to load
        Thread.sleep(2000);

        //Getting all Window Handle ids available in the browser session
        Set<String> windowHandleIds = driver.getWindowHandles();
        System.out.println(windowHandleIds);

        System.out.println(driver.getWindowHandle());

        System.out.println("Driver is still on the previous Window: " + driver.findElement(By.cssSelector("h3")).getText());

        for (String windowHandle : windowHandleIds) {
            if (!windowHandle.equals(windowHandleOne)) {
                driver.switchTo().window(windowHandle);
                //Perform your operation here for new window
                System.out.println("Driver is on opened Window: " + driver.findElement(By.cssSelector("h3")).getText());

                //NOTE - we are using driver.close(), NOT driver.quit() here
                driver.close(); //closing child window - only closes the window, not browser session
                driver.switchTo().window(windowHandleOne); //cntrl to parent window
            }
        }


    }

}
