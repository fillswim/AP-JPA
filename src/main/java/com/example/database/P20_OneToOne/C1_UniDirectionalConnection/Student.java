package com.example.database.P20_OneToOne.C1_UniDirectionalConnection;

import javax.persistence.*;

//@Entity
public class Student {

    @Id @GeneratedValue
    int id;
    String name;

    @OneToOne(cascade = CascadeType.PERSIST) // Каскадное взамосвязь по сохранению
    @JoinColumn(name = "addressId") // Колонка, по которой идет объединение
    Address address = new Address();

    public Student() {
    }

    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
