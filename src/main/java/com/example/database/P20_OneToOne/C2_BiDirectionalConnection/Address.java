package com.example.database.P20_OneToOne.C2_BiDirectionalConnection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//@Entity
public class Address {

    @Id
    @GeneratedValue
    int id;

    String city;
    String street;

    // Определение хозяина связи. Хозяином становится Student и его поле address
    // Только Student будет знать об адресе, а адрес о студенте знать не будет
    @OneToOne(mappedBy = "address")
    Student student;

    public Address() {
    }

    public Address(String city, String street, Student student) {
        this.city = city;
        this.street = street;
        this.student = student;
    }
}
