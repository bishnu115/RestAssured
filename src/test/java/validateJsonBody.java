import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class validateJsonBody {

    @Test
    public void json(){
        given()
                .header("x-api-key","reqres_c82e22442845490cb1bd73c51992a198")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data[0].first_name", equalTo("Michael"))
                .body("data[0].last_name", containsString("Lawson"));
    }

}
