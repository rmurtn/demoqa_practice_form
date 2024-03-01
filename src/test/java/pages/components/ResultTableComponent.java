package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    public SelenideElement tableWithData = $(".modal-body");
    public void checkTableContent(String value) {
        tableWithData.shouldHave(text(value));
    }

    public void tableVisibility() {
        tableWithData.shouldNotBe(visible);
    }
}
