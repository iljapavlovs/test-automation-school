package test.automation.school.tests;


import org.testng.annotations.Test;
import test.automation.school.BaseTest;
import test.automation.school.enums.TimePeriod;
import test.automation.school.pageobjects.ExtendedSearchPage;
import test.automation.school.pageobjects.HomePage;
import test.automation.school.pageobjects.SearchPage;
import test.automation.school.pageobjects.SearchResultPage;
import test.automation.school.pageobjects.SelectedAdvertismentsPage;
import test.automation.school.pageobjects.TopMenuBar;
import test.automation.school.utils.Helper;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static test.automation.school.enums.Language.RU;
import static test.automation.school.enums.Location.RIGA;

public class Task2Test extends BaseTest {

    private TopMenuBar topMenuBar;
    private HomePage homePage;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;
    private SelectedAdvertismentsPage selectedAdvertismentsPage;
    private ExtendedSearchPage extendedSearchResultPage;

    @Test
    public void testSearch() throws Exception {
        //Arrange
        homePage  = new HomePage(getDriver());
        topMenuBar = new TopMenuBar(getDriver());
        topMenuBar.switchLangTo(RU);
        searchPage = topMenuBar.goToSearchPage();

        //Act
         searchResultPage = searchPage.searchForPhrase("Компьютер")
                .selectSubDivision("Электротехника")
                .selectCategory("Компьютеры, оргтехника")
                .selectLocation(RIGA)
                .selectTimePeriod(TimePeriod.LAST_MONTH)
                .performSearch();

        searchResultPage.sortByPrice();


        System.out.println(searchResultPage.getSearchResultElementCount());

//        System.out.println(searchResultPage.getSearchElementsPriceStringList());
        System.out.println(searchResultPage.getSearchElementsPriceList());

        System.out.println(Helper.isListSortedInAscendingOrder(searchResultPage.getSearchElementsPriceList()));

//        List<Integer>  listOfInts = new ArrayList<>();
//        listOfInts.add(0, 1);
//        listOfInts.add(0, 2);
//        listOfInts.add(0, 3);
//        listOfInts.add(0, 4);
//        listOfInts.add(0, 5);
//
//
//
//        System.out.println(listOfInts);
//        System.out.println(WebDriverHelper.isListSortedInDescendingOrder(listOfInts));

        extendedSearchResultPage = searchResultPage.selectDealType("Продажа")
                .goToExtendedSearch();

        searchResultPage = extendedSearchResultPage.setPriceBoundaries("0", "300")
                .selectTimePeriod(TimePeriod.ALL_PERIOD)
                .performSearch();

        List<String> searchedAdsTextList = searchResultPage.getSearchResultElementsText(3);

         selectedAdvertismentsPage = searchResultPage.checkCheckboxes(3)
                .showSelectedAdvertisments();


        List<String> selectedAdsTextList = selectedAdvertismentsPage.getSelectedAdsElementsText(3);
        assertEquals(searchedAdsTextList.size(), selectedAdsTextList.size());

        Collections.sort(searchedAdsTextList);
        Collections.sort(selectedAdsTextList);
        for (int i = 0; i < searchedAdsTextList.size(); i++) {
            assertTrue(searchedAdsTextList.get(i).contains(selectedAdsTextList.get(i)));
        }

    }


}
