package allure;

import mainTest.TestWIthPageObjectsForDemoqa;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import mainTest.TestBase;

public class TestForDemoqaWithAllureAnnotatedSteps extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(TestWIthPageObjectsForDemoqa.class);

    @Test
    @Feature("Form")
    @Story("Form completion")
    @Owner("PonomarevDP")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение анкеты и проверка на корректность данных")
    public void successfulTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
WebSteps steps = new WebSteps();
steps.openMainPage();
steps.setupData();
steps.accept();

    }
}
