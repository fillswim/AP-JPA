package com.example.database.P19_Embedable;

import javax.persistence.*;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @Embedded
    StudentAddress studentAddress = new StudentAddress();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
        this.studentAddress.city = "Moscow";
        this.studentAddress.street = "Pushkin str.";
    }
}

@Embeddable
class StudentAddress {
    String city;
    String street;
}
