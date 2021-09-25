package com.example.database.P20_OneToOne.C1_UniDirectionalConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Address address = new Address("Moscow", "Pushkin st.");
        Student student = new Student("Max", address);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(student);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
