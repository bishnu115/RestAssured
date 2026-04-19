import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class delete {

    @Test
    public void delete(){
        given()
                .header("x-api-key","reqres_c82e22442845490cb1bd73c51992a198")
                .when()
                .delete("https://reqres.in/api/users/168")
                .then()
                .log().all().statusCode(204);
    }



}
