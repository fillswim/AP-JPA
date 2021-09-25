package com.example.database.P22_ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Address> addresses = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
