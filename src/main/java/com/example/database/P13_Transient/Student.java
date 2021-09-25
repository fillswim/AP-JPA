package com.example.database.P13_Transient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @Transient // Поле не будет храниться в базе данных
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
