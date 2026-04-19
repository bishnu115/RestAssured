import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Oauth2 {
    String client_id = "sdvdsv";
    String client_secret = "dfgdfhgfsv";
    String accessToken;

    @Test
    public void test() {
        Response res = given()
                .auth().preemptive().basic("client_id", "client_secret")
                .formParam("grant_type", "client_credentials")
                .when()
                .post("https://api.example.com/oauth/token");

         accessToken = res.jsonPath().getString("access_token");


    }

    @Test(dependsOnMethods = "test")
    public void test1() {
        given()
                .auth().oauth2(accessToken)
                .when()
                .get("https://api.example.com/users")
                .then()
                .statusCode(200);
    }
}



