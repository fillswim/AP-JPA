package com.example.database.P31_ContainceClearDetach;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
