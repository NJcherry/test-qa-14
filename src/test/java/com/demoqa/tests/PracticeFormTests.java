package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.config.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@DisplayName("Тестовая форма demoqa")
public class PracticeFormTests extends TestBase {

//    @BeforeAll
//    static void configure() {
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "800x600";
//        Configuration.pageLoadStrategy = "eager";
//        SelenideLogger.addListener("allure", new AllureSelenide());
//
//    }

    private final String FIRST_NAME = "John";
    private final String LAST_NAME = "Doe";
    private final String EMAIL = "jdoe@gmail.com";
    private final String GENDER = "Female";
    private final String MOBILE = "9210642487";
    private final String HOBBY = "Music";
    private final String SUBJECT = "Computer Science";
    File file = new File("src/test/resources/Siyanie-Severa-1.png");
    private final String CUR_ADDRESS = "Some St, 1";
    private final String STATE = "Rajasthan";
    private final String CITY = "Jaipur";
    private final String DAY = "27";
    private final String MONTH = "April";
    private final String YEAR = "1999";
    private final String IMAGE = "Siyanie-Severa-1.png";
    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement gender = $(byText(GENDER));
    private final SelenideElement mobile = $("#userNumber");
    private final SelenideElement subject = $("#subjectsInput");
    private final SelenideElement hobby = $(byText(HOBBY));
    private final SelenideElement curAddress = $("#currentAddress");
    private final SelenideElement picture = $("#uploadPicture");
    private final SelenideElement state = $("#state");
    private final SelenideElement stateOption = $("#react-select-3-option-3");
    private final SelenideElement city = $("#city");
    private final SelenideElement cityOption = $("#react-select-4-option-0");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement resultsWindow = $(".modal-dialog");
    private final SelenideElement resultsTitle = $("#example-modal-sizes-title-lg");
    private final SelenideElement results = $(".table-responsive table");


    @Test
    @DisplayName("Тест на заполнение формы")
    @Severity(SeverityLevel.BLOCKER)
    void fillFormTest() {
        step("Открываем главную страницу", () -> {
            open("/automation-practice-form");
        });
        step("Вводим имя пользователя " + FIRST_NAME, () -> {
            firstName.setValue(FIRST_NAME);
        });
        step("Вводим фамилию пользователя " + LAST_NAME, () -> {
            lastName.setValue(LAST_NAME);
        });
        step("Вводим email пользователя " + EMAIL, () -> {
            email.setValue(EMAIL);
        });
        step("Выбираем пол пользователя " + GENDER, () -> {
            gender.scrollTo().click();
        });
        step("Вводим номер телефона пользователя " + MOBILE, () -> {
            mobile.setValue(MOBILE);
        });
        step("Вводим дату рождения пользователя " + DAY + " " + MONTH + " " + YEAR, () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").$(byText(YEAR)).click();
            $(".react-datepicker__month-select").$(byText(MONTH)).click();
            $$(".react-datepicker__day--0" + DAY).get(0).click();
            $(".subjects-auto-complete__value-container").click();
        });

        step("Вводим учебный предмет пользователя " + SUBJECT, () -> {
            subject.setValue(SUBJECT).pressEnter();
        });
        step("Выбираем хобби пользователя " + HOBBY, () -> {
            hobby.click();
        });
        step("Загружаем картинку " + file, () -> {
            picture.uploadFile(file);
        });
        step("Вводим адрес пользователя " + CUR_ADDRESS, () -> {
            curAddress.setValue(CUR_ADDRESS);
        });
        step("Выбираем страну пользователя " + STATE, () -> {
            state.scrollTo().click();
            stateOption.click();
        });
        step("Выбираем город пользователя " + CITY, () -> {
            city.click();
            cityOption.click();
        });
        step("Кликаем на кнопку 'Submit'", () -> {
            submitButton.click();
        });
        step("Проверяем отображение окна результатов", () -> {
            resultsWindow.should(appear);
        });
        step("Проверяем отображение названия окна результатов", () -> {
            resultsTitle.shouldHave(text("Thanks for submitting the form"));
        });
        step("Проверяем соответствие вводных данных с результатами", () -> {
            results.shouldHave(text(FIRST_NAME), text(LAST_NAME), text(EMAIL),
                    text(MOBILE), text(CUR_ADDRESS), text(DAY + " " + MONTH + "," + YEAR), text(GENDER), text(SUBJECT),
                    text(HOBBY), text(IMAGE), text(STATE), text(CITY));
        });

//        closeWebDriver();
        //sleep(30_000);
    }
}