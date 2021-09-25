package com.example.database.P28_DeleteOrphan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @OneToOne(orphanRemoval = true) // Удаление остаточных значений в БД
    Address address = new Address();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
