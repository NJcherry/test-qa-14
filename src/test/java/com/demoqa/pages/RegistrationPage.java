package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    private final String FIRST_NAME = "John",
            LAST_NAME = "Doe",
            EMAIL = "jdoe@gmail.com",
            GENDER = "Female",
            MOBILE = "9210642487",
            HOBBY = "Music",
            CUR_ADDRESS = "Some St, 1",
            SUBJECT = "Arts";

    File file = new File("src/test/resources/Siyanie-Severa-1.png");

    private final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            gender = $(byText(GENDER)),
            mobile = $("#userNumber"),
            birthDate = $("#dateOfBirthInput"),
            hobby = $(byText(HOBBY)),
            curAddress = $("#currentAddress"),
            uploadFile = $("#uploadPicture"),
            subject = $("#subjectsInput"),
            city = $("#city"),
            state = $("#state"),
            stateOption = $("#react-select-3-option-3"),
            cityOption = $("#react-select-4-option-0"),
            submitButton = $("#submit");

    public RegistrationPage setFirstName() {
        firstName.setValue(FIRST_NAME);
        return this;
    }

    public RegistrationPage setLastName() {
        lastName.setValue(LAST_NAME);
        return this;
    }

    public RegistrationPage setEmail() {
        email.setValue(EMAIL);
        return this;
    }

    public RegistrationPage setGender() {
        gender.scrollTo().click();
        return this;
    }

    public RegistrationPage setMobile() {
        mobile.setValue(MOBILE);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDate.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setHobby() {
        hobby.click();
        return this;
    }

    public RegistrationPage setAddress() {
        curAddress.setValue(CUR_ADDRESS);
        return this;
    }

    public RegistrationPage setFile() {
        uploadFile.uploadFile(file);
        return this;
    }

    public RegistrationPage setSubject() {
        subject.setValue(SUBJECT).pressEnter();
        return this;
    }

    public RegistrationPage setState() {
        state.scrollTo().click();
        stateOption.click();
        return this;
    }

    public RegistrationPage setCity() {
        city.click();
        cityOption.click();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}