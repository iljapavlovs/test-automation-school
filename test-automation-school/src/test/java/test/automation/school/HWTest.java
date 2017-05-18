package test.automation.school;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.automation.school.pageobjects.*;

import static org.testng.Assert.assertTrue;

/**
 * Created by Max on 5/17/2017.
 */
public class HWTest extends BaseTest {
    HomePage homePage;
    SearchPage searchPage;
    SearchResultsPage searchResultsPage;

    @Test
    public void ssLvSearchTest() {
        // 1. Открыть браузер и развернуть на весь экран.
        // 2. Зайти на ss.lv.
        homePage = new HomePage(driver);

        // 3. Поменять язык на русский.
        homePage.switchLangTo("RU");

        //3a. navigate to Search page
        homePage.pageHeaderSearch.click();
        searchPage = new SearchPage(driver);

        // 4. в поиске ввести искомую фразу (напр. Компьютер....)
        searchPage.lookupTxt.sendKeys("Компьютер");
        //searchPage.lookupTxt.sendKeys("Компьютеры, оргтехника");

        // 5. выбрать разные параметры поиска
        searchPage.selectDrDwnValue(searchPage.themeDrDwn, "Электротехника");
        searchPage.selectDrDwnValue(searchPage.categoryDrDwn, "Компьютеры, оргтехника");
        searchPage.selectDrDwnValue(searchPage.regionDrDwn, "Рига");
        searchPage.selectDrDwnValue(searchPage.periodDrDwn, "Среди сегодняшних объявлений");

        // 6. Нажать кнопку Искать
        searchPage.searchBtn.click();

        // 7. удостовериться что отображается хотя бы одно объявление
        searchResultsPage = new SearchResultsPage(driver);
        //System.out.println("number of ads retrieved: " + searchResultsPage.searchResults.size());
        assertTrue(searchResultsPage.searchResults.size() >= 1);
    }


    @DataProvider(name="searchParams")
    public static Object[][] searchParams() {
        return new Object[][] {{"Рига","Среди сегодняшних объявлений"}, {"Юрмала","За последний месяц"},
                                {"Рижский р-он","За последнюю неделю"}};
    }

    @Test(dataProvider = "searchParams")
    public void ssLvSearchTestwithParams(String param3, String param4) {
        // 1. Открыть браузер и развернуть на весь экран.
        // 2. Зайти на ss.lv.
        homePage = new HomePage(driver);

        // 3. Поменять язык на русский.
        homePage.switchLangTo("RU");

        //3a. navigate to Search page
        homePage.pageHeaderSearch.click();
        searchPage = new SearchPage(driver);

        // 4. в поиске ввести искомую фразу (напр. Компьютер....)
        searchPage.lookupTxt.sendKeys("Компьютер");
        //searchPage.lookupTxt.sendKeys("Компьютеры, оргтехника");

        // 5. выбрать разные параметры поиска
        searchPage.selectDrDwnValue(searchPage.themeDrDwn, "Электротехника");
        searchPage.selectDrDwnValue(searchPage.categoryDrDwn, "Компьютеры, оргтехника");
        searchPage.selectDrDwnValue(searchPage.regionDrDwn, param3);
        searchPage.selectDrDwnValue(searchPage.periodDrDwn, param4);

        // 6. Нажать кнопку Искать
        searchPage.searchBtn.click();

        // 7. удостовериться что отображается хотя бы одно объявление
        searchResultsPage = new SearchResultsPage(driver);
        //System.out.println("number of ads retrieved: " + searchResultsPage.searchResults.size());
        assertTrue(searchResultsPage.searchResults.size() >= 1);
    }
}
