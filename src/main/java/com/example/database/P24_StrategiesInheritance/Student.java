package com.example.database.P24_StrategiesInheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Student extends Person {

    @Id
    @GeneratedValue
    int id;
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
