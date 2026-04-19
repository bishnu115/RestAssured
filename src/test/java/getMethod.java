import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.transform.Source;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class getMethod {
    @Test
    public void validateUsersPage2() {
        given()
                .header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198")   // 🔑 add this
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then().log().all();

    }
}

