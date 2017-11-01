package test.automation.school.cleancode;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Helper {

    public static void selectByValueFromDropdown(WebElement operationDropdown, String value) {
        Select operationDropdownSelect = new Select(operationDropdown);
        operationDropdownSelect.selectByValue(value);
    }


}
