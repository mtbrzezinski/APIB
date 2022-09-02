package post;

import io.restassured.RestAssured;
import org.junit.Test;

public class CreatePet {
    @Test
    public void createPetTest(){
        //https://petstore.swagger.io/v2/pet

        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";
        RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                        "    \"id\": 130690,\n" +
                        "    \"category\": {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"string\"\n" +
                        "    },\n" +
                        "    \"name\": \"kacper\",\n" +
                        "    \"photoUrls\": [\n" +
                        "        \"string\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "        {\n" +
                        "            \"id\": 0,\n" +
                        "            \"name\": \"string\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"status\": \"running from java code\"\n" +
                        "}").when().post().then().statusCode(200).extract().response();

    }
}
