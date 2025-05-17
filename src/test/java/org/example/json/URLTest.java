package org.example.json;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class URLTest {
    private static final String GETURL = "https://fakestoreapi.com/{category}/{id}";

    @Test
    public void testURLS(){
        RestAssured.get(GETURL,"products",2)
                .then()
                .statusCode(200)
                .body("id",equalTo(2));

        RestAssured.get(GETURL,"products",3)
                .then()
                .statusCode(200)
                .body("id",equalTo(3));

        RestAssured.get(GETURL,"products",11)
                .then()
                .statusCode(200)
                .body("id",equalTo(11));


    }

    @Test
    public void bddTestURL(){

        RestAssured
                .given()
                .pathParams("category","products")
                .pathParams("id",2)
                .when()
                .get(GETURL)
                .then()
                .statusCode(200)
                .body("id",equalTo(2));

    }
}
