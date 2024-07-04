package com.demoqa.data;

import com.github.javafaker.Faker;

import java.io.File;

import static com.demoqa.utils.RandomUtils.*;

public class TestData {
    Faker faker = new Faker();
    public File image = new File("src/test/resources/Siyanie-Severa-1.png");

    public String GENDER = getRandomGender(),
    SUBJECTS = getRandomItemFromArray(subjects),
    HOBBY = getRandomHobby(),
    STATE = getRandomState(),
    CITY = getRandomCity(STATE),
            FIRST_NAME = getRandomString(7),
            LAST_NAME = getRandomString(7),
            MOBILE = getRandomPhoneNumber(),
            EMAIL = getRandomEmail(),

    userName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userMobile = "7" + String.valueOf(faker.number().numberBetween(100000000, 999999999)),
            address = faker.address().fullAddress();

}
