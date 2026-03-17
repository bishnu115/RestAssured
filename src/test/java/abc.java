import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import javax.xml.transform.Source;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class abc {
    @Test
    public void validateUsersPage2() {
        JsonPath js = new JsonPath(payload.course());

        int cou = js.getInt("courses.size()");
        System.out.println(cou);
        //print amount directly
        int pa = js.getInt("dashboard.purchaseAmount");
        System.out.println(pa);
        //print title of course which present in array
        String coursetitle = js.get("courses[0].title");
        System.out.println(coursetitle);
        //print all course title and price
        for (int i = 0; i < cou; i++) {
            String alltitle = js.get("courses[" + i + "].title");
            int price = js.get("courses[" + i + "].price");
            System.out.println(alltitle);
            System.out.println(price);
        }
//print sold copy
        for (int i = 0; i < cou; i++) {
            String coursetitles= js.get("courses[" + i + "].title");
            if (coursetitles.equalsIgnoreCase("rpa")) {
                int price = js.get("courses[" + i + "].copies");
                System.out.println("rpa sold copues:  " +price);
                System.out.println("test");
                break;
            }
        }

    }
}

