package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultModalComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultModalComponent resultModalComponent = new ResultModalComponent();
    private File file = new File("C:\\Users\\RenUser\\Desktop\\ihtr.jpg");
    private SelenideElement
            firstNameInput = ($("#firstName")),
            lastNameInput = ($("#lastName")),
            emailInput = ($("#userEmail")),
            dateOfBirthInput = ($("#dateOfBirthInput"));

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender() {
        $(".custom-control-label").click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultModalComponent(String key, String value) {
        resultModalComponent.verifyResult(key, value);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        $(".subjects-auto-complete__value-container").click();
        $(".subjects-auto-complete__value-container").$("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage uploadFile() {
        $("#hobbiesWrapper .custom-control").click();
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String value1, String value2) {
        $("#state").scrollIntoView(true).click();
        $$("div[id^=react-select-3-option-1]").findBy(text(value1)).click();
        $("#city").click();
        $$("div[id^=react-select-4-option-0]").findBy(text(value2)).click();
        return this;
    }

    public RegistrationPage submit() {
        $("#submit").click();
        return this;
    }
}
