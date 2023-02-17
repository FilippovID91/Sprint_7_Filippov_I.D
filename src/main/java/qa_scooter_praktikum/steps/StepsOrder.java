package qa_scooter_praktikum.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import qa_scooter_praktikum.client.BaseHttpClient;
import qa_scooter_praktikum.courier_and_order_pojo.Order;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class StepsOrder extends BaseHttpClient {

    @Step("Получаем track-номер заказа из тела ответа.")
    public static int getOrderTrack(File json) {
        Response responseOrder = doPostRequestWithFile("/api/v1/orders", json);
        return responseOrder.jsonPath().get("track");
    }


    @Step("Тело ответа содержит не пустой track.")
    public static void orderTrackNotNull(File json) {
        Response responseOrder = doPostRequestWithFile("/api/v1/orders", json);
        responseOrder.then().body("track", notNullValue());
    }

    @Step("Получение информации о заказе по номеру заказа.")
    public static void orderInfo(int orderTrack) {
        Response responseOrderInfo = doGetRequest("/api/v1/orders/track", orderTrack);
        responseOrderInfo.then()
                .body("order", notNullValue())
                .and()
                .statusCode(200);
    }

    @Step("Создание заказа на самокат - возвращает трек-номер заказа")
    public static int getOrderTrackNumber(Order colour) {
        Response responseOrder = doPostRequestWithObject("/api/v1/orders", colour);
        return responseOrder.jsonPath().get("track");
    }

    @Step("Тело ответа содержит не пустой track.")
    public static void orderTrackNotNullNew(Order colour) {
        Response responseOrder = doPostRequestWithObject("/api/v1/orders", colour);
        responseOrder.then().body("track", notNullValue());
    }

    @Step("Получение информации о заказе по номеру заказа.")
    public static void checkOrderInfo(int track) {
        Response responseOrderInfo = doGetRequest("/api/v1/orders/track", track);
        responseOrderInfo.then()
                .body("order", notNullValue())
                .and()
                .statusCode(200);
    }

    @Step("Получение списка заказов без отправки параметров.")
    public static void orderListInfoNotNull() {
        Response responseOrderInfo = doGetRequest("/api/v1/orders");
        responseOrderInfo.then()
                .body("orders", notNullValue())
                .and()
                .statusCode(200);
    }
}