package reg.form.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RandomUtils {


    public static String getRandomFirstName() {

        return new Faker(Locale.ENGLISH).name().firstName();
    }


    public static String getRandomLastName() {

        return new Faker(Locale.ENGLISH).name().lastName();
    }

    public static String getRandomEmail() {

        return new Faker().internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return new Faker().options().option(genders);
    }

    public static String getRandomPhone() {

        return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static String[] getRandomDate(int minAge, int maxAge) {
        Faker faker = new Faker();
        Date date = faker.date().birthday(minAge, maxAge);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);

        return dateFormat.format(date).split("-");
    }

    public static String getRandomSubject() {
        String[] subject = { "Computer Science", "Commerce", "Economics", "Social Studies"};

        return new Faker().options().option(subject);
    }

    public static String getRandomHobbies() {
        String[] hobby = {"Sports", "Reading", "Music"};

        return new Faker().options().option(hobby);
    }

    public static String getRandomAddress() {
        return new Faker().address().streetAddress();
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return new Faker().options().option(state);
    }

    public static String getRandomCity(String state) {

        if (state.equals("NCR")) {
            String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};

            return new Faker().options().option(cityNCR);
        } else if (state.equals("Uttar Pradesh")) {
            String[] cityUP = {"Agra", "Lucknow", "Merrut"};

            return new Faker().options().option(cityUP);
        } else if (state.equals("Haryana")) {
            String[] cityH = {"Karnal", "Panipat"};

            return new Faker().options().option(cityH);
        } else {
            String[] cityR = {"Jaipur", "Jaiselmer"};

            return new Faker().options().option(cityR);
        }
    }
}