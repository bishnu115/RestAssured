import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class JSONObjectUsingJacksonAPI {

    @Test
    public void createUser() throws Exception {

        // Create ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Create main JSON object
        ObjectNode userDetails = objectMapper.createObjectNode();

        userDetails.put("firstName", "Prerna");
        userDetails.put("lastName", "Gupta");
        userDetails.put("age", 28);
        userDetails.put("salary", 10000.56);
        userDetails.put("isMarried", false);

        // Add Array
        userDetails.set("hobbies",
                objectMapper.convertValue(Arrays.asList("Cooking", "Music"), JsonNode.class));

        // Nested JSON
        ObjectNode techSkill = objectMapper.createObjectNode();
        techSkill.put("programmingLanguage", "Java");
        techSkill.put("webAutomation", "Selenium");
        techSkill.put("apiTesting", "Rest Assured");

        userDetails.set("techSkill", techSkill);

        // Print JSON
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(userDetails);

        System.out.println("Created JSON:\n" + jsonString);

        // Retrieve values
        System.out.println("First Name: " + userDetails.get("firstName").asText());
        System.out.println("Is Married: " + userDetails.get("isMarried").asBoolean());
        System.out.println("Web Automation: " +
                userDetails.get("techSkill").get("webAutomation").asText());

        // Update value
        userDetails.put("lastName", "Sharma");

        // Remove field
        userDetails.remove("age");

        // Send API request
        Response response = RestAssured
                .given()
                .baseUri("https://reqres.in/api/users")
                .header("x-api-key", "reqres_c82e22442845490cb1bd73c51992a198")
                .contentType(ContentType.JSON)
                .body(userDetails)

                .when()
                .post();

        // Print response
        response.prettyPrint();

        // Validate
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}