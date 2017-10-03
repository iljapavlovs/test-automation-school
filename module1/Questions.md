* Will this snippet code will be executed if element is not found on the page? If not, then why?
    ```
    driver.findElement(By.id("some_id").isDisplayed())
    ```
* Why there is no `isPresent()` method for WebElement interface?
* Which interface is responsible for controling the browser and finding DOM elements?
* Which interface is intended for interacting with DOM elements?
* Name all the WebElement locating mechanisms?
* What `driver.findElement(...)` method returns?
* What is the argument to `driver.findElement(...)` method?
* Which class defines different locating mechanisms?
* What is the difference between element is displayed and element is present?
* How to retrieve multiple elements at once? What would be variable type for referencing such Java object?
* How to bypass _NoSuchElementException_ if there is no gurantee that element will be found on the page?
* Which browser management strategy is better to use? Why?

* What will happen if you will try to locate following element? (TIP - `display:none` sets element to be not rendered)
What will happen if isDisplayed will be invoked on this element?
```
  <div id='elementId' style='display:none'>
    ...
  </div>
```  