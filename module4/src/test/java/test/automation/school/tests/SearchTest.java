package test.automation.school.tests;


import org.testng.annotations.Test;
import test.automation.school.BaseTest;
import test.automation.school.enums.TimePeriod;
import test.automation.school.pageobjects.HomePage;
import test.automation.school.pageobjects.SearchPage;
import test.automation.school.pageobjects.SearchResultPage;
import test.automation.school.pageobjects.TopMenuBar;

import static org.testng.Assert.assertTrue;
import static test.automation.school.enums.Language.RU;
import static test.automation.school.enums.Location.RIGA;

public class SearchTest extends BaseTest {
    private TopMenuBar topMenuBar;
    private HomePage homePage;
    private SearchPage searchPage;

    @Test
    public void testSearch() throws Exception {
        //Arrange
        homePage = new HomePage(getDriver());
        topMenuBar = new TopMenuBar(getDriver());
        topMenuBar.switchLangTo(RU);
        searchPage = topMenuBar.goToSearchPage();

        //Act
        SearchResultPage searchResultPage = searchPage.searchForPhrase("Компьютер")
                .selectSubDivision("Электротехника")
                .selectCategory("Компьютеры, оргтехника")
                .selectLocation(RIGA)
                .selectTimePeriod(TimePeriod.LAST_MONTH)
                .performSearch();

        //Assert
        assertTrue(searchResultPage.getSearchResultElementCount() > 0);
    }
}
