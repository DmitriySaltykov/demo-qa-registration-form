package reg.form.tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import reg.form.pages.RegistrationPage;
import reg.form.utils.Testdata;


@Tag("simple")
public class PracticeFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Testdata testData = new Testdata();

    @Test
    @DisplayName("Заполнение формы регистрации рандомными значениями ")
    void successfulFillFormTestFull() {



        registrationPage.openPage()

                .closeAdBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setBirthDate(testData.birthDay, testData.birthdayMonth, testData.birthdayYear)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .selectPicture(testData.fileName)
                .setCurrentAddress(testData.streetAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .clickOnSubmitButton();

        registrationPage.verifyRegistrationResultModalAppears()
                .verifyResult("Student Name", testData.firstName + " " + testData.lastName)
                .verifyResult("Student Email", testData.userEmail)
                .verifyResult("Gender", testData.userGender)
                .verifyResult("Mobile", testData.userNumber)
                .verifyResult("Date of Birth", testData.birthDay + " " + testData.birthdayMonth + "," + testData.birthdayYear)
                .verifyResult("Subjects", testData.subject)
                .verifyResult("Hobbies", testData.hobby)
                .verifyResult("Picture", testData.fileName)
                .verifyResult("Address", testData.streetAddress)
                .verifyResult("State and City", testData.state + " " + testData.city);

    }
}