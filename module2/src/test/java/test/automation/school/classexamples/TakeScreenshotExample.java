package test.automation.school.classexamples;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshotExample {


    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.firefox.bin", "C:\\tools\\Firefox\\firefox.exe");

        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/hovers");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        /*
        If you choose the FILE format, it writes the data into a .png file,
        which will be deleted once the JVM is killed.
        */
        System.out.println(scrFile.getAbsolutePath());

        /*
        So, you should always copy that file
        into a safe location so that it can be used for later reference.
         */
        FileUtils.copyFile(scrFile, new File("target" + File.separator
                + "errorScreenshots" + File.separator
                + new SimpleDateFormat("yyyy-MM-dd_HHmm").format(new Date()) + ".png"));
    }


}
