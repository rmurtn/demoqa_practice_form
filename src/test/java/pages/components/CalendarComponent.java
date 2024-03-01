package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private SelenideElement selectMonth = $(".react-datepicker__month-select");
    private SelenideElement selectYear = $(".react-datepicker__year-select");
    private ElementsCollection selectDay = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");

    public void setDate(String day, String month, String year) {
        selectMonth.selectOptionByValue(month);
        selectYear.selectOptionByValue(year);
        selectDay.find(Condition.text(day)).click();
    }
}
