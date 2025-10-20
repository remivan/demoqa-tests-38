package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalComponent;
import data.TestData;



public class RegistrationWithFakerTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    ModalComponent modalComponent = new ModalComponent();
    TestData testData = new TestData();


    @Test
    void fillFormTest()  {


        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setGenderWrapper(testData.gender)
                .setUserNumber(testData.phone)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubjectsInput(testData.subjects)
                .setHobbies(testData.hobbie)
                .setPicture("1.jpg")
                .setAddress(testData.streetAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .setFormSumbit();



        modalComponent.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phone)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbie)
                .checkResult("Picture", "1.jpg")
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.state + " " + testData.city);

    }


    @Test
    void minimalFormTest()  {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderWrapper(testData.gender)
                .setUserNumber(testData.phone)
                .setFormSumbit();


        modalComponent.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phone);

    }


    @Test
    void negativeFormTest()  {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setFormSumbit();

        modalComponent.checkResult("Student Name", testData.firstName + " " + testData.lastName);

    }

}