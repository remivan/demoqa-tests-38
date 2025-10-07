
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;





public class DemoqaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void fillFormTest()  {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");

        $("#userEmail").setValue("ivanov1900@gmail.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("89031234567");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__week").$(byText("1")).click();

        $("#subjectsInput").setValue("a");
        $(".subjects-auto-complete__menu").$(byText("Arts")).click();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("1.jpg");

        $(byText("Submit")).scrollTo();

        $("#currentAddress").setValue("Street 1, house 1");

        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();

        $("#city").click();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("#submit").click();



        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("ivanov1900@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8903123456"));
        $(".table-responsive").shouldHave(text("01 December,2000"));
        $(".table-responsive").shouldHave(text("Arts"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("1.jpg"));
        $(".table-responsive").shouldHave(text("Street 1, house 1"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
    }
}


