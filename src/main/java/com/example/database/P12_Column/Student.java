package com.example.database.P12_Column;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;

//    @Column(name = "MyName") // Переименование названия поля
//    @Column(length = 50) // Пределение длины поля
//    @Column(unique = true) // Уникальность значений
//    @Column(nullable = false) // Может не может быть null
    @Column(columnDefinition = "varchar(49) not null")
    String name;




    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
