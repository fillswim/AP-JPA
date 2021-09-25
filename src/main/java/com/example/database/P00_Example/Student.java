package com.example.database.P00_Example;

import javax.persistence.*;

@Entity
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
