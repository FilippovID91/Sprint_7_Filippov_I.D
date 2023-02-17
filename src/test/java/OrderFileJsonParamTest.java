import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;

import static qa_scooter_praktikum.courier_and_order_data.OrderScooterColourConst.*;
import static qa_scooter_praktikum.steps.StepsOrder.*;

@RunWith(Parameterized.class)
public class OrderFileJsonParamTest {
    private final File colour;

    public OrderFileJsonParamTest(File colour) {
        this.colour = colour;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {BLACK},
                {GREY},
                {GREY_AND_BLACK},
                {NO_COLOR},
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
    public void checkOrderTrackNotNull() {
        orderTrackNotNull(colour);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Можно указать в заказе любой цвет самоката")
    @Description("Проверяем цвета - черный - серый - черный/серый - без указания цвета")
    public void checkOrderCreationAnyColours() {
        orderInfo(getOrderTrack(colour));
    }
}