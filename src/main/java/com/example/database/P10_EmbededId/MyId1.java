package com.example.database.P10_EmbededId;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MyId1 implements Serializable {

    String name;
    String surname;

    public MyId1() {
    }

    public MyId1(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyId1 myId = (MyId1) o;
        return Objects.equals(name, myId.name) && Objects.equals(surname, myId.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
