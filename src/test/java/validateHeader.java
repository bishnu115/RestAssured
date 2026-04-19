import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class validateHeader {

    @Test
    public void delete(){
        given()
                .header("x-api-key","reqres_c82e22442845490cb1bd73c51992a198")
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .header("Content-Type", containsString("application/json"));
    }
}
