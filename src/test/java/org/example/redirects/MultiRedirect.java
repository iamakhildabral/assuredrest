package org.example.redirects;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class MultiRedirect {
    @DataProvider(name = "paramsValues", parallel = true)
    public Object[][] paramsValues() {
        return new Object[][]{
                {2},
                {3},
                {5},
                {8},
        };
    }

    @Test(dataProvider = "paramsValues")
    public void testRedirects(int value) {
        String BASEURL = "http://httpbin.org/redirect/{value}";

        given()
                .pathParam("value", value)
                .when()
                .get(BASEURL)
                .then()
                .statusCode(200);


    }

    @Test
    void verifyWarning() {
        RestAssured
                .given()
                .when()
                .get("https://api.spacexdata.com/v3/capsules/C112")
                .then()
                .statusCode(200);
    }
}
