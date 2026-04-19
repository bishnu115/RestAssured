import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Query_Request_Specification {

    @Test
    public void getUsersWithQueryParam() {

        // Create Request Specification
        RequestSpecification request = RestAssured.given();

        // Set Base URI & Path
        request.baseUri("https://reqres.in");
        request.basePath("/api/users");

        // Add Headers
        request.header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198");

        // Add Query Parameters
        request.queryParam("page", 2);

        // Send GET Request
        Response response = request.get();

        // Print Response Body
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());

        // Print Status Code
        System.out.println("Status Code: " + response.getStatusCode());
    }
}