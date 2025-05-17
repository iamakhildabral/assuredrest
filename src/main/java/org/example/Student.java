package org.example;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Student
{
    private String name;
    private String major;
    private double gpa;

//    @Override
//    public boolean equals(Object o){
//        if (this == o){
//            return true;
//        }
//
//        if (o == null || getClass() != o.getClass()){
//            return false;
//        }
//        Student student = (Student) o;
//        return Double.compare(student.gpa,gpa) == 0 &&
//                Objects.equals(student.name,name) &&
//                Objects.equals(student.major,major);
//
//    }
//
//    @Override
//    public int hashCode(){
//        return Objects.hash(name,major,gpa);
//    }

}
