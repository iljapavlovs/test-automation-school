package test.automation.school;

import org.junit.Assert;
import org.testng.annotations.Test;
import test.automation.school.pageobjects.HomePage;
import test.automation.school.pageobjects.SearchPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by lina.pugo on 5/17/2017.
 */
public class NewTest extends BaseTest {
    HomePage homePage;
    SearchPage searchPage;
    @Test
    public void testSearch() {
        //Arrange
        homePage = new HomePage(driver);
        homePage.switchLangTo("RU");
        homePage.pressSearch();

        searchPage = new SearchPage(driver);
        searchPage.inputSearchParameter("Samsung");
        searchPage.selectSearchParamaterFromDropdown("Электротехника", searchPage.findSearchCategory);
        searchPage.selectSearchParamaterFromDropdown("Телефоны и связь", searchPage.findSearchSubCategory);
        searchPage.selectSearchParamaterFromDropdown("Рига", searchPage.findSearchRegion);
        searchPage.selectSearchParamaterFromDropdown("За последнюю неделю", searchPage.findSearchPeriod);

        //Act
        searchPage.clickSearchButton();

        //Assert
        Assert.assertEquals("There are no search results displayed","Цена", searchPage.searchResultsPresent.getText());
    }
}
