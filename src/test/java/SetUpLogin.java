import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;

import static qa_scooter_praktikum.courier_and_order_data.CourierLoginData.*;

public class SetUpLogin {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
        RANDOM_LOGIN = RandomStringUtils.randomAlphabetic(6);
        RANDOM_PASS = RandomStringUtils.randomNumeric(4);
        RANDOM_NAME = RandomStringUtils.randomAlphabetic(6);
    }
}