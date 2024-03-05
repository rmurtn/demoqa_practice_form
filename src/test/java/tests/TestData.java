package tests;

import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();
    static String state, city;

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getAddress() {
        return faker.address().streetAddress();
    }

    public static String getGender() {
        return faker.demographic().sex();
    }

    public static String getPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getBirthDay() {
        return String.valueOf(faker.number().numberBetween(1, 31));
    }

    public static String getBirthMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public static String getBirthYear() {
        return String.valueOf(faker.number().numberBetween(1920, 2023));
    }

    public static String getFirstSubject() {
        return faker.options().option("Math", "Computer Science", "Accounting", "English", "Physics", "Arts"
                , "Social Studies");
    }

    public static String getSecondSubject() {
        return faker.options().option("Math", "Computer Science", "Accounting", "English", "Physics", "Arts"
                , "Social Studies");
    }

    public static String getHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getPicture() {
        return faker.options().option("images.jpeg");
    }

    public static String getState() {
        return state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getCity() {
        String cityOfNCRState = faker.options().option("Delhi", "Gurgaon", "Noida");
        String cityOfUttarPradeshState = faker.options().option("Agra", "Lucknow", "Merrut");
        String cityOfHaryanaState = faker.options().option("Karnal", "Panipat");
        String cityOfRajasthanState = faker.options().option("Jaipur", "Jaiselmer");

        switch (state) {
            case "NCR":
                city = cityOfNCRState;
                break;
            case "Uttar Pradesh":
                city = cityOfUttarPradeshState;
                break;
            case "Haryana":
                city = cityOfHaryanaState;
                break;
            default:
                city = cityOfRajasthanState;
        }
        return city;
    }
}

