package com.example.database.P40_NativeQuery;

import javax.persistence.*;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
