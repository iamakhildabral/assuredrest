package org.example.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class JsonTest {
    private static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";

    @Test
    public void verifyJsonHeader(){
        ObjectMapper objectMapper= new ObjectMapper();
        RestAssured.get(POST_URL)
                .then()
                .header("Report-To",(s)->{
                    try {
                        return objectMapper.readTree(s).get("max_age").asInt();
                    }catch (JsonProcessingException e){
                        throw new RuntimeException(e);
                    }
                },equalTo(3600));
    }
}
