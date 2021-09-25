package com.example.database.P21_OneToMany_ManyTo_One.C2_BiDirectionalConnection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
public class Book {

    @Id
    @GeneratedValue
    int id;

    String author;
    String title;

    // Много книг может быть у одного студента
    @ManyToOne
    Student student;

    public Book() {
    }

    public Book(String author, String title, Student student) {
        this.author = author;
        this.title = title;
        this.student = student;
    }
}
