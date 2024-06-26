package com.demoqa;


import com.demoqa.data.TestData;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class PracticeFormFakerTests extends TestBaseForRandomData {

    @Test
    void successfulRegistrationTest() {
        TestData td = new TestData();

        registrationPageWithRandomData.openPage()
                .setFirstName(td.userName)
                .setLastName(td.lastName)
                .setEmail(td.userEmail)
                .setGender(td.GENDER)
                .setMobile(td.userMobile)
                .setBirthDate("30", "March", "1993")
                .setHobby(td.HOBBY)
                .setAddress(td.address)
                .setFile()
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
                .verifyResult("State and City", td.STATE + td.CITY);

        //sleep(30_000);
        closeWebDriver();

    }
}