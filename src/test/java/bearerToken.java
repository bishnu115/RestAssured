import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class bearerToken {
    @Test
    public void check() {
        given()
                .auth().oauth2("YOUR_TOKEN")
                .when()
                .get("https://api.example.com/users")
                .then()
                .statusCode(200);
    }

}
