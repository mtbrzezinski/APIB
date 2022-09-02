package get;

import io.restassured.RestAssured;
import org.junit.Test;

public class Itunes {

    @Test
    public void iTunesTest1(){
        /*
        1. Define/Find a valid/correct URL to send on HTTP request to
        2. Define a proper HTTP method
        3. Define query string parameters(IF NEEDED)
        4. Define header parameters
        5.Send/execute a request
         */

        //https://itunes.apple.com/search
        RestAssured.baseURI = "https://itunes.apple.com/search";
        RestAssured
                .given().header("Accept", "application/json")//prerequisite
                .queryParam("term", "michael+jackson")
                .queryParam("limit", "1")
                .when().get()//action
                .then().statusCode(200);//validation

    }
    @Test
    public void petStore(){
        RestAssured.baseURI="https://petstore.swagger.io";
            RestAssured.basePath="v2/pet/10567";

            RestAssured.given()
                    .header("Accept","application/json")
                    .when()
                    .get()
                    .then()
                    .statusCode(404).log().all();
    }
}
