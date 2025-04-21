package taskApi.reportPortal;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {
    String accessToken = "newtest_ymp_qg_mQ06P70fwG6Wo172jaA4XbYYaaPDqDGv4QwkN_5dHL-xK3R2PWmGYJt9w";

    @Test
    public void successPostTest() {
        String baseUrl = "https://demo.reportportal.io/api/v1/";
        String baseApi = "/dashboard";
        String name = "postd";

        given()
                .baseUri(baseUrl + name + baseApi)
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body("{\"description\": \"string\", \"name\": \"postd\"}")
                .post()
                .then()
                .statusCode(201);

    }


  //  @Test
  //  public void successPostDashboardTest() {
  //      String BASE_URL = "https://demo.reportportal.io/";
  //      String projectName = "TestBoard";
  //      String desc = "Desc";
//
  //      BaseApiTest.instalSpec(BaseApiTest.requestSpec(BASE_URL), BaseApiTest.responsSpec201());
  //      PostDashboard description  = new PostDashboard(desc, projectName);
  //      SuccessPostDashboard successPost = given()
  //              .contentType(ContentType.JSON)
  //              .body(description)
  //              .when()
  //              .post("v1/" + projectName + "/dashboard")
  //              .then().log().all()
  //              .extract().as(SuccessPostDashboard.class);
  //      Assert.assertNotNull(successPost.getId());
  //  }
}
