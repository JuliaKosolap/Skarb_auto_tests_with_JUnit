package org.example.test;

import org.example.entity.Volunteer;
import org.example.pages.HomePage;
import org.example.pages.registration.SuccessRegistrationPage;
import org.example.setup.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import test_data.RandomData;

import static org.example.common.CustomLogger.logger;

public class Task13_1  extends BaseTest {
   @ParameterizedTest
   @MethodSource("testdata")
    public void createVolunteer(String firstName, String lastName, String email, String phoneNumber,
                                String password, String confirmPassword) {
       logger.info("Data for new volunteer was generated");
       Volunteer volunteer = new Volunteer(firstName, lastName, email, phoneNumber, password, confirmPassword);

       logger.info("Creating new volunteer");
       SuccessRegistrationPage successPage = (SuccessRegistrationPage) new HomePage(driver).
               goToRegistrationPage().
               goToVolunteerCreationPage().
               fillInMandatoryFields(volunteer).submit();

       Assertions.assertTrue(successPage.isInitialized());
       Assertions.assertEquals(successPage.getMessage(), "Congratulation! Your registration succeeded! Message was sent to your email. " +
               "Please confirm it.");
   }
    // Create object array with 3 rows and 6 columns: first parameter is row and second is column
    public static Object[][] testdata() {
      Object[][] volunteerData = new Object[3][6];
      int rowCount = 3;
      for (int i = 0; i < rowCount; i++) {
         volunteerData[i][0] = RandomData.randomFirstOrLastName(8);
      }
      for (int i = 0; i < rowCount; i++) {
         volunteerData[i][1] = RandomData.randomFirstOrLastName(8);
      }
      for (int i = 0; i < rowCount; i++) {
         volunteerData[i][2] = RandomData.randomEmail();
      }
      for (int i = 0; i < rowCount; i++) {
         volunteerData[i][3] = RandomData.randomPhoneNumber();
      }
      for (int i = 0; i < rowCount; i++) {
         volunteerData[i][4] = RandomData.randomPassword(8);
      }
      for (int i = 0; i < rowCount; i++) {
         volunteerData[i][5] = volunteerData[i][4];
      }
      return volunteerData;
   }
}
