package test.automation.school.module6.tests;

import org.testng.annotations.Test;
import test.automation.school.module6.pageobjects.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SmokeTest extends BaseTest{
    private HomePage homePage;

    @Test
    public void testInitialLanguage() {
        //Arrange
        homePage = new HomePage(driver);

        //Assert
        assertEquals("SLUDINĀJUMI", homePage.getPageHeaderHeadText());
    }

    @Test
    public void testSwitchingLanguageToRu() {
        //Arrange
        homePage = new HomePage(driver);

        //Act
        homePage.switchLangTo("RU");

        //Assert
        assertEquals("ОБЪЯВЛЕНИЯ", homePage.getPageHeaderHeadText());
    }

    @Test
    public void testSwitchingLanguageToLv() {
        //Arrange
        homePage = new HomePage(driver);


        //Act
        homePage.switchLangTo("RU");
        homePage.switchLangTo("LV");

        //Assert
        assertEquals("SLUDINĀJUMI", homePage.getPageHeaderHeadText());
    }
}
