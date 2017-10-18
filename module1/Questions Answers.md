1. Will this snippet code be executed if element is not found on the page? If not, then why?
    ```
    driver.findElement(By.id("some_id").isDisplayed())
    ```
    * **Answer**: it won`t be executed since _NoSuchElementException_ exception will be thrown when Selenium will try to find an element (perform findElement() method).
2. Why there is no `isPresent()` method for WebElement interface?
- maybe because we need to check that element is available AND is displayed.
    * **Answer**: First, let’s find out what is “is Present” in terms of Selenium. – it means that it is present in the HTML (DOM) that was downloaded by the browser from a server, but it does NOT mean that it is present (displayed) on the rendered screen (user may not see it since it might be hidden by CSS or other mechanism). It might me be displayed and might not. 
        The reason why it is not needed is:
        1. `driver.findElement()` will throw _NoSuchElementException_ if element is really not present. Basically `isPresent()` is already happening in the background when Selenium tries to find an element. If this element won`t be present, then Selenium will throw NoSuchElementException
        2. And if DOM has changed, then Selenium is automatically checking whether element is still present in the HTML (DOM) before you are invoking any command on an element
3. Which interface is responsible for controlling the browser and finding DOM elements?
    * **Answer**: WebDriver
4. Which interface is intended for interacting with DOM elements?
    * **Answer**: WebElement – it is Selenium`s representation of a HTML element and when WebElement is retrieved via driver.findElement(), then we can interact with the element
5. What `driver.findElement(...)` method returns?
    * **Answer**: it returns the first matching web element in loaded web page
6. What is the argument to `driver.findElement(...)` method?
    * **Answer**: _By_ Object
 
7. What is the difference between element is displayed and element is present?
    * **Answer**: we can use isPresent if element exists in a page (in DOM), but can be hidden on the page. isDisplayed returns true only if isPresent is true and element is visible. And isDisplayed throws exception if element does not exist in the DOM.- Which exception it throws? Actually, if element will not be present in DOM, it won`t be possible to locate this element in the first place and NoSuchElementException will be thrown. 
8. How to retrieve multiple elements at once? What would be variable type for referencing such Java object?
    * **Answer**: Need to use _WebDriver_ interface\`s `findElements()`. Return type of `findElements()` method is a List interface with type of WebElement (List<WebElement>)
9. How to bypass _NoSuchElementException_ if there is no guarantee that element will be found on the page?
    * **Answer**:  locating an element with findElements(By by) and checking for the List size
Or by handling NoSuchElementException
10. Will following code compilie? If not - why and how to resolve it?
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