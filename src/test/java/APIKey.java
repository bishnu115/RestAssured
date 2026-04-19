import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APIKey {
    @Test
    public void test() {


        given()
                .header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198")
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200);
    }
}