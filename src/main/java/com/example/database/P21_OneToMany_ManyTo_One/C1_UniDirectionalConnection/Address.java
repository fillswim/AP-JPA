package com.example.database.P21_OneToMany_ManyTo_One.C1_UniDirectionalConnection;

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

    public Address() {
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}
