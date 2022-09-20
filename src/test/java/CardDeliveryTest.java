import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest {
    @Test
    void test() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Санкт-Петербург");
        $("[placeholder=\"Дата встречи\"]").setValue("22.09.2022");
        $("[data-test-id=\"name\"] input").setValue("Галина Гаврюхина");
        $("[data-test-id = \"phone\"] input").setValue("+79819990001");
        $x("//span[contains(text(), 'Я соглашаюсь с условиями обработки')]").click();
        $(".button__text").click();
        $x("//div[text()= 'Успешно!']").should(Condition.visible, Duration.ofSeconds(15));
    }

}
