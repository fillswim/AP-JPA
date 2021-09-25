package com.example.database.P08_GeneratedValue;

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
        Student student2 = new Student("Nick");
        Student student3 = new Student("Mike");

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
