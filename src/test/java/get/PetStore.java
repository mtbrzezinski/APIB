package get;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

public class PetStore {
    @Test
    public void getPetTest(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet/130690";

        RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200)
              // .body(".name", Matchers.is("kacper"));
               .body("category.id", Matchers.equalTo(0));
    }
}
