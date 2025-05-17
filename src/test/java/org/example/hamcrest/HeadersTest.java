package org.example.hamcrest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class HeadersTest {
    private static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";

    @Test
    public void validateHeaders(){
        RestAssured.get(POST_URL)
//                .peek()
                .then()
                .statusCode(200)
//                .statusCode(allOf(greaterThanOrEqualTo(200),lessThanOrEqualTo(300)))
                .time(lessThan(2L), TimeUnit.SECONDS)
                .header("Expires",equalTo("-1"));

    }

    @Test
    public void testHeaderTypeIgnore(){
        RestAssured.get(POST_URL)
                .then()
                .header("Expires", Integer::parseInt,equalTo(-1));
    }
}
