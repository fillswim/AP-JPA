package com.example.database.P10_EmbededId;

import javax.persistence.*;

//@Entity
public class Student1 {

    @EmbeddedId
    MyId1 id;

    int age;

    public Student1() {
    }

    public Student1(String name, String surname, int age) {
        this.id = new MyId1(name, surname);
        this.age = age;
    }
}
