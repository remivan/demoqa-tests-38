package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;


public class RegistrationWithPageObjectTests extends TestBase{
        RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest()  {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setUserEmail("ivanov1900@gmail.com")
                .setGenderWrapper("Male")
                .setUserNumber("89031234567")
                .setDateOfBirth("1", "December", "2000")
                .setSubjectsInput("a", "Arts")
                .setHobbies("Music")
                .setPicture("1.jpg")
                .setAddress("Street 1, house 1")
                .setState("Haryana")
                .setCity("Karnal")
                .setFormSumbit();



        registrationPage.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "ivanov1900@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8903123456")
                .checkResult("Date of Birth", "01 December,2000")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "1.jpg")
                .checkResult("Address", "Street 1, house 1")
                .checkResult("State and City", "Haryana Karnal");
    }

    @Test
    void minimalFormTest()  {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGenderWrapper("Male")
                .setUserNumber("89031234567")
                .setFormSumbit();


        registrationPage.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8903123456");

    }


    @Test
    void negativeFormTest()  {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setFormSumbit();

        registrationPage.checkResult("Student Name", "Ivan Ivanov");

    }

}


