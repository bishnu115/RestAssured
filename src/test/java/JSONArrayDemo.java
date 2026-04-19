import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class JSONArrayDemo {

    @Test
    public void createUsersUsingList() {

        // User 1
        Map<String, Object> user1 = new HashMap<>();
        user1.put("firstName", "Prachi");
        user1.put("lastName", "Gupta");
        user1.put("age", 28);
        user1.put("salary", 10000.56);

        // User 2
        Map<String, Object> user2 = new HashMap<>();
        user2.put("firstName", "Prerna");
        user2.put("lastName", "Gupta");
        user2.put("age", 28);
        user2.put("salary", 10000.56);

        // User 3
        Map<String, Object> user3 = new HashMap<>();
        user3.put("firstName", "Jatin");
        user3.put("lastName", "Gupta");
        user3.put("age", 28);
        user3.put("salary", 10000.56);

        // Create JSON Array using List
        List<Map<String, Object>> payload = new ArrayList<>();
        payload.add(user1);
        payload.add(user2);
        payload.add(user3);

        // Send Request
        Response response = RestAssured
                .given()
                .baseUri("https://reqres.in/api/users")
                .header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198")
                .contentType(ContentType.JSON)
                .body(payload)

                .when()
                .post();

        // Print Response
        response.prettyPrint();

        // Validation
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
