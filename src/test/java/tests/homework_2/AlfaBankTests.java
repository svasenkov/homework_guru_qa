package tests.homework_2;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {
    String depositPage = "https://alfabank.ru/make-money/savings-account/";

    @Test
    void countArchiveDepositsOnPage() {
        open(depositPage);
        $(byXpath(".//a[@title='Депозиты']")).shouldHave(text("Депозиты")).click();
        $(byXpath(".//body[@id='product_page_list']")).shouldHave(text("Архивные депозиты"));
        $(byText("Архивные депозиты")).shouldBe(Condition.visible).click();
        $$(byXpath(".//a[@class='product-cell__cell-back']")).shouldBe(CollectionCondition.size(3));
    }

    @Test
    void callDepositInsuranceV1() {
        open(depositPage);
        $(byXpath(".//ul[@class='navigation']/li"))
                .sibling(4)
                .shouldHave(text("Страхование вкладов"))
                .click();
    }

    @Test
    void callDepositInsuranceV2() {
        open(depositPage);
        $(byXpath(".//ul[@class='navigation']/li[7]"))
                .preceding(0)
                .shouldHave(text("Страхование вкладов"))
                .click();
    }


}
