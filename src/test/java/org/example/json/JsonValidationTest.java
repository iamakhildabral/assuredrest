package org.example.json;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JsonValidationTest {
    private static final String baseUrl = "https://fakestoreapi.com/users/{id}";

    @Test
    public void testJsonValue(){
        ResponseBody<?> responseBody = RestAssured
                .given()
                .pathParams("id","4")
                .when()
                .get(baseUrl);
        
        JsonPath jsonPath = responseBody.jsonPath();
        Map<String,?> jsonBody = jsonPath.get();
//        System.out.println(jsonBody);

        Map<String,?> addressBody = jsonPath.get("address");
        System.out.println(addressBody);
        System.out.println(jsonBody.get("address"));
        assertThat(addressBody,equalTo(jsonBody.get("address")));

    }
}
