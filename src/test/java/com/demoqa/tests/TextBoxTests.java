package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "800x600";
        Configuration.pageLoadStrategy = "eager";
    }

    private final String NAME = "John Doe";
    private final String EMAIL = "jdoe@gmail.com";
    private final String CUR_ADDRESS = "Some St, 1";
    private final String PER_ADDRESS = "Another St, 2";
    private final SelenideElement nameId = $("#userName");
    private final SelenideElement emailId = $("#userEmail");
    private final SelenideElement curAddressId = $("#currentAddress");
    private final SelenideElement perAddressId = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement inputNameId = $("#name");
    private final SelenideElement inputEmailId = $("#email");
    private final SelenideElement inputCurAddress = $("p#currentAddress");
    private final SelenideElement inputPerAddress = $("p#permanentAddress");

    @Test
    void fillFormTest() {
        open("/text-box");
        nameId.setValue(NAME);
        emailId.setValue(EMAIL);
        curAddressId.setValue(CUR_ADDRESS);
        perAddressId.setValue(PER_ADDRESS);
        submitButton.click();
        inputNameId.shouldHave(Condition.text(NAME));
        inputEmailId.shouldHave(Condition.text(EMAIL));
        inputCurAddress.shouldHave(Condition.text(CUR_ADDRESS));
        inputPerAddress.shouldHave(Condition.text(PER_ADDRESS));

        closeWebDriver();
    }
}
