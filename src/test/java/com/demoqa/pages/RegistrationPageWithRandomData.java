package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.RegistrationResultsModal;
import io.qameta.allure.Step;

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

    @Step("Открываем демо-форму")
    public RegistrationPageWithRandomData openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }



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

    @Step("Вводим имя пользователя: {firstNameData}")
    public RegistrationPageWithRandomData setFirstName(String firstNameData) {
        firstName.setValue(firstNameData);
        return this;
    }

    @Step("Вводим фамилию пользователя: {lastNameData}")
    public RegistrationPageWithRandomData setLastName(String lastNameData) {
        lastName.setValue(lastNameData);
        return this;
    }

    @Step("Вводим email пользователя: {emailData}")
    public RegistrationPageWithRandomData setEmail(String emailData) {
        email.setValue(emailData);
        return this;
    }

    @Step("Выбираем пол пользователя: {gender}")
    public RegistrationPageWithRandomData setGender(String gender) {
        GENDER.$(byText(gender)).click();
        return this;
    }

    @Step("Вводим номер телефона пользователя: {mobileData}")
    public RegistrationPageWithRandomData setMobile(String mobileData) {
        mobile.setValue(mobileData);
        return this;
    }

    @Step("Вводим дату рождения пользователя: {day}, {month}, {year}")
    public RegistrationPageWithRandomData setBirthDate(String day, String month, String year) {
        birthDate.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Выбираем хобби пользователя: {hobbyData}")
    public RegistrationPageWithRandomData setHobby(String hobbyData) {
        hobby.$(byText(hobbyData)).click();
        return this;
    }

    @Step("Вводим адрес пользователя: {addressData}")
    public RegistrationPageWithRandomData setAddress(String addressData) {
        curAddress.setValue(addressData);
        return this;
    }

    @Step("Загружаем картинку: {file}")
    public RegistrationPageWithRandomData setFile(File file) {
        uploadFile.uploadFile(file);
        return this;
    }

    @Step("Вводим учебный предмет пользователя: {subjectData}")
    public RegistrationPageWithRandomData setSubject(String subjectData) {
        subject.setValue(subjectData).pressEnter();
        return this;
    }

    @Step("Выбираем страну пользователя: {stateData}")
    public RegistrationPageWithRandomData setState(String stateData) {
        state.scrollTo().click();
        $(byText(stateData)).click();
        return this;
    }

    @Step("Выбираем город пользователя: {cityData}")
    public RegistrationPageWithRandomData setCity(String cityData) {
        city.click();
        $(byText(cityData)).click();
        return this;
    }

    @Step("Кликаем на кнопку 'Submit'")
    public RegistrationPageWithRandomData submit() {
        submitButton.click();
        return this;
    }

    @Step("Проверяем отображение окна результатов")
    public RegistrationPageWithRandomData verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }
    @Step("Проверяем, что для {key} указано значение {value}")
    public RegistrationPageWithRandomData verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}