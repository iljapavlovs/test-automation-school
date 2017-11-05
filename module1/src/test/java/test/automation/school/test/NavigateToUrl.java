//package test.automation.school.test;
//
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.util.List;
//
//public class NavigateToUrl {
//    FirefoxDriver driver;
//    public static void main(String[] args) {
//        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//
//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
//
//         driver = new FirefoxDriver();
//        driver.get("http://www.google.com");
//        WebElement element = driver.findElement(By.name("q"));
//
//        element.sendKeys("cheese" + Keys.ENTER);
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // will find all elements with class='g'
//        List<WebElement> list =  driver.findElements(By.cssSelector(".g"));
//
//        // NoSuchException not thrown
//        List<WebElement> list2 =  driver.findElements(By.cssSelector("a.c.b.r s.k"));
//
//        System.out.println("List size:" + list.size());
//        System.out.println("List size2:" + list2.size());
//
//        driver.quit();
//
//
////        driver.quit();
//    }
//
//
//    public String get(){
//        return "Hi!";
//    }
//
//
////    public WebElement getElement(){
////        return "WebElement";
////    }
//
//    public WebElement getElement(){
//        return driver.findElement(By.id("some_id"));
//    }
//}
