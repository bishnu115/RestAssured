import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateJsonUsingMap {

    @Test
    public void createUser() {

        // Create Map (JSON Body)
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Rekha");
        requestBody.put("job", "QA");

        // Send POST Request
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198")
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post()

                .then()
                .statusCode(201)
                .log().all();
    }
}