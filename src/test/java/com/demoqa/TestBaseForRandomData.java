package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPageWithRandomData;

public class TestBaseForRandomData {
    RegistrationPageWithRandomData registrationPageWithRandomData = new RegistrationPageWithRandomData();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "800x600";
        Configuration.pageLoadStrategy = "eager";
    }

}
