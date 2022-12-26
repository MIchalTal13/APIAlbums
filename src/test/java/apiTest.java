import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class apiTest {

    @Test
    void testOne(){
        given().when().get(a.ALBUMS).then().log().all();

    }

    @Test
    void testTwo(){
        given().contentType(ContentType.JSON).body("{\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"quidem molestiae enim\"\n" +
                        "    }")
                .post(a.ALBUMS).then().statusCode(201);
    }

    @Test
    void testThree(){
        given().when().delete(a.ALBUMS + "/4").then().statusCode(200);
    }

    @Test
    void testFour(){
        Response response = given().when().get(a.ALBUMS);
        int code = response.getStatusCode();
        Assert.assertEquals(code, 200);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(200);
        list.add(201);
        System.out.println(code);
    }
}
