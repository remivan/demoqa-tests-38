package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            formSubmit = $("#submit"),
            formOutput = $("#output");


    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage setName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setFormSumbit() {
        formSubmit.scrollTo().click();

        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        formOutput.$(By.id(key)).shouldHave(text(value));

        return this;
    }


}

