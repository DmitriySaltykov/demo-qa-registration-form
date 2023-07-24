package reg.form;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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
    void  regTest() {

        open("/automation-practice-form");

        // скрытие рекламы
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // заполнение личных данных
        $("#firstName").setValue("Dim");
        $("#lastName").setValue("Vit");
        $("#userEmail").setValue("d@v.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        // выбор даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $$(".react-datepicker__day--001").find(visible).click();

         // выбор профессии
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        // выбор хобби
        $("#hobbiesWrapper").$(byText("Music")).click();
        // добавления изображения
        $("#uploadPicture").uploadFromClasspath("qa-image.png");
        // выбор адреса  и штата
        $("#currentAddress").setValue("123 Penza Street");
        $("#state input").setValue("NCR").pressEnter();
        $("#city input").setValue("Delhi").pressEnter();

        // Отправка формы
        $("#submit").click();

        // Проверка успешной отправки формы
       $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Dim Vit"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("d@v.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("1 August,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("qa-image.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("123 Penza Street"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));

    }
}
