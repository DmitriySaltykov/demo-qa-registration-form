package reg.form.tests;


import org.junit.jupiter.api.Test;
import reg.form.pages.RegistrationPage;

import static reg.form.utils.Testdata.*;


public class PracticeFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulFillFormTestFull() {



        registrationPage.openPage()

                .closeAdBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthdayMonth, birthdayYear)
                .setSubject(subject)
                .setHobby(hobby)
                .selectPicture(fileName)
                .setCurrentAddress(streetAddress)
                .setState(state)
                .setCity(city)
                .clickOnSubmitButton();

        registrationPage.verifyRegistrationResultModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", birthDay + " " + birthdayMonth + "," + birthdayYear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", fileName)
                .verifyResult("Address", streetAddress)
                .verifyResult("State and City", state + " " + city);

    }
}