import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deserilazation {
    @Test
    public void validateUser() {

        Response res = given()
                .header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198")
                .when()
                .get("https://reqres.in/api/users/2");

        // Deserialize response to POJO
        deserilazation_pojo userResponse = res.as(deserilazation_pojo.class);

        // Print values

        System.out.println("First Name: " + userResponse.data.first_name);
        System.out.println("Last Name: " + userResponse.data.last_name);
        System.out.println("Email: " + userResponse.data.email);
        System.out.println("Email: " + userResponse.data.id);

    }
}