package com.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    @Test
    void simplePropertyTest1(){
    System.setProperty("browser", "opera");
    String browserName = System.getProperty("browser");
    System.out.println(browserName);
    }

    @Test
    void simplePropertyTest2() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }

    @Test
    @Tag("properties")
    void simplePropertyTest3() {
        String browserName = System.getProperty("browser_name", "firefox");
        String browserVersion = System.getProperty("browser_verion", "101");
        String browserSize = System.getProperty("browser_size", "1920x1080");
        System.out.println(browserName);
        System.out.println(browserVersion);
        System.out.println(browserSize);
    }

    @Test
    @Tag("hello")
    void simplePropertyTes5() {
        System.out.println("Hello, " + System.getProperty("some_text", "qa.guru"));
    }
}
