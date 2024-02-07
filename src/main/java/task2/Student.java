package task2;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.*;

public class Student implements Serializable {
    private String name;
    private int age;
    //transient double GPA;
    @JsonIgnore
    transient double gpa;

    public Student() {
    }

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.gpa = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return gpa;
    }

}
