import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class postMethod {
@Test
    public void createUser() {

        String requestBody = "{\n" +
                "  \"name\": \"morpheus\",\n" +
                "  \"job\": \"leader\"\n" +
                "}";

    given()
            .header("Content-Type", "application/json")
            .header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198")
            .body(requestBody)
            .when()
            .post("https://reqres.in/api/users/")
            .then()
            .log().all()
            .statusCode(201);
    }
}