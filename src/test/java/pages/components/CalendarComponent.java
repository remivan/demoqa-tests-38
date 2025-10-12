package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__week").$(byText("1")).click();

    }
}
