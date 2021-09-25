package com.example.database.P21_OneToMany_ManyTo_One.C2_BiDirectionalConnection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@Entity
public class Student {

    @Id @GeneratedValue
    int id;
    String name;

    // У студента может быть много книг
    // mappedBy = "student" избавляет от промежуточной таблицы, "student" - главная таблица
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
//    @JoinTable(name = "StudAddr") // Определение названия таблицы для связи двух таблиц
//    @JoinColumn(name = "addressId") // Таблицы связываются без промежуточной таблицы через поле в таблице Book
    List<Book> books = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
