package qa_scooter_praktikum;

import java.io.File;
import java.util.Collections;

public class OrderScooterColourConst {
    public static File BLACK = new File("src/test/resources/orderBlack.json");
    public static File GREY = new File("src/test/resources/orderGrey.json");
    public static File GREY_AND_BLACK = new File("src/test/resources/orderGreyAndBlack.json");
    public static File NO_COLOR = new File("src/test/resources/orderNoColor.json");

    public static Order ORDER_BLACK = new Order(
            "Иван",
            "Филиппов",
            "г. Екатеринбург, ул. Чайковского",
            6,
            "+79049811113",
            5,
            "2023-03-03",
            "Прошу не опаздывать, цвет самоката очень важен!",
            Collections.singletonList(("BLACK")));
    public static Order ORDER_GREY = new Order(
            "Иван",
            "Филиппов",
            "г. Екатеринбург, ул. Чайковского",
            6,
            "+79049811113",
            5,
            "2023-03-03",
            "Прошу не опаздывать, цвет самоката очень важен!",
            Collections.singletonList(("GREY")));
    public static Order ORDER_GREY_BLACK = new Order(
            "Иван",
            "Филиппов",
            "г. Екатеринбург, ул. Чайковского",
            6,
            "+79049811113",
            5,
            "2023-03-03",
            "Прошу не опаздывать, цвет самоката очень важен!",
            Collections.singletonList(("GREY, BLACK")));
    public static Order ORDER_NO_COLOR = new Order(
            "Иван",
            "Филиппов",
            "г. Екатеринбург, ул. Чайковского",
            6,
            "+79049811113",
            5,
            "2023-03-03",
            "Прошу не опаздывать, цвет самоката очень важен!",
            Collections.singletonList(("")));
}