package tests.homework_1;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class BNHSearch {
    String url = "https://www.bhphotovideo.com/";
    String item = "Sony Alpha a7S III";

    //Добавить в корзину первый товар в разделе обувь в 40 размере
    @Test
    void searchBookTests() {
        // Открыть сайт
        open(url);
        // Ввести в строку поиска название товара
        $(byXpath(".//input[@id='top-search-input']")).setValue(item).pressEnter();
        // Проверить есть ли в результатах поиска товар и перейти в первый товар
        $$(byXpath(".//div[@data-selenium='miniProductPage']"))
                .get(0)
                .$(byXpath(".//span[@data-selenium='miniProductPageProductName']"))
                .click();
        // Проверить сожержит ли выбранный товар название товара название из поиска
        $(byXpath(".//h1[@data-selenium='productTitle']")).shouldHave(Condition.text(item));
    }
}
