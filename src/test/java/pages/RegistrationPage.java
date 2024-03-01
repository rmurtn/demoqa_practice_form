package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderLocator = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            selectHobby = $("#hobbiesWrapper"),
            uploadPicture= $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            selectState = $("#state"),
            selectCity = $("#city"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderLocator.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setSubject2(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage selectHobby(String value) {
        selectHobby.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage inputCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage selectState(String value) {
        selectState.click();
        selectState.$(byText(value)).click();

        return this;
    }

    public RegistrationPage selectCity(String value) {
        selectCity.click();
        selectCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResults(String value) {
        resultTableComponent.checkTableContent(value);

        return this;
    }
    public RegistrationPage checkTableVisibility() {
        resultTableComponent.tableVisibility();

        return this;
    }
}
