package selenidsoftassertions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class JUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void jUnitTest() {
        // открытие страницы в гитхабе
        open("selenide/selenide");

        //переход в раздел вики
        $("#wiki-tab").click();

        //check whether it has page soft assertions
        $("#wiki-pages-box button").click();
        $("#wiki-pages-box").shouldHave(Condition.text("SoftAssertions"));


        // Переход на страницу
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        //Проверка наличи JUnit5
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class:\n" +
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}

