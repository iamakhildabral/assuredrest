package org.example.json;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Test
public class VerifyJsonObject {

    @Test
    void verifyAddressExist() throws IOException, JSONException {


        String expectedJson = new String(Files.readAllBytes(Paths.get("D:\\codebase\\java\\RestAssured\\src\\test\\java\\org\\example\\resouce\\json1.json")));
        String actualJson = given()
                .when()
                .get("https://fakestoreapi.com/users/5")
                .then()
                .extract().asString();
        JSONAssert.assertEquals(expectedJson,actualJson,true);

    }
}
