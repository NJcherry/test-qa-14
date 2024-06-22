package com.demoqa.data;

import static utils.RandomUtils.*;

public class TestData {
    public String GENDER = getRandomGender(),
    FIRST_NAME = getRandomString(7),
    LAST_NAME = getRandomString(7),
    MOBILE = getRandomPhoneNumber(),
    EMAIL = getRandomEmail();

}
