package com.example.database.P23_OrderBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Book {

    @Id
    @GeneratedValue
    int id;

    String author;
    String title;
    int number;

    public Book() {
    }

    public Book(String author, String title, int number) {
        this.author = author;
        this.title = title;
        this.number = number;
    }
}
