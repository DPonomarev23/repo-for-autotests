package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalComponent {
    public void verifyResult (String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldBe(visible).shouldHave(text(value));
    }
}
