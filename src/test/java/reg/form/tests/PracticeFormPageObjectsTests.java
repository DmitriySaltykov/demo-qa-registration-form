package reg.form.tests;

import reg.form.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class PracticeFormPageObjectsTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFillFormTest() {

        registrationPage.openPage()
                .closeAdBanners()
                .setFirstName("dim")
                .setLastName("vit")
                .setUserEmail("d@v.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setBirthDate("24", "November", "1993")
                .setSubject("English")
                .setSubject("Computer Science")
                .setHobby("Sports")
                .setHobby("Music")
                .selectPicture("qa-image.png")
                .setCurrentAddress("Changu, Bali")
                .setState("Uttar Pradesh")
                .setCity("Merrut")

                .clickOnSubmitButton();

        registrationPage.verifyRegistrationResultModalAppears()
                .verifyResult("Student Name", "dim  vit")
                .verifyResult("Student Email", "d@v.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "0123456789")
                .verifyResult("Date of Birth", "24 November,1993")
                .verifyResult("Subjects", "English, Computer Science")
                .verifyResult("Hobbies", "Sports, Music")
                .verifyResult("Picture", "qa-image.png")
                .verifyResult("Address", "Changu, Bali")
                .verifyResult("State and City", "Uttar Pradesh Merrut");

    }
}