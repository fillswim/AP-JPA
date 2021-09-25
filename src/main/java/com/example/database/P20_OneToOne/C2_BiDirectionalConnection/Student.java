package com.example.database.P20_OneToOne.C2_BiDirectionalConnection;

import javax.persistence.*;


//@Entity
public class Student {

    @Id @GeneratedValue
    int id;
    String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId") // Переименование поля, которое используется для связи таблиц
    Address address = new Address();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
