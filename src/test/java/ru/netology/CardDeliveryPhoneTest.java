package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;


public class CardDeliveryPhoneTest {


    private String setDateForTest(int todayPlusInt) {
        return LocalDate.now().plusDays(todayPlusInt).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static final String deleteString = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

    RegistrationInfo RegistrationInfo() {
        return DataGenerator.generate("ru");
    }

    @BeforeEach
    void startBrowser() {
        Configuration.headless = true;
        open("http://localhost:9999/");
    }

    @Test
    void shouldPrintSubWhenEmptyPhone() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getName());

        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='phone'] [class='input__sub']").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void shouldPrintSubWhenPhoneWithoutPlus() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhoneNoPlus());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='phone'] [class='input__sub']").shouldHave(text("Телефон указан неверно"));
    }

    @Test
    void shouldPrintSubWhenPhoneWithOneDigitAndPlus() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhoneWithPlus1());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='phone'] [class='input__sub']").shouldHave(text("Телефон указан неверно"));
    }

    @Test
    void shouldPrintSubWhenPhoneWithOneDigitAndNoPlus() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getRandomDigit());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();


        $("[data-test-id='phone'] [class='input__sub']").shouldHave(text("Телефон указан неверно"));
    }

    @Test
    void shouldPrintSubWhenPhoneWithTenDigitsAndPlus() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhoneWithPlus10());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='phone'] [class='input__sub']").shouldHave(text("Телефон указан неверно"));
    }

    @Test
    void shouldPrintSubWhenPhoneWithTenDigitsAndNoPlus() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhoneNoPlus10());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='phone'] [class='input__sub']").shouldHave(text("Телефон указан неверно"));
    }

    @Test
    void shouldPrintSubWhenPhoneWithTwelveDigitsAndPlus() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhoneWithPlus12());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='phone'] [class='input__sub']").shouldHave(text("Телефон указан неверно"));
    }

    @Test
    void shouldPrintSubWhenPhoneWithTwelveDigitsAndNoPlus() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhoneNoPlus12());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='phone'] [class='input__sub']").shouldHave(text("Телефон указан неверно"));
    }
}
