import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class baseTest {


    protected void createUser(){


        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(userObject())
                .post("https://reqres.in/api/users");

        response.prettyPrint();
        response
                .then()
                .statusCode(201);

        int responseCode = response.getStatusCode();

        Assertions.assertEquals(201,responseCode);
        System.out.println("Successful operation- " + responseCode);


    }

    protected void getSingleUser(){


        Response response = given()

                .when()
                .get("https://reqres.in/api/users/2");
        response
                .then()
                .statusCode(200);

        response.prettyPrint();

        int responseCode = response.getStatusCode();

        Assertions.assertEquals(200,responseCode);
        System.out.println("Successful operation- " + responseCode);


    }

    protected String userObject(){

        JSONObject body = new JSONObject();

        body.put("name","melih");
        body.put("job","QA Engineer");

        return body.toString();

    }


}
