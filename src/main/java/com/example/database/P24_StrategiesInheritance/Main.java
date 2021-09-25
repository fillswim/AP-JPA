package com.example.database.P24_StrategiesInheritance;

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

        Student student = new Student("Pete");
        Worker worker = new Worker("woodcutter");

        entityManager.persist(student);
        entityManager.persist(worker);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
