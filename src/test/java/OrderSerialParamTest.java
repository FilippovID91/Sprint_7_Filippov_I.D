import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import qa_scooter_praktikum.courier_and_order_pojo.Order;

import static qa_scooter_praktikum.courier_and_order_data.OrderScooterColourConst.*;
import static qa_scooter_praktikum.steps.StepsOrder.*;

@RunWith(Parameterized.class)
public class OrderSerialParamTest {

    private final Order colour;

    public OrderSerialParamTest(Order colour) {
        this.colour = colour;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {ORDER_BLACK},
                {ORDER_GREY},
                {ORDER_GREY_BLACK},
                {ORDER_NO_COLOR},
        };
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тело ответа содержит track не пустой")
    @Description("Проверяем цвета - черный - серый - черный/серый - без указания цвета")
    public void checkNotNull() {
        orderTrackNotNullNew(colour);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Можно указать в заказе любой цвет самоката")
    @Description("Проверяем цвета - черный - серый - черный/серый - без указания цвета")
    public void checkAnyColour() {
        checkOrderInfo(getOrderTrackNumber(colour));
    }
}