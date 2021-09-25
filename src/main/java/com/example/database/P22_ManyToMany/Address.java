package com.example.database.P22_ManyToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Address {

    @Id
    @GeneratedValue
    int id;

    String city;
    String street;

    @ManyToMany(mappedBy = "addresses") // Хозяином связи становится поле "addresses" из Student
    List<Student> students = new ArrayList<>();

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
