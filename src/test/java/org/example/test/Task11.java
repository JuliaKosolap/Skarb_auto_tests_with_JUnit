package org.example.test;

import org.example.pages.EntityType;
import org.example.pages.HomePage;
import org.example.pages.PartnerInfoPge;
import org.example.pages.VolunteerInfoPage;
import org.example.setup.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.common.CustomLogger.logger;

public class Task11 extends BaseTest {
    private String username = "yavorsk@gmail.com";
    private String password = "PAssword@1";
    @Test
    public void searchForVolunteer() {
        logger.info("Volunteers Info Page was opened");
        VolunteerInfoPage volunteerInfoPage = (VolunteerInfoPage) (new HomePage(driver)).
                goToLoginPage().
                login(username, password).
                goToEntityInfoPage(EntityType.VOLUNTEERS);

        logger.info("Search for the text: Marcus");
        String searchTxt = "Marcus";

        logger.info("Text searched");
        List<String> searchResult = volunteerInfoPage.search(searchTxt);

        Assertions.assertTrue(volunteerInfoPage.isVolunteerFound(searchResult, searchTxt));
    }

    @Test
    public void searchForPartner() {
        logger.info("Partner Info Page was opened");
        PartnerInfoPge partnerInfoPge = (PartnerInfoPge) (new HomePage(driver)).
                goToLoginPage().
                login(username, password).
                goToEntityInfoPage(EntityType.PARTNERS);

        logger.info("Search for the text: Thor");
        String searchTxt = "Thor";

        logger.info("Text searched");
        List<String> searchResult = partnerInfoPge.search(searchTxt);

        Assertions.assertTrue(partnerInfoPge.isPartnerFound(searchResult, searchTxt));
    }
}
