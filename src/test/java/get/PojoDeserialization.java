package get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.CatFactPojo;
import pojo.PokemonPojo;

public class PojoDeserialization {

    @Test
    public void  pokemonTest(){
       Response response = RestAssured.given()
                        .accept("application/json")
                        .when().get("https://pokeapi.co/api/v2/pokemon")
                .then().statusCode(200).extract().response();
    
       PokemonPojo parsedResp = response.as(PokemonPojo.class);

       Assert.assertEquals(1154, parsedResp.getCount());



    }
    @Test
    public void catFactsTest(){
        Response response = RestAssured.given()
                .accept("application/json")
                .when().get("https://catfact.ninja/facts")
                .then().statusCode(200).extract().response();

        CatFactPojo parsedCatResp = response.as(CatFactPojo.class);

        int perPage = parsedCatResp.getPer_page();

        int totalFactsPerPage = parsedCatResp.getData().size();

        Assert.assertEquals(perPage, totalFactsPerPage);

    }

}
