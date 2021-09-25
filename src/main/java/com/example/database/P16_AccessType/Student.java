package com.example.database.P16_AccessType;

import javax.persistence.*;

//@Entity
@Access(AccessType.FIELD)    // Доступ к данным при сохранении будет осуществляться через поля
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

    @Access(AccessType.PROPERTY)    // Доступ к данным при сохранении будет осуществляться через геттеры и сеттеры
    public String getName() {
        return "Mr. " + name;       // В БД будет сохраняться измененное значений
    }

    public void setName(String name) {
        this.name = name;
    }
}
