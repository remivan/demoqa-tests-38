package tests;


import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setName("Ivan")
                .setEmail("ivanov1900@gmail.com")
                .setCurrentAddress("Street 1, house 1")
                .setPermanentAddress("Street 2, house 2")
                .setFormSumbit()
                .checkResult("name", "Ivan")
                .checkResult("email", "ivanov1900@gmail.com")
                .checkResult("currentAddress", "Street 1, house 1")
                .checkResult("permanentAddress", "Street 2, house 2");

    }
}
