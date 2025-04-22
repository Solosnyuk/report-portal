package taskApi.reportPortal;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import java.util.logging.Logger;

public class BaseApiTest {
    public static final Logger logger = Logger.getLogger(BaseApiTest.class.getName());
    public static final String BASE_URL = "https://demo.reportportal.io/api/v1/";
    public static final String BASE_API = "/dashboard/";
    public static final String ACCESS_TOKEN = "skey_tx53r9UaSn6Wsebjr3bAuXf-algK-pvlT28xVI63Zq51-3UlZ3fI293c-S-gNl83";
    public static final String PROJECT_NAME = "default_personal";

    public String getRandomName() {

        String RandomName = "Bob_" + System.currentTimeMillis();
        return  RandomName;
    }

    public String longName() {
        String name = "";
        for(int i = 0; i < 129; i++) {
            name += (char)(Math.random() * 26 + 97);
        }
        return name;
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
