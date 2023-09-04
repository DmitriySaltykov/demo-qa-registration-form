package guru.qa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class JInitLetuTest {

    @ValueSource(strings = {"Главная" , "Shorts", "Подписки"})
    @ParameterizedTest(name = "Wikipedia home page should have \"{0}\" language.")
    void wikipediaHomePageShouldHaveLanguageTest(String testData) {

        open("https://www.youtube.com/");
        $(".style-scope ytd-guide-renderer").shouldHave(text(testData));

    }


    @CsvSource(value = {
            "QA GURU, Школа инженеров по автоматизации тестирования",
            "Academeg, Итак ....  Меня зовут Костик, и я имею свой субъективный взгляд на автомобили"
    })
    @ParameterizedTest(name = "Wikipedia page for \"{0}\" should have text \"{1}\" in its first paragraph.")
    void wikipediaShouldHaveTextInArticleTest(String testData, String expectedResult) {

        open("https://www.youtube.com/");
        $("#search-input #search").val(testData).pressEnter();
        $(".style-scope ytd-channel-renderer").click();
        $(".style-scope ytd-channel-tagline-renderer").click();
        $("#description-container").shouldHave(text(expectedResult));

    }
//
//    static Stream<Arguments> wikiJavaTest() {
//        return Stream.of(
//                Arguments.of("Java", List.of("Класс языка", "Появился в", "Автор", "Разработчик","Расширение файлов","Выпуск", "Испытал влияние", "Лицензия", "Сайт")),
//                Arguments.of("Ява", List.of("Площадь", "Наивысшая точка", "Население", "Плотность населения", "Омывающие акватории", "Страна"))
//        );
//    }
//
//    @MethodSource
//    @ParameterizedTest(name = "Wikipedia page for {0} should have {1} characteristics of the subject")
//    void wikiJavaTest(String java, List<String> characteristic) {
//        open("https://wikipedia.org/");
//        $("[name=search]").setValue(java).pressEnter();
//        $$(".infobox th[scope=row]").shouldHave(CollectionCondition.texts(characteristic));
//    }
}