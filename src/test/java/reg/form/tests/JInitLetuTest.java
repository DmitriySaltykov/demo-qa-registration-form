package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class JInitLetuTest {

    @ValueSource(strings = {"Главная" , "Shorts", "Подписки"})
    @ParameterizedTest(name = "Youtube home page should have \"{0}\" categories.")
    void wikipediaHomePageShouldHaveLanguageTest(String testData) {

        open("https://www.youtube.com/");
        $(".style-scope ytd-guide-renderer").shouldHave(text(testData));

    }


    @CsvSource(value = {
            "QA GURU, Школа инженеров по автоматизации тестирования",
            "Academeg, Итак ....  Меня зовут Костик, и я имею свой субъективный взгляд на автомобили"
    })
    @ParameterizedTest(name = "Youtube chanel  \"{0}\" should have text \"{1}\" in descreption.")
    void wikipediaShouldHaveTextInArticleTest(String testData, String expectedResult) {

        open("https://www.youtube.com/");
        $("#search-input #search").val(testData).pressEnter();
        $(".style-scope ytd-channel-renderer").click();
        $(".style-scope ytd-channel-tagline-renderer").click();
        $("#description-container").shouldHave(text(expectedResult));

    }

    static Stream<Arguments> YTJavaTest() {
        return Stream.of(
                Arguments.of("QA GURU", List.of("Главная", "Видео", "Плейлисты", "Сообщество"))
              //  Arguments.of("Academeg", List.of("Главная", "Видео", "Плейлисты", "Сообщество"))
        );
    }
    @MethodSource
    @ParameterizedTest(name = "Youtube chanel  \\\"{0}\\\" should have link \\\"{1}\\\" on Links descreption.\"")
    void YTJavaTest(String java, List<String> characteristic) {
        open("https://www.youtube.com/");


        $("#search-input #search").val(java).pressEnter();
        $(".style-scope ytd-channel-renderer").click();

       $$("#style-scope ytd-c4-tabbed-header-renderer ").shouldHave(CollectionCondition.texts(characteristic));
    }





}