package reg.form;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }



    @Test
    void  regtest() {

        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("johndoe@example.com");

        $("[for='gender-radio-1']").click();

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $$(".react-datepicker__day--001").find(visible).click();


        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("qa-image.png");

        $("#currentAddress").setValue("123 Penza Street");
        $("#state input").setValue("NCR").pressEnter();
        $("#city input").setValue("Delhi").pressEnter();

        // Отправка формы
        $("#submit").click();

        // Проверка успешной отправки формы
        $("#example-modal-sizes-title-lg").shouldHave(visible.text("Thanks for submitting the form"));

    }
}
