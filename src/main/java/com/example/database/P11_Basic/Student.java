package com.example.database.P11_Basic;

import javax.persistence.*;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
//    @Basic(fetch = FetchType.EAGER) // Данное поле всегда будет загружаться сразу
    @Basic(fetch = FetchType.LAZY) // Поле может не загружаться сразу
    String name;

    @Basic(optional = false) // Поле не может быть null в базе данных
    String surname;


    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
