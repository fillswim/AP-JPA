package com.example.database.P39_NamedQuery;

import javax.persistence.*;

//@Entity
@NamedQueries({
        @NamedQuery(name = Student.FIND_ALL, query = "select s from Student s"),
        @NamedQuery(name = "selectFirst", query = "select s from Student s where s.id = 1"),
        @NamedQuery(name = "selectById", query = "select s from Student s where s.id = :id")
})
// Запрос на SQL
@NamedNativeQuery(name = "getAll", query = "select * from STUDENT", resultClass = Student.class)
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;
    public static final String FIND_ALL = "Student.findAll";

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
