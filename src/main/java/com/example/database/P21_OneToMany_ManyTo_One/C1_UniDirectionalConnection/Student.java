package com.example.database.P21_OneToMany_ManyTo_One.C1_UniDirectionalConnection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@Entity
public class Student {

    @Id @GeneratedValue
    int id;
    String name;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "StudAddr") // Определение названия таблицы для связи двух таблиц
    @JoinColumn(name = "addressId") // Таблицы связываются без промежуточной таблицы через поле в таблице Address
    List<Address> addresses = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
