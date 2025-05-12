import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class TestForDemoqa {
    @BeforeAll
    static void setup() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void successfulTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("dadad@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("1412414214");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--016").click();
        $(".subjects-auto-complete__value-container").click();
        $(".subjects-auto-complete__value-container").$("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper .custom-control").click();
        File file = new File("C:\\Users\\RenUser\\Desktop\\ihtr.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("фыафыа");
        $("#state").scrollIntoView(true).click();
        $$("div[id^=react-select-3-option-1]").findBy(text("Uttar Pradesh")).click();
        $("#city").click();
        $$("div[id^=react-select-4-option-0]").findBy(text("Agra")).click();
        $("#submit").click();
        $(".table-responsive").shouldBe(visible).shouldHave(text("1412414214"));
    }
    }


