* What will be returned (method return type) by each of the following methods:
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
1. First object that has tag name "input" or will throw an exception
2. "<input></input>" 
3. List of WebElements that have tag "input"
4. List of strings containing 2 records.

* Will this snippet code will be executed if element is not found on the page? If not, then why?
    ```
    driver.findElement(By.id("some_id").isDisplayed())
    ```
 1. Will throw an element not found exception
    
* Why there is no `isPresent()` method for WebElement interface?
1. IsDisplayed on WebElement object is sufficient.

* Which interface is responsible for controling the browser and finding DOM elements?
1. WebDriver

* Which interface is intended for interacting with DOM elements?
1. WebElement

* Name all the WebElement locating mechanisms?
1. className
2. cssSelector
3. id
4. linkText
5. partialLinkText
6. name
7. xpath
8. tagName

* What `driver.findElement(...)` method returns?
1. First found conforming WebElement object or throws an exception

* What is the argument to `driver.findElement(...)` method?
1. By class instance

* Which class defines different locating mechanisms?
1. By

* What is the difference between element is displayed and element is present?
1. Presence in DOM does not guarantee if element is displayed.

* How to retrieve multiple elements at once? What would be variable type for referencing such Java object?
1. WebDriver findElements method. 
2. Returns List<WebElements>

* How to bypass _NoSuchElementException_ if there is no gurantee that element will be found on the page?
1. Try catch or findElements, that will return empty list if no element is found.

* Which browser management strategy is better to use? Why?
1. New browser session for each test will provide cleaner test execution, but longer test running time, that is mitigated by parallel test running.

* What will happen if you will try to locate following element? (TIP - `display:none` sets element to be not rendered)
What will happen if isDisplayed will be invoked on this element?
```
  <div id='elementId' style='display:none'>
    ...
  </div>
```  
1. If we locate it in DOM - no problems.
2. It will return false, according to Selenium docs 