package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000;
    }

    @Test
    void fillPracticeFormTest() {

        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Tom");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("tom@smith.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $(".react-datepicker__year-select").selectOptionByValue("1960");
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images.jpeg");
        $("#currentAddress").setValue("111 Alpine St");
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Tom Smith"));
        $(".modal-body").shouldHave(text("tom@smith.com"));
        $(".modal-body").shouldHave(text("1111111111"));
        $(".modal-body").shouldHave(text("23 June,1960"));
        $(".modal-body").shouldHave(text("Maths, Computer Science"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("images.jpeg"));
        $(".modal-body").shouldHave(text("111 Alpine St"));
        $(".modal-body").shouldHave(text("Haryana Panipat"));
    }
}
