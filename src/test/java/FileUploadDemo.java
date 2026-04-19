import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadDemo {

    @Test
    public void uploadFile() {

//        File file = new File("C:\\Users\\ompra\\OneDrive\\Desktop\\postman.xlsx");
//
//        Response res = RestAssured.given()
//                .multiPart("file", file)
//                .when()
//                .post("https://httpbin.org/post");
//
//        res.then().log().all();
    }
}