package com.example.database.P45_EntityLiveCycle;

import javax.persistence.*;

//@Entity
public class Student {

    @Id
    @GeneratedValue
    int id;
    String name;

    @PrePersist
    void prePersist() {
        System.out.println("prePersist");
    }

    @PostPersist
    void postPersist() {
        System.out.println("postPersist");
    }

    @PostLoad
    void postLoad() {
        System.out.println("postLoad");
    }

    @PreUpdate
    void preUpdate() {
        System.out.println("preUpdate");
    }

    @PostUpdate
    void postUpdate() {
        System.out.println("postUpdate");
    }

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
