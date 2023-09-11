package reg.form.tests;


import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import reg.form.pages.RegistrationPage;
import reg.form.utils.Testdata;

import static com.codeborne.selenide.logevents.SelenideLogger.step;


@Tag("remote")
public class PracticeFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Testdata testData = new Testdata();

    @Test()

    @DisplayName("Проверка заполнения регистрационной формы")
    @Description("Проверка заполнения регистрационной формы")



        void successfulFillFormTest() {
            step("Открываем регистрационную форму", () -> {
                registrationPage.openPage()
                        .closeAdBanners();
            });
            step("Заполняем регистрационную форму", () -> {
                registrationPage
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
            });

        step("Проверяем результат", () -> {
                    registrationPage
                            .verifyRegistrationResultModalAppears()
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
                });


    }
}