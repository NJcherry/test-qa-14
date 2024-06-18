package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "800x600";
        Configuration.pageLoadStrategy = "eager";
    }

    private final String FIRST_NAME = "John";
    private final String LAST_NAME = "Doe";
    private final String EMAIL = "jdoe@gmail.com";
    private final String GENDER = "Female";
    private final String MOBILE = "9210642487";
    private final String HOBBY = "Music";
    File file = new File("src/test/resources/Siyanie-Severa-1.png");
    private final String CUR_ADDRESS = "Some St, 1";
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement gender = $(byText(GENDER));
    private final SelenideElement mobile = $("#userNumber");
    private final SelenideElement hobby = $(byText(HOBBY));
    private final SelenideElement curAddress = $("#currentAddress");
    private final SelenideElement submitButton = $("#submit");


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        firstName.setValue(FIRST_NAME);
        lastName.setValue(LAST_NAME);
        email.setValue(EMAIL);
        gender.scrollTo().click();
        mobile.setValue(MOBILE);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1999")).click();
        $(".react-datepicker__month-select").$(byText("April")).click();
        $$(".react-datepicker__day--027").get(0).click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        hobby.click();
        $("#uploadPicture").uploadFile(file);
        curAddress.setValue(CUR_ADDRESS);
        $("#state").scrollTo().click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        submitButton.click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").shouldHave(text(FIRST_NAME), text(LAST_NAME), text(EMAIL),
                text(MOBILE), text(CUR_ADDRESS));
        $(".table-responsive table").$(byText("Date of Birth")).parent().shouldHave(text("27 April,1999"));
        $(".table-responsive table").$(byText("Gender")).parent().shouldHave(text(GENDER));
        $(".table-responsive table").$(byText("Subjects")).parent().shouldHave(text("Arts"),
                text("Computer Science"));
        $(".table-responsive table").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive table").$(byText("Picture")).parent().shouldHave(text("Siyanie-Severa-1.png"));
        $(".table-responsive table").$(byText("Address")).parent().shouldHave(text(CUR_ADDRESS));
        $(".table-responsive table").$(byText("State and City")).parent().shouldHave(text("Rajasthan"), text("Jaipur"));

        closeWebDriver();
        //sleep(30_000);
    }
}