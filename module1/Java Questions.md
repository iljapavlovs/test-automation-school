* Will following code compilie? If not - why and how to resolve it (**variable scope**)?

```
public class GoogleSearchTest {

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }

    @Test
    public void testSearch() throws Exception {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("cheese");
     }
       
}
```

* 