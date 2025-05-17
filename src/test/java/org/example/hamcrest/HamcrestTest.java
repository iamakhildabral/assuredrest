package org.example.hamcrest;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestTest {
    String testString = "My name is Akhil Test USer";

    @Test
    public void testCloseTo(){
        assertThat(9.5,closeTo(10,0.5));
    }

    @Test
    public void testignoreCase(){
        assertThat("akhildabral",startsWithIgnoringCase("AKHILD"));
    }

    @Test
    public void testStringContains(){
        assertThat(testString,containsString("USer"));
    }

    @Test
    public void testStringStartsWith(){
        assertThat(testString,startsWithIgnoringCase("my"));
        assertThat(testString,endsWithIgnoringCase("user"));

    }
    @Test
    public void matchEmailID(){
        String email = "akhilusertest@gmail.com";
        assertThat(email,matchesPattern("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));
    }
}


