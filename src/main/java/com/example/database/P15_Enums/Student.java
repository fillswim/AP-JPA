package com.example.database.P15_Enums;

import javax.persistence.*;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;
    @Enumerated(EnumType.STRING) // Значения в БД будут храниться не как числа, а как String
    Gender gender;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
        this.gender = Gender.FEMALE;
    }
}

enum Gender{
    MALE,
    FEMALE
}

