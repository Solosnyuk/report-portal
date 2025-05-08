package taskApi.reportPortal;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PositiveDashboardTests extends BaseApiTest {

    private String dashboardName = getRandomName();
    private Integer createdDashboardId;
    private Integer getStatusCode;

    @Test
    public void successPostTest() {
        String requestBody = String.format(
                "{\"description\": \"Positive test description\", \"name\": \"%s\"}", dashboardName);
        Response response = sendPostRequest(requestBody);
        createdDashboardId = response.jsonPath().getInt("id");

        logger.info("Сгенерированое имя: " + dashboardName);
        logger.info("Присвоенный ID: " + createdDashboardId);
        getStatusCode = response.getStatusCode();
        logger.info("Код ответа на создание с валидными значениями: " + getStatusCode);
    }

    @Test(dependsOnMethods = "successPostTest")
    @Ignore("Not for reporting")
    public void verifyDashboardTest() {

        Response response = sendGetRequest(createdDashboardId);

        String actualName = response.jsonPath().getString("name");

        Assert.assertEquals(actualName, dashboardName, "Имя Dashboard не совпадает.");
    }
}
