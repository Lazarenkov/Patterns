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


public class CardDeliveryNameTest {


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
    void shouldCreateOrderWhenAllValidDoubleFirstName() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getFirstNameDoubled() + " " + RegistrationInfo().getLastName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(12));
        $(".notification__title")
                .shouldHave(text("Успешно!"), Duration.ofSeconds(12))
                .shouldBe(visible);
        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на " + setDateForTest(11)), Duration.ofSeconds(12))
                .shouldBe(visible);
    }

    @Test
    void shouldCreateOrderWhenAllValidDoubleLastname() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getFirstName() + " " + RegistrationInfo().getLastNameDoubled());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(12));
        $(".notification__title")
                .shouldHave(text("Успешно!"), Duration.ofSeconds(12))
                .shouldBe(visible);
        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на " + setDateForTest(11)), Duration.ofSeconds(12))
                .shouldBe(visible);
    }

    @Test
    void shouldCreateOrderWhenAllValidDoubleNameAndSurname() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getFirstNameDoubled() + " " + RegistrationInfo().getLastNameDoubled());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(12));
        $(".notification__title")
                .shouldHave(text("Успешно!"), Duration.ofSeconds(12))
                .shouldBe(visible);
        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на " + setDateForTest(11)), Duration.ofSeconds(12))
                .shouldBe(visible);
    }

    @Test
    void shouldCreateOrderWhenValidNameWithYO() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getNameWithYO());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(12));
        $(".notification__title")
                .shouldHave(text("Успешно!"), Duration.ofSeconds(12))
                .shouldBe(visible);
        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на " + setDateForTest(11)), Duration.ofSeconds(12))
                .shouldBe(visible);
    }

    @Test
    void shouldPrintSubWhenInvalidEnglishName() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getEnglishName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Имя и Фамилия указаные неверно"));
    }

    @Test
    void shouldPrintSubWhenInvalidNameWithChars() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getFirstName() + RegistrationInfo().getRandomSymbol() + " " + RegistrationInfo().getLastName() + RegistrationInfo().getRandomSymbol());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Имя и Фамилия указаные неверно"));
    }

    @Test
    void shouldPrintSubWhenInvalidNameOfOneWord() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getFirstName());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Укажите точно как в паспорте"));
    }

    @Test
    void shouldPrintSubWhenInvalidNameOfOneLetter() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(RegistrationInfo().getRandomLetter());
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Укажите точно как в паспорте"));
    }

    @Test
    void shouldPrintSubWhenInvalidEmptyName() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));

        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void shouldPrintSubWhenInvalidSpaceName() {
        $("[data-test-id='city'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='city'] [class='input__control']").setValue(RegistrationInfo().getCity());
        $("[data-test-id='date'] [class='input__control']").setValue(deleteString);
        $("[data-test-id='date'] [class='input__control']").setValue(setDateForTest(11));
        $("[data-test-id='name'] [name='name']").setValue(" ");
        $("[data-test-id='phone'] [name='phone']").setValue(RegistrationInfo().getPhone());
        $("[class=checkbox__text]").click();
        $(By.className("button__text")).click();

        $("[data-test-id='name'] [class='input__sub']").shouldHave(text("Поле обязательно для заполнения"));
    }
}
