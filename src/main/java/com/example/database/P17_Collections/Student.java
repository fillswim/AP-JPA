package com.example.database.P17_Collections;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @ElementCollection // Коллекция будет сохраняться в отдельную таблицу с внешним ключом от student
    @CollectionTable(name = "listStudentMarks") // Переобозначение таблицы в базе данных
    @Column(name = "mark") // Переобозначение столбца в таблице в БД
    List<String> list = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "mapStudent")
    @Column(name = "map")
    @MapKeyColumn(name = "myKey") // Переименование столбца ключей в таблице БД
    Map<Integer, String> map = new HashMap<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
        list.add("one");
        list.add("two");
        list.add("three");

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

    }
}
