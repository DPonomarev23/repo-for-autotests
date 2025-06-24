package allure;

import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class WebSteps {

    @Step ("Открываем главную страницу")
    public void openMainPage(){
            open("https://demoqa.com/automation-practice-form");
        }

    @Step ("Заполняем данные")
    public void setupData(){
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
    }

    @Step ("Проверяем корректность")
    public void accept(){
         $(".table-responsive").shouldBe(visible).shouldHave(text("1412414214"));
    }





    }

