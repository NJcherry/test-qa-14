package com.demoqa;


import com.demoqa.data.TestData;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static utils.RandomUtils.*;

public class PracticeFormRandomUtilsTests extends TestBaseForRandomData {

    @Test
    void successfulRegistrationTest() {
        TestData td = new TestData();

        registrationPageWithRandomData.openPage()
                .setFirstName(td.FIRST_NAME)
                .setLastName(td.LAST_NAME)
                .setEmail(td.EMAIL)
                .setGender(td.GENDER)
                .setMobile(td.MOBILE)
                .setBirthDate("30", "March", "1993")
                .setHobby()
                .setAddress()
                .setFile()
                .setSubject()
                .setState()
                .setCity()
                .submit()

                .verifyResultsModalAppears()
                .verifyResult("Student Name", td.FIRST_NAME + " " + td.LAST_NAME)
                .verifyResult("Student Email", td.EMAIL)
                .verifyResult("Gender", td.GENDER)
                .verifyResult("Mobile", td.MOBILE)
                .verifyResult("Date of Birth", "30 March,1993")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Address", "Some St, 1")
                .verifyResult("Picture", "Siyanie-Severa-1.png")
                .verifyResult("Subjects", "Arts")
                .verifyResult("State and City", "Rajasthan Jaipur");

        //sleep(30_000);
        closeWebDriver();

    }
}