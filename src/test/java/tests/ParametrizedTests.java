package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTests {


    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }



    @CsvSource(value = {
            "ivanov, 11111111",
            "sergeev, 2222222",
            "petrov, 333333"
    })
    @ParameterizedTest(name = "При неправильном вводе данных пользователю должна отображаться ошибка")
    @Tag("Negative")
    void loginNegativeTest(String families, String password)  {

        open("https://demoqa.com/login");
        $("#userName").setValue(families);
        $("#password").setValue(password);
        $("#login").pressEnter();
        $("#userForm").shouldHave(text("Invalid username or password!"));
    }





    @ValueSource(strings = {
            "Екатеринбург", "Москва", "Краснодар"
    })
    @ParameterizedTest(name = "Количество магазинов в городе {0} больше 0")
    @Tag("Medium")
    void searchShopsForCities(String cities)  {

        open("https://www.mvideo.ru/");
        $(".location").click();
        $(".location-select__location-list").$(byText(cities)).click();
        $(".shops").click();
        $$("li.store-locator-list-item").shouldBe(CollectionCondition.sizeGreaterThan(0));

    }







    static Stream<Arguments> checkCategory () {
        return Stream.of(
                Arguments.of("Computers", List.of("Desktops", "Notebooks", "Accessories")),
                Arguments.of("Electronics", List.of("Camera, photo", "Cell phones"))
        );
    }
    @MethodSource
    @ParameterizedTest(name = "В списке должны быть подкатегории, соответствующие выбранной категории")
    @Tag("Medium")
    void checkCategory(String category, List<String> subCategory)  {

        open("https://demowebshop.tricentis.com/");
        $(".list").$(byText(category)).click();
        $$(".item-box").shouldHave(texts(subCategory));
    }
}

