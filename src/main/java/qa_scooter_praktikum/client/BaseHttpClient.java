package qa_scooter_praktikum.client;

import io.restassured.response.Response;
import qa_scooter_praktikum.courier_and_order_pojo.Order;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BaseHttpClient {

    protected static Response doGetRequest (String uri) {
        return given()
                .header("Content-type", "application/json")
                .when()
                .get("/api/v1/orders");
    }

    protected static Response doGetRequest(String uri, Object Params) {
        return given()
                .header("Content-type", "application/json")
                .when()
                .queryParam("t", Params)
                .get(uri);
    }

    protected static Response doPostRequestWithFile (String uri, File json) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(json)
                .when()
                .post(uri);
    }

    protected static Response doPostRequestWithObject (String uri, Object object) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(object)
                .when()
                .post(uri);
    }

    protected static Response doDeleteRequest (String uri, Object object) {
        return given()
                .header("Content-type", "application/json")
                .when()
                .delete(String.format(uri, object));
    }
}