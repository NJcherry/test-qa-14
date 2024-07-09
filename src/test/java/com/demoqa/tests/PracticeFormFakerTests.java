package com.demoqa.tests;


import com.demoqa.config.TestBase;
import com.demoqa.data.TestData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPageWithRandomData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class PracticeFormFakerTests extends TestBase {

    @Test
    @DisplayName("Тест c faker на заполнение формы")
    @Severity(SeverityLevel.BLOCKER)
    void successfulRegistrationTest() {
        TestData td = new TestData();
        RegistrationPageWithRandomData registrationPageWithRandomData = new RegistrationPageWithRandomData();

        registrationPageWithRandomData.openPage()
                .setFirstName(td.userName)
                .setLastName(td.lastName)
                .setEmail(td.userEmail)
                .setGender(td.GENDER)
                .setMobile(td.userMobile)
                .setBirthDate("30", "March", "1993")
                .setHobby(td.HOBBY)
                .setAddress(td.address)
                .setFile(td.image)
                .setSubject(td.SUBJECTS)
                .setState(td.STATE)
                .setCity(td.CITY)
                .submit()

                .verifyResultsModalAppears()
                .verifyResult("Student Name", td.userName + " " + td.lastName)
                .verifyResult("Student Email", td.userEmail)
                .verifyResult("Gender", td.GENDER)
                .verifyResult("Mobile", td.userMobile)
                .verifyResult("Date of Birth", "30 March,1993")
                .verifyResult("Hobbies", td.HOBBY)
                .verifyResult("Address", td.address)
                .verifyResult("Picture", "Siyanie-Severa-1.png")
                .verifyResult("Subjects", td.SUBJECTS)
                .verifyResult("State and City", td.STATE + " " + td.CITY);

        //sleep(30_000);
//        closeWebDriver();

    }
}