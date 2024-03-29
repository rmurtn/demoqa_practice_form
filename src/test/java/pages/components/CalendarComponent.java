package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private final SelenideElement selectMonth = $(".react-datepicker__month-select");
    private final SelenideElement selectYear = $(".react-datepicker__year-select");
    private final ElementsCollection selectDay = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");

    public void setDate(String day, String month, String year) {
        selectMonth.selectOption(month);
        selectYear.selectOption(year);
        selectDay.find(Condition.text(day)).click();
    }
}
