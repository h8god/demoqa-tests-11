package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            chooseGender = $(byText("Male")),
            mobileInput = $("#userNumber"),
            date = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbySports = $(byText("Sports")),
            hobbyMusic = $(byText("Music")),
            pictures = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            dropdownState = $("#state"),
            chooseState = $(byText("Haryana")),
            dropdownCity = $("#city"),
            chooseCity = $(byText("Panipat")),
            submitButton = $("#submit"),
            checkFormField = $(".table-responsive");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        chooseGender.click();
        return this;
    }

    public RegistrationPage setMobile(String mobile) {
        mobileInput.setValue(mobile);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        CalendarComponent calendarComponent = new CalendarComponent();
        date.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesSports() {
        hobbySports.click();
        return this;
    }

    public RegistrationPage setHobbiesMusic() {
        hobbyMusic.click();
        return this;
    }

    public RegistrationPage setPicture(String picture) {
        pictures.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        dropdownState.scrollTo().click();
        chooseState.click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        dropdownCity.scrollTo().click();
        chooseCity.click();
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void checkForm(
            String firstName, String lastName, String email,
            String gender, String mobile, String day, String month,
            String year, String subjects, String hobbies1,
            String hobbies2, String picture,
            String address, String state, String city) {
        checkFormField.shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(mobile),
                text(day + " " + month + "," + year),
                text(subjects),
                text(hobbies1),
                text(hobbies2),
                text(picture),
                text(address),
                text(state + " " + city));
    }
}
