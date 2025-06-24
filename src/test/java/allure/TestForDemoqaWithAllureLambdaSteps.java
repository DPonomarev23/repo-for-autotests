package allure;

import mainTest.TestBase;
import mainTest.TestWIthPageObjectsForDemoqa;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class TestForDemoqaWithAllureLambdaSteps extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(TestWIthPageObjectsForDemoqa.class);

    @Test
    public void successfulTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://demoqa.com/automation-practice-form");
        });

        step("Заполняем ФИО", () -> {
            $("#firstName").setValue("John");
            $("#lastName").setValue("Ivanov");
        });

        step("Заполняем почту", () -> {
            $("#userEmail").setValue("dadad@mail.ru");
        });

        step("Заполняем номер телефона", () -> {
            $(".custom-control-label").click();
            $("#userNumber").setValue("1412414214");
        });

        step("Заполняем дату рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("January");
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__year-select").selectOption("1997");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__day--016").click();
        });

        step("Заполняем предмет", () -> {
            $(".subjects-auto-complete__value-container").click();
            $(".subjects-auto-complete__value-container").$("#subjectsInput").setValue("Hindi").pressEnter();
        });

        step("Заполняем хобби", () -> {
            $("#hobbiesWrapper .custom-control").click();
        });

        step("Загружаем файл", () -> {
            File file = new File("C:\\Users\\RenUser\\Desktop\\ihtr.jpg");
            $("#uploadPicture").uploadFile(file);
        });

        step("Заполняем адрес", () -> {
            $("#currentAddress").setValue("Волгоград");
        });

        step("Заполняем штат и город", () -> {
            $("#state").scrollIntoView(true).click();
            $$("div[id^=react-select-3-option-1]").findBy(text("Uttar Pradesh")).click();
            $("#city").click();
            $$("div[id^=react-select-4-option-0]").findBy(text("Agra")).click();
            $("#submit").click();;
        });

        step("Проверяем данные", () -> {
            $(".table-responsive").shouldBe(visible).shouldHave(text("1412414214"));
        });




    }

}
