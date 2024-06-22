package utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(10, 100));
        System.out.println(getRandomEmail());
        System.out.println(getRandomPhoneNumber());

        String [] names = {"a", "b", "c", "d", "e"};
        System.out.println(getRandomItemFromArray(names));
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

}
