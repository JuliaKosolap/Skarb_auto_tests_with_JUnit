package org.example.test;

import org.example.entity.Gender;
import org.example.entity.Partner;
import org.example.pages.HomePage;
import org.example.pages.registration.SuccessRegistrationPage;
import org.example.setup.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import test_data.RandomData;

import static org.example.common.CustomLogger.logger;

public class Task13_2 extends BaseTest {
    @ParameterizedTest
    @MethodSource("testdata")
    public void createPartner(String email, String firstName, String lastName, Gender gender, String password,
                              String confirmPassword, String organization, String positionInOrganization) {
        logger.info("-------Create Partner test was started--------");
        logger.info("Data for new partner is generated");
        Partner partner = new Partner(email, firstName, lastName, gender, password, confirmPassword,
                organization, positionInOrganization );

        logger.info("Creating new partner...");
        SuccessRegistrationPage successPage = (SuccessRegistrationPage) new HomePage(driver).
                goToRegistrationPage().
                goToPartnerCreationPage().
                fillInMandatoryFields(partner)
                .submit();

        Assertions.assertEquals(successPage.getMessage(), "Congratulation! Your registration succeeded! Message was sent to your email. " +
                "Please confirm it.");

    }
    // Create object array with 4 rows and 8 columns: first parameter is row and second is column
    public static Object[][] testdata() {
        Object[][] partnerData = new Object[4][8];
        int rowCount = 4;
        for (int i = 0; i < rowCount; i++) {
            partnerData[i][0] = RandomData.randomCorporateEmail();
        }
        for (int i = 0; i < rowCount; i++) {
            partnerData[i][1] = RandomData.randomFirstOrLastName(8);
        }
        for (int i = 0; i < rowCount; i++) {
            partnerData[i][2] = RandomData.randomFirstOrLastName(8);
        }
        for (int i = 0; i < rowCount; i++) {
            partnerData[i][3] = Gender.MALE;
        }
        for (int i = 0; i < rowCount; i++) {
            partnerData[i][4] = RandomData.randomPassword(8);
        }
        for (int i = 0; i < rowCount; i++) {
            partnerData[i][5] = partnerData[i][4];
        }
        for (int i = 0; i < rowCount; i++) {
            partnerData[i][6] = RandomData.randomString(10);
        }
        for (int i = 0; i < rowCount; i++) {
            partnerData[i][7] = RandomData.randomString(10);
        } return partnerData;
    }
}
