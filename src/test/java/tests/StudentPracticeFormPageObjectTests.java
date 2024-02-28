package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
public class StudentPracticeFormPageObjectTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName("Tom")
                .setLastName("Smith")
                .setUserEmail("tom@smith.com")
                .setGender("Male")
                .setPhoneNumber("1111111111")
                .setDateOfBirth( "5", "1960")
                .setSubject("Math")
                .setSubject2("Computer Science")
                .selectHobby("Sports")
                .uploadPicture("images.jpeg")
                .inputCurrentAddress("111 Alpine St")
                .selectState("Haryana")
                .selectCity("Panipat")
                .submitButton()
                .checkResults("Tom Smith")
                .checkResults("tom@smith.com")
                .checkResults("1111111111")
                .checkResults("23 June,1960")
                .checkResults("Maths, Computer Science")
                .checkResults("Sports")
                .checkResults("images.jpeg")
                .checkResults("111 Alpine St")
                .checkResults("Haryana Panipat");
    }

    @Test
    void fillPracticeFormMinValuesTest() {
        registrationPage.openPage()
                .setFirstName("Tom")
                .setLastName("Smith")
                .setGender("Male")
                .setPhoneNumber("1111111111")
                .submitButton()
                .checkResults("Tom Smith")
                .checkResults("1111111111");
    }

    @Test
    void fillPracticeFormRequiredFieldsTest() {
        registrationPage.openPage()
                .setPhoneNumber("1111111111")
                .setDateOfBirth("5", "1960")
                .setSubject("Math")
                .selectHobby("Sports")
                .uploadPicture("images.jpeg")
                .inputCurrentAddress("111 Alpine St")
                .selectState("Haryana")
                .selectCity("Panipat")
                .submitButton()
                .checkTableVisibility();
    }
}
