package reg.form.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {



    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "800x800";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;

    }

}