package taskApi.reportPortal;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeDashboardTests extends BaseApiTest {

    private Integer getStatusCode;

    @Test
    public void negativePostTest() {
        String requestBody = String.format("{\"description\": \"negtest\", \"name\": \"%s\"}", "");
        Response response = sendPostRequest(requestBody);

        getStatusCode = response.getStatusCode();
        logger.info("Код ответа на создание с пропущеным name: " + getStatusCode);

        Assert.assertEquals(response.statusCode(), 400);
    }
}
