package org.example.json;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

@Test(enabled = false)
public class DirectJsonValues {

    @Test(enabled = false)
    void verifyDirectValues(){
        RestAssured.given()
                .get("https://fakestoreapi.com/users/5")
                .then()
                .body("address.geolocation.lat",equalTo("40.3467"))
                .body("address.geolocation.long",equalTo("-40.1310"));
    }
}
