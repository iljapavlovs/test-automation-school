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

  * **Answer**:
Code will not run since ‘driver’ variable in testSearch() method is not declared. ‘driver’ variable in setUp() method is another variable, which has nothing to do with ‘driver’ variable in testSearch() method due to variable scope – ‘driver’ variable in setUp() method is declared, initialized and destroyed inside of setUp() method, hence it is not visible in testSearch() method.
In order to fix this problem, we just need to move driver variable declaration into a class (make it as a class field). 
NOTE – pay attention that driver = new ChromeDriver() does not contain WebDriver declaration;

```
public class GoogleSearchTest {
    WebDriver driver
    
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.30-win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }
    @Test
    public void testSearch() throws Exception {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("cheese");
     }
       
}
```

* What will be returned by each of the following methods (**method return type**):
```
    private WebElement getInput() {
        return driver.findElement(By.tagName("input"));
    }

    private String getInput() {
        return "<input></input>";
    }

    private List<WebElement> getInputList() {
        return driver.findElements(By.tagName("input"));
    }

    private List<String> getInputList() {
        List<String> list = new ArrayList<>();
        list.add("<input></input>");
        list.add("<input></input>");
        return list;
    }
```

   * **Answer**: 1 - WebElement, 2 - a string _"\<input>\</input>"_, 3 - list of WebElements, 4 - List of strings