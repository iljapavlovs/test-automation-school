* Why test can stop on _NoSuchElementException_ when we provide WebElement instance to ExpctedConditions method?:
```
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("ptxt"))));
```
How to solve this problem?