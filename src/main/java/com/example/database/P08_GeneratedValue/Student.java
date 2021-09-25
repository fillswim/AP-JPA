package com.example.database.P08_GeneratedValue;

import javax.persistence.*;

//@Entity
public class Student {

    @Id
    // Задание генератора для Id
//    @TableGenerator(name = "myGen", table = "mySequence",
//            initialValue = 100, allocationSize = 10,
//            pkColumnName = "name", pkColumnValue = "value")
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "myGen")

    // Режим генерации выбирается под базу данных автоматически
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
