package org.example.test;

import entity.Volunteer;
import org.example.pages.HomePage;
import org.example.pages.RegistrationPage;
import org.example.pages.SuccessRegistrationPage;
import org.example.pages.VolunteerCreationPage;
import org.example.setup.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import test_data.RandomData;

import java.util.List;

public class Task5_1 extends BaseTest {

    private String firstName = RandomData.randomFirstOrLastName(8);
    private String lastName = RandomData.randomFirstOrLastName(8);
    private String email = RandomData.randomEmail();
    private String phoneNumber = RandomData.randomPhoneNumber();
    private String password = RandomData.randomPassword(8);
    private String confirmPassword = password;
    private String invalidEmail = RandomData.invalidRandomEmail();


    @Test
    public void createVolunteerWithValidValues() {
        Volunteer volunteer = new Volunteer(firstName, lastName, email, phoneNumber, password, confirmPassword);
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized());
        RegistrationPage registrationPage = homePage.goToRegistrationPage();
        registrationPage.goToVolunteerCreationPage();
        VolunteerCreationPage volunteerCreationPage = new VolunteerCreationPage(driver);
        Assert.assertTrue(volunteerCreationPage.isInitialized());
        volunteerCreationPage.fillInMandatoryFields(volunteer);
        SuccessRegistrationPage successPage = (SuccessRegistrationPage) volunteerCreationPage.submit();
        Assert.assertTrue(successPage.isInitialized());
        Assert.assertEquals(successPage.getMessage(), "Congratulation! Your registration succeeded! Message was sent to your email. " +
                "Please confirm it.");
    }

    @Test
    public void createVolunteerWithInvalidEmail() {
        Volunteer volunteerWithInvalidEmail = new Volunteer(firstName, lastName, invalidEmail, phoneNumber, password, confirmPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized());

        RegistrationPage registrationPage = homePage.goToRegistrationPage();
        registrationPage.goToVolunteerCreationPage();

        VolunteerCreationPage volunteerCreationPage = new VolunteerCreationPage(driver);
        Assert.assertTrue(volunteerCreationPage.isInitialized());

        volunteerCreationPage.fillInMandatoryFields(volunteerWithInvalidEmail);
        volunteerCreationPage.submit();

        Assert.assertEquals(volunteerCreationPage.getEmailError(), "Email is incorrect");
    }

    @Test
    public void createVolunteerWithEmptyFields() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized());

        RegistrationPage registrationPage = homePage.goToRegistrationPage();
        registrationPage.goToVolunteerCreationPage();

        VolunteerCreationPage volunteerCreationPage = new VolunteerCreationPage(driver);
        Assert.assertTrue(volunteerCreationPage.isInitialized());

        volunteerCreationPage.submit();

        List<String> allErrorsOnPage = volunteerCreationPage.getAllErrorsOnPage();
        Assert.assertEquals(allErrorsOnPage.size(), 5);

        for (String error : allErrorsOnPage
        ) {
            Assert.assertEquals(error, "Field can`t be empty");
        }
    }
}
