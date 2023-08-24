package reg.form.utils;


public class Testdata {
    RandomUtils RandomUtils = new RandomUtils();
  //  public  String[] birthdayDate = RandomUtils.getRandomDate(14, 99);
    public  String
            firstName = RandomUtils.getRandomFirstName(),
            lastName = RandomUtils.getRandomLastName(),
            userEmail = RandomUtils.getRandomEmail(),
            userGender = RandomUtils.getRandomGender(),
            userNumber = RandomUtils.getRandomPhone(),
            birthDay = RandomUtils.getRandomDay(),
            birthdayMonth = RandomUtils.getRandomMonth(),
            birthdayYear = RandomUtils.getRandomYear(),
            subject = RandomUtils.getRandomSubject(),
            hobby = RandomUtils.getRandomHobbies(),
            fileName = "qa-image.png",
            streetAddress = RandomUtils.getRandomAddress(),
            state = RandomUtils.getRandomState(),
            city = RandomUtils.getRandomCity(state);
}
