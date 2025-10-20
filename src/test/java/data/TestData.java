package data;

import com.github.javafaker.Faker;

import java.util.Locale;


public class TestData {

    Faker faker = new Faker(new Locale("it"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String streetAddress = faker.address().streetAddress();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Female", "Male", "Other");
    public String hobbie = faker.options().option("Sports", "Reading", "Music");
    public String subjects = faker.options().option("Arts", "Maths", "Accounting", "Social Studies");
    public String phone = faker.phoneNumber().subscriberNumber(10);
    public String day = String.format("%s", faker.number().numberBetween(1, 28));
    public String month= faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public String year = String.format("%s", faker.number().numberBetween(1950, 2025));
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana");
    public String city = getCity();

    public String getCity() {

        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgagon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Rajasthan" -> faker.options().option("Jaiselmer", "Jaipur");
            default -> faker.options().option("Karnal", "Panipat");
        };
    }




}
