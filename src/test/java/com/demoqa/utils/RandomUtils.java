package com.demoqa.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science",
            "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(10, 100));
        System.out.println(getRandomEmail());
        System.out.println(getRandomPhoneNumber());

    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomString(int length) {
    String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@gmail.com";
    }

    public static String getRandomItemFromArray(String[] values){
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }

    public static String getRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        return phoneNumber.toString();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int randomIndex = (int) (Math.random() * genders.length);
        return genders[randomIndex];
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int randomIndex = (int) (Math.random() * hobbies.length);
        return hobbies[randomIndex];
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int randomIndex = (int) (Math.random() * states.length);
        return states[randomIndex];
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
                int ncrIndex = (int) (Math.random() * ncrCities.length);
                return ncrCities[ncrIndex];
            case "Uttar Pradesh":
                String[] upCities = {"Agra", "Lucknow", "Merrut"};
                int upIndex = (int) (Math.random() * upCities.length);
                return upCities[upIndex];
            case "Haryana":
                String[] haryanaCities = {"Karnal", "Panipat"};
                int haryanaIndex = (int) (Math.random() * haryanaCities.length);
                return haryanaCities[haryanaIndex];
            case "Rajasthan":
                String[] rajasthanCities = {"Jaipur", "Jaiselmer"};
                int rajasthanIndex = (int) (Math.random() * rajasthanCities.length);
                return rajasthanCities[rajasthanIndex];
            default:
                return "";
        }
    }
}
