package taskApi.reportPortal;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeDashboardTests extends BaseApiTest {

    private String longName = longName();
    private Integer getStatusCode;

    @Test
    public void negativeTest() {
        String requestBody = String.format("{\"description\": \"тест с name длиною 129 символов\", \"name\": \"%s\"}", longName);
        Response response = sendPostRequest(requestBody);

        getStatusCode = response.getStatusCode();
        logger.info("Код ответа на создание с невалидным значением name: " + getStatusCode);

        Assert.assertEquals(response.statusCode(), 400);
    }
}
