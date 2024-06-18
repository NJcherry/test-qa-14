package com.demoqa;


import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPageObjectTests extends TestBase {

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender()
                .setMobile()
                .setBirthDate("30", "March", "1993")
                .setHobby()
                .setAddress()
                .setFile()
                .setSubject()
                .setState()
                .setCity()
                .submit()

                .verifyResultsModalAppears()
                .verifyResult("Student Name", "John Doe")
                .verifyResult("Student Email", "jdoe@gmail.com")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "9210642487")
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