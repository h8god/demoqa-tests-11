package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Igor");
        $("#lastName").setValue("Zvyagintsev");
        $("#userEmail").setValue("zvyagintsevis@yandex.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__month-select").selectOption("May");
        $(byText("13")).click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("nastroenie0007.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").scrollTo().click();
        $(byText("Panipat")).click();
        $("#submit").click();

        // проверки заполнения полей

        $(".table-responsive").shouldHave(
                text("Igor Zvyagintsev"),
                text("zvyagintsevis@yandex.ru"),
                text("Male"),
                text("1234567890"),
                text("13 May,1993"),
                text("Commerce"),
                text("Sports"),
                text("Music"),
                text("nastroenie0007.jpg"),
                text("Moscow"),
                text("Haryana Panipat"));
    }
}
