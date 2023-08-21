package reg.form.utils;

import static reg.form.utils.RandomUtils.*;

public class Testdata {

    public static String[] birthdayDate = getRandomDate(14, 99);

    public static String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            userGender = getRandomGender(),
            userNumber = getRandomPhone(),
            birthDay = birthdayDate[0],
            birthdayMonth = birthdayDate[1],
            birthdayYear = birthdayDate[2],
            subject = getRandomSubject(),
            hobby = getRandomHobbies(),
            fileName = "qa-image.png",
            streetAddress = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state);
}
