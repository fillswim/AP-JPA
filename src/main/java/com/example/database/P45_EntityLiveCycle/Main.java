package com.example.database.P45_EntityLiveCycle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        // Сохранение объекта
        entityTransaction.begin();
        Student student = new Student("Mike");
        entityManager.persist(student);
        entityTransaction.commit();

        entityTransaction.begin();
        entityManager.detach(student);
        entityTransaction.commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
