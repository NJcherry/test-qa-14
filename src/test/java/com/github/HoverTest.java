package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HoverTest {
    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        String userDataDir = "/tmp/chrome-profile-" + UUID.randomUUID();

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless",
                "--disable-dev-shm-usage",
                "--no-sandbox",
                "--window-size=1920,1080",
                "--user-data-dir=" + userDataDir
        );
    }

    @Test
    @Tag("github")
    void testHover() {
        open("https://github.com/");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $("[aria-labelledby ='solutions-by-company-size-heading']").$(byText("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));

       // sleep(30_000);
    }
}