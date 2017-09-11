package test.automation.school.tests;

import org.testng.annotations.Test;
import test.automation.school.BaseTest;
import test.automation.school.pageobjects.HomePage;
import test.automation.school.pageobjects.TopMenuBar;

import static org.testng.Assert.assertEquals;
import static test.automation.school.enums.Language.LV;
import static test.automation.school.enums.Language.RU;


public class SmokeTest extends BaseTest {
    private TopMenuBar topMenuBar;
    private HomePage homePage;

    @Test
    public void testInitialLanguage() throws Exception {
        //Arrange
        topMenuBar = new TopMenuBar(getDriver());
        homePage = new HomePage(getDriver());

        //Assert
        assertEquals("SLUDINĀJUMI", homePage.getPageHeaderHeadText());
    }

    @Test
    public void testSwitchingLanguageToRu() throws Exception {
        //Arrange
        topMenuBar = new TopMenuBar(getDriver());
        homePage = new HomePage(getDriver());

        //Act
        topMenuBar.switchLangTo(RU);

        //Assert
        assertEquals("ОБЪЯВЛЕНИЯ", homePage.getPageHeaderHeadText());
    }

    @Test
    public void testSwitchingLanguageToLv() throws Exception {
        //Arrange
        homePage = new HomePage(getDriver());
        topMenuBar = new TopMenuBar(getDriver());

        //Act
        topMenuBar.switchLangTo(RU);
        topMenuBar.switchLangTo(LV);

        //Assert
        assertEquals("SLUDINĀJUMI", homePage.getPageHeaderHeadText());
    }
}
