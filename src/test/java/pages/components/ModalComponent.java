package pages.components;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {

    private final SelenideElement modalCheck = $(".table-responsive");

    public ModalComponent checkResult(String key, String value) {
        modalCheck.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
