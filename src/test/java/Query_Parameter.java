import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Query_Parameter {
    @Test
    public void validateUsersPage2() {

        Response res = given()
                .header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198")
                .basePath("/api/users")
                .queryParam("page", 2)
              //  .queryParam("id", 10)
                .when()
                .get("https://reqres.in");

        System.out.println(res.getBody().asString());

    }
}


