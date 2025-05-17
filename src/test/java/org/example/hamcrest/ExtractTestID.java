package org.example.hamcrest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractTestID {

    @Test
    public void extractID() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        java.lang.Object id = given()
                .when()
                .get("/todos/9")
                .then()
                .statusCode(200)
                .extract().path("title");
        System.out.println(id);
    }
}
