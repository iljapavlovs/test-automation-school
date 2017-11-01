package test.automation.school.cleancode.utils;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebdriverHelper {

    public static void selectByValueFromDropdown(WebElement operationDropdown, String value) {
        Select operationDropdownSelect = new Select(operationDropdown);
        operationDropdownSelect.selectByValue(value);
    }


}
