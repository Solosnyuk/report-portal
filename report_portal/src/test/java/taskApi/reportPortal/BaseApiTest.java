package taskApi.reportPortal;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import java.util.logging.Logger;

public class BaseApiTest {
    public static final Logger logger = Logger.getLogger(BaseApiTest.class.getName());
    public static final String BASE_URL = "https://demo.reportportal.io/api/v1/";
    public static final String BASE_API = "/dashboard/";
    public static final String ACCESS_TOKEN = "fedor_jOID1LdjRX-TihsCsEu6Pom3dA_F9kJGPQ8VGLR_NuN_Rw6lJa8eymm_WNk2eEDO";
    public static final String PROJECT_NAME = "default_personal";

    public String getRandomName() {

        String RandomName = "Bob_" + System.currentTimeMillis();
        return  RandomName;
    }

    @BeforeClass
    public void setupRestAssured() {
        RestAssured.baseURI = BASE_URL + PROJECT_NAME + BASE_API;
    }

    public Response sendPostRequest(String body) {
        return RestAssured.given()
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType(ContentType.JSON)
                .body(body)
                .post()
                .then().log().body()
                .extract()
                .response();
    }

    public Response sendGetRequest(Integer id) {
        String fullUrl = BASE_URL + PROJECT_NAME + BASE_API + id;
        return RestAssured.given()
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType(ContentType.JSON)
                .get(fullUrl)
                .then().log().body()
                .extract()
                .response();
    }
}
