import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindJUnit5Code {
    @Test
    void checkWikiForCode (){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions")).shouldBe(visible);
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text
            ("@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "@Test\n" +
            "void test() {\n" +
            "Configuration.assertionMode = SOFT;\n" +
            "open(\"page.html\");\n" +
            "$(\"#first\").should(visible).click();\n" +
            "$(\"#second\").should(visible).click();\n" +
            "}\n" +
            "}")
        ).shouldBe(visible);
    }
}
