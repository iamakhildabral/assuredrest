package org.example.hamcrest;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class CollectionMatchTest {
    @Test
    public void testArrayList() {
//        ArrayList<String> names = new ArrayList<>();
        List<String> names = Arrays.asList("Akhil","test","user");
        assertThat(names,hasItem("Akhil"));
        assertThat(names,hasItems("Akhil","user"));
        assertThat(names,containsInAnyOrder("Akhil","user","test"));
    }
}
