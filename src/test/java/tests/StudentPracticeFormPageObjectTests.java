package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static tests.TestData.*;

public class StudentPracticeFormPageObjectTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = getFirstName(),
            lastName = getLastName(),
            userEmail = getEmail(),
            address = getAddress(),
            gender = getGender(),
            phoneNumber = getPhoneNumber(),
            birthDay = getBirthDay(),
            birthMonth = getBirthMonth(),
            birthYear = getBirthYear(),
            firstSubject = getFirstSubject(),
            secondSubject = getSecondSubject(),
            hobby = getHobby(),
            picture = getPicture(),
            state = getState(),
            city = getCity();


    @Test
    void fillPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setFirstSubject(firstSubject)
                .setSecondSubject(secondSubject)
                .selectHobby(hobby)
                .uploadPicture(picture)
                .inputCurrentAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitButton()
                .checkResults(firstName + " " + lastName)
                .checkResults(userEmail)
                .checkResults(phoneNumber)
                .checkResults(birthDay + " " + birthMonth + "," + birthYear)
                .checkResults(firstSubject + ", " + secondSubject)
                .checkResults(hobby)
                .checkResults(picture)
                .checkResults(address)
                .checkResults(state + " " + city);
    }

    @Test
    void fillPracticeFormMinValuesTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .submitButton()
                .checkResults(firstName + " " + lastName)
                .checkResults(phoneNumber);
    }

    @Test
    void fillPracticeFormRequiredFieldsTest() {
        registrationPage.openPage()
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setFirstSubject(firstSubject)
                .setSecondSubject(secondSubject)
                .selectHobby(hobby)
                .uploadPicture(picture)
                .inputCurrentAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitButton()
                .checkTableVisibility();
    }
}
