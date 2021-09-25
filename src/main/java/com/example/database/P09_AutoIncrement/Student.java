package com.example.database.P09_AutoIncrement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Student {

    @Id
    int id;
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
