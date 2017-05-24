package test.automation.school.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class WebDriverHelper {

	public static void waitUntilPageIsLoaded(String title, WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.titleIs(title));
	}

	public static void selectDropdownValueByText(WebElement dropdownElem, String visibleText) {
		Select select = new Select(dropdownElem);
		select.selectByVisibleText(visibleText);
	}

	public static void selectDropdownValueByValue(WebElement dropdownElem, String dropdownValue) {
		Select select = new Select(dropdownElem);
		select.selectByValue(dropdownValue);
	}
}

