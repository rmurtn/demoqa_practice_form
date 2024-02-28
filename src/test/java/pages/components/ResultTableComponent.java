package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    public void checkTableContent(String value) {
        $(".modal-body").shouldHave(text(value));

    }

    public void tableVisibility() {
        $(".modal-body").shouldNotBe(visible);
    }
}
