package reg.form.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {

     Faker faker = new Faker(new Locale("en"));
    public  String getRandomFirstName() {

        return faker.name().firstName();
    }


    public  String getRandomLastName() {

        return faker.name().lastName();
    }

    public  String getRandomEmail() {

        return faker.internet().emailAddress();
    }

    public  String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);
    }

    public  String getRandomPhone() {

        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getRandomDay() {
        int day = faker.number().numberBetween(01, 28);
        if (day < 10) {
            return "0" + day;
        } else {
            return Integer.toString(day);
        }
    }

    public String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        return faker.options().option(months);
    }

    public String getRandomYear() {
        int year = faker.number().numberBetween(1980, 2010);
        return Integer.toString(year);
    }
//    public  String[] getRandomDate(int minAge, int maxAge) {
//        Faker faker = new Faker();
//        Date date = faker.date().birthday(minAge, maxAge);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
//
//        return dateFormat.format(date).split("-");
//    }

    public  String getRandomSubject() {
        String[] subject = { "Computer Science", "Commerce", "Economics", "Social Studies"};

        return faker.options().option(subject);
    }

    public  String getRandomHobbies() {
        String[] hobby = {"Sports", "Reading", "Music"};

        return faker.options().option(hobby);
    }

    public  String getRandomAddress() {
        return faker.address().streetAddress();
    }

    public  String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return faker.options().option(state);
    }

    public  String getRandomCity(String state) {

        if (state.equals("NCR")) {
            String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};

            return faker.options().option(cityNCR);
        } else if (state.equals("Uttar Pradesh")) {
            String[] cityUP = {"Agra", "Lucknow", "Merrut"};

            return faker.options().option(cityUP);
        } else if (state.equals("Haryana")) {
            String[] cityH = {"Karnal", "Panipat"};

            return faker.options().option(cityH);
        } else {
            String[] cityR = {"Jaipur", "Jaiselmer"};

            return faker.options().option(cityR);
        }
    }
}