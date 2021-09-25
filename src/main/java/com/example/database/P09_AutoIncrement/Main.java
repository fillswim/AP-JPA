package com.example.database.P09_AutoIncrement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();


        entityTransaction.begin();

        Student student1 = new Student("Pete");

        entityManager.persist(student1);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
