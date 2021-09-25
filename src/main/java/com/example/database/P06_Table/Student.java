package com.example.database.P06_Table;

import javax.persistence.*;

//@Entity
@Table(name = "universityStudent") // переименование таблицы в базе данных
@SecondaryTable(name = "address") // определение другой таблицы для хранения адреса
@SecondaryTables({@SecondaryTable(name = "address"),
        @SecondaryTable(name = "country")}) // определение нескольких таблиц для сохранения
public class Student {

    @Id // Primary Key, может быть на нескольких полях
    @GeneratedValue
    int id;
    String name;
    int age;

    @Column(table = "address") // определение другой таблицы для хранения адреса
    String city;
    @Column(table = "address") // определение другой таблицы для хранения адреса
    String street;

    public Student() {
    }

    public Student(String name, int age, String city, String street) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.street = street;
    }
}
