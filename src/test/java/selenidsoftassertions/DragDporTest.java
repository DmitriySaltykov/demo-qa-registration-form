package selenidsoftassertions;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragDporTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void changePositions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("div#column-a").dragAndDropTo($("div#column-b"));
        $("div#column-a").shouldHave(text("B"));
        $("div#column-b").shouldHave(text("A"));
    }
}
