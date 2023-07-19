package org.example.test;

import org.example.pages.HomePage;
import org.example.pages.Language;
import org.example.setup.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.common.CustomLogger.logger;


public class Task5_3 extends BaseTest {
    @Test
    public void switchToUkrainian() {
        logger.info("Home page was opened");
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isInitialized());

        logger.info("Ukrainian language was selected");
        homePage.selectLanguage(Language.UA);

        Assertions.assertEquals(homePage.getPageHeader(), "Довгий заголовок на два рядки");
    }

    @Test
    public void switchToRussian() {
        logger.info("Home page was opened");
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isInitialized());

        logger.info("Russian language was selected");
        homePage.selectLanguage(Language.RU);

        Assertions.assertEquals(homePage.getPageHeader(), "Длинный заголовок в 2 строчки");
    }

    @Test
    public void switchToEnglish() {
        logger.info("Home page was opened");
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isInitialized());

        logger.info("English language was selected");
        homePage.selectLanguage(Language.EN);

        Assertions.assertEquals(homePage.getPageHeader(), "Long caption for 2 rows");

    }
}
