import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public  class updateUser {
    @Test
    public void updateUser() {

        String requestBody = "{\n" +
                "  \"name\": \"morpheus\",\n" +
                "  \"job\": \"zion resident\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198")
                .body(requestBody)
                .when()
                .put("https://reqres.in/api/users/168")
                .then()
                .statusCode(200)
                .log().all();
    }
}