package com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkSelenideGithubTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void findingCodeTest() {
        open("https://github.com/");
        $(byText("Search or jump to...")).click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$("[data-testid='results-list']").first().$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(byText("Show 3 more pages…")).scrollTo().click();
        $("#wiki-pages-box").shouldHave(Condition.text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $$("h4").last().scrollTo().shouldHave(Condition.text("3. Using JUnit5 extend test class:"));

        closeWebDriver();
    }
}
