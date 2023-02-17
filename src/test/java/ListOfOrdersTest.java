import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static qa_scooter_praktikum.steps.StepsOrder.*;


public class ListOfOrdersTest extends SetUpLogin {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("В тело ответа возвращается список заказов")
    @Description("Список всех заказов системы как файл json")
    public void createCourierAndOrderAndGetList() {
        orderListInfoNotNull();
    }
}