package com.example.database.P21_OneToMany_ManyTo_One.C1_UniDirectionalConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Создание студента
        Student student = new Student("Max");

        // Создание списка адресов
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("Moscow", "Tverskay"));
        addresses.add(new Address("Moscow", "New Arbat"));

        // Добавление списка адресов студенту
        student.setAddresses(addresses);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(student);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
