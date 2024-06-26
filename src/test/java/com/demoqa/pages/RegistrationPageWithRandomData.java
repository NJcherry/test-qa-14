package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.utils.RandomUtils.*;

public class RegistrationPageWithRandomData {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    public String MOBILE = getRandomPhoneNumber(),
    FIRST_NAME = getRandomString(6),
        LAST_NAME = getRandomString(10),
    EMAIL = getRandomEmail();

    public RegistrationPageWithRandomData openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    File file = new File("src/test/resources/Siyanie-Severa-1.png");

    private final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            GENDER = $("#genterWrapper"),
            mobile = $("#userNumber"),
            birthDate = $("#dateOfBirthInput"),
            hobby = $("#hobbiesWrapper"),
            curAddress = $("#currentAddress"),
            uploadFile = $("#uploadPicture"),
            subject = $("#subjectsInput"),
            city = $("#city"),
            state = $("#state"),
            submitButton = $("#submit");

    public RegistrationPageWithRandomData setFirstName(String firstNameData) {
        firstName.setValue(firstNameData);
        return this;
    }

    public RegistrationPageWithRandomData setLastName(String lastNameData) {
        lastName.setValue(lastNameData);
        return this;
    }

    public RegistrationPageWithRandomData setEmail(String emailData) {
        email.setValue(emailData);
        return this;
    }

    public RegistrationPageWithRandomData setGender(String gender) {
        GENDER.$(byText(gender)).click();
        return this;
    }

    public RegistrationPageWithRandomData setMobile(String mobileData) {
        mobile.setValue(mobileData);
        return this;
    }

    public RegistrationPageWithRandomData setBirthDate(String day, String month, String year) {
        birthDate.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPageWithRandomData setHobby(String hobbyData) {
        hobby.$(byText(hobbyData)).click();
        return this;
    }

    public RegistrationPageWithRandomData setAddress(String addressData) {
        curAddress.setValue(addressData);
        return this;
    }

    public RegistrationPageWithRandomData setFile() {
        uploadFile.uploadFile(file);
        return this;
    }

    public RegistrationPageWithRandomData setSubject(String subjectData) {
        subject.setValue(subjectData).pressEnter();
        return this;
    }

    public RegistrationPageWithRandomData setState(String stateData) {
        state.scrollTo().click();
        $(byText(stateData)).click();
        return this;
    }

    public RegistrationPageWithRandomData setCity(String cityData) {
        city.click();
        $(byText(cityData)).click();
        return this;
    }

    public RegistrationPageWithRandomData submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPageWithRandomData verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPageWithRandomData verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}