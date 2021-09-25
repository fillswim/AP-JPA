package com.example.database.P24_StrategiesInheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Worker extends Person {

    @Id
    @GeneratedValue
    int id;
    String job;

    public Worker() {
    }

    public Worker(String job) {
        this.job = job;
    }
}
