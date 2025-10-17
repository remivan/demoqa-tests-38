package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalComponent;
import utils.RandomUtils;



public class RegistrationWithFakerTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    ModalComponent modalComponent = new ModalComponent();
    RandomUtils randomUtils = new RandomUtils();


    @Test
    void fillFormTest()  {


        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserEmail(randomUtils.email)
                .setGenderWrapper(randomUtils.gender)
                .setUserNumber(randomUtils.phone)
                .setDateOfBirth(randomUtils.day, randomUtils.month, randomUtils.year)
                .setSubjectsInput(randomUtils.subjects)
                .setHobbies(randomUtils.hobbie)
                .setPicture("1.jpg")
                .setAddress(randomUtils.streetAddress)
                .setState(randomUtils.state)
                .setCity(randomUtils.city)
                .setFormSumbit();



        modalComponent.checkResult("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResult("Student Email", randomUtils.email)
                .checkResult("Gender", randomUtils.gender)
                .checkResult("Mobile", randomUtils.phone)
                .checkResult("Date of Birth", randomUtils.day + " " + randomUtils.month + "," + randomUtils.year)
                .checkResult("Subjects", randomUtils.subjects)
                .checkResult("Hobbies", randomUtils.hobbie)
                .checkResult("Picture", "1.jpg")
                .checkResult("Address", randomUtils.streetAddress)
                .checkResult("State and City", randomUtils.state + " " + randomUtils.city);

    }


    @Test
    void minimalFormTest()  {

        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGenderWrapper(randomUtils.gender)
                .setUserNumber(randomUtils.phone)
                .setFormSumbit();


        modalComponent.checkResult("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResult("Gender", randomUtils.gender)
                .checkResult("Mobile", randomUtils.phone);

    }


    @Test
    void negativeFormTest()  {

        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setFormSumbit();

        modalComponent.checkResult("Student Name", randomUtils.firstName + " " + randomUtils.lastName);

    }

}