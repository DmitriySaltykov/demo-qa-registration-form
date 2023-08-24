package selenidsoftassertions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SolutionsEnterprizeTest {

        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.pageLoadStrategy = "eager";
        }

        @Test
        void callHoverOnSolution() {
            // Открытие страницы гита
            open("https://github.com/");

            // Расскрытие ховера
            $(".header-menu-wrapper").$(byText("Solutions")).hover();

            // Клик
            $(".header-menu-wrapper").$(byText("Enterprise")).click();

            // Проверка заголовка
            $(".application-main h1").shouldHave(text("Build like the best"));
        }

        @AfterAll
        static void afterAll() {
            Selenide.closeWebDriver();
        }
}
