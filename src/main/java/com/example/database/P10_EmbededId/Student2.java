package com.example.database.P10_EmbededId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

//@Entity
//@IdClass(MyId2.class)
public class Student2 {

    @Id
    String name;
    @Id
    String surname;

    int age;

    public Student2() {
    }

    public Student2(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
