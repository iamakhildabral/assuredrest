package org.example.hamcrest;

import org.example.Student;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StudentTest {

    @Test
    public void testStudentObject(){
        Student student = new Student("Akhil","ECE",70);
        assertThat(student,equalTo(new Student("Akhil","ECE",70)));
    }

    @Test
    public void testStudentInstance(){
        Student student = new Student("Akhil","ECE",70);
        assertThat(student,instanceOf(Student.class));
    }

    @Test
    public void testStudentNull(){
        Student student = null;
        assertThat(student,nullValue());
    }

    @Test
    public void testStudentStringValue(){
        Student student = new Student("Akhil","ECE",70);
        assertThat(student,hasToString("Student(name=Akhil, major=ECE, gpa=70.0)"));
    }

    @Test
    public void testSameProperty(){
        Student student = new Student("Akhil","ECE",70);
        Student anotherStudent = new Student("Akhil","ECE",70);
        assertThat(student,samePropertyValuesAs(anotherStudent));
    }
}
