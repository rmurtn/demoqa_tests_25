package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.name;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Tom");
        $("#userEmail").setValue("tom@tom.com");
        $("#currentAddress").setValue("Toms Street");
        $("#permanentAddress").setValue("Toms Street");
        $("#submit").scrollTo().click();

        $("#output").$("#name").shouldHave(text("Tom"));
        $("#output").$("#email").shouldHave(text("tom@tom.com"));
        $("#output").$("#currentAddress").shouldHave(text("Toms Street"));
        $("#output").$("#permanentAddress").shouldHave(text("Toms Street"));
    }
}
