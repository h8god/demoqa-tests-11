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
        $("#uploadPicture").uploadFile(new File("src/test/files/nastroenie0007.jpg"));
        $("#currentAddress").setValue("Moscow");
        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").scrollTo().click();
        $(byText("Panipat")).click();
        $("#submit").click();

        // проверки заполнения полей

        $(".table-responsive").shouldHave(text("Igor Zvyagintsev"));
        $(".table-responsive").shouldHave(text("zvyagintsevis@yandex.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("13 May,1993"));
        $(".table-responsive").shouldHave(text("Commerce"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("nastroenie0007.jpg"));
        $(".table-responsive").shouldHave(text("Moscow"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));

    }



}
