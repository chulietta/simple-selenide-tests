package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindExamplesInWikiTests {

    @Test
    @DisplayName("Find JUnit5 example in Wiki")
    void findExampleForJUnit5() {
        //open selenide homepage
        open("https://github.com/selenide/selenide");

        //goto wiki
        $("[data-content='Wiki']").click();

        //goto SoftAssertions page
        $$("#wiki-body a").findBy(text("Soft assertions")).click();
        $(".repository-content h1").shouldHave(text("SoftAssertions"));

        //find example code for JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
