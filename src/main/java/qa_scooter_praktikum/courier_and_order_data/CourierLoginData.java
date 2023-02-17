package qa_scooter_praktikum.courier_and_order_data;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierLoginData {
    public static String RANDOM_LOGIN = RandomStringUtils.randomAlphabetic(6);
    public static String RANDOM_PASS = RandomStringUtils.randomNumeric(4);
    public static String RANDOM_NAME = RandomStringUtils.randomAlphabetic(6);
}