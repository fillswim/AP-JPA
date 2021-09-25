package com.example.database.P23_OrderBy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;
    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("number DESC")
//    @OrderColumn // Добавляет поле, где показывает изначальный порядок
    List<Book> books = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void printBooks() {
        for (Book book : books) {
            System.out.println(book.number);
        }
    }

}
