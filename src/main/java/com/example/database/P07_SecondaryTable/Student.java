package com.example.database.P07_SecondaryTable;

import javax.persistence.*;

//@Entity
@SecondaryTables({
        @SecondaryTable(name = "Country"),
        @SecondaryTable(name = "address")}) // Определение дополнительных таблиц для сохранения
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @Column(table = "Country") // Определение таблицы для сохранения
    String country;
    @Column(table = "address")
    String city;
    @Column(table = "address")
    String street;

    public Student() {
    }

    public Student(String name, String country, String city, String street) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }
}
