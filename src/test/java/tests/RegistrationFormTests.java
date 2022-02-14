package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormTests {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Igor";
    String lastName = "Zvyagintsev";
    String userEmail = "zvyagintsevis@yandex.ru";
    String gender = "Male";
    String mobile = "1234567890";
    String day = "13";
    String year = "1993";
    String month = "May";
    String subjects = "Commerce";
    String hobbySport = "Sport";
    String hobbyMusic = "Music";
    String picture = "nastroenie0007.jpg";
    String currentAddress = "Moscow";
    String state = "Haryana";
    String city = "Panipat";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setMobile(mobile)
                .setDate(day, month, year)
                .setSubjects(subjects)
                .setHobbiesSports()
                .setHobbiesMusic()
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        // проверка заполнения полей
        registrationPage.checkForm(
                firstName, lastName, userEmail, gender, mobile,
                day, month, year, subjects, hobbySport, hobbyMusic,
                picture, currentAddress, state, city);
    }

}

