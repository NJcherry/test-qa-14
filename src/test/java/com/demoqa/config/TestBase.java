package com.demoqa.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {


    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "800x600";
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

}
