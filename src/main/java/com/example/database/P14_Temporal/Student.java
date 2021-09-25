package com.example.database.P14_Temporal;

import javax.persistence.*;
import java.util.Date;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

//    @Temporal(TemporalType.DATE) // Сохранение даты в формате YYYY-MM-DD (SQL date)
//    @Temporal(TemporalType.TIME) // Сохранение времени в формате HH-MM-SS (SQL time)
    @Temporal(TemporalType.TIMESTAMP) // Сохранение даты и времени в формате YYYY-MM-DD HH-MM-SS.MS (SQL datetime)
    Date date = new Date();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }
}
