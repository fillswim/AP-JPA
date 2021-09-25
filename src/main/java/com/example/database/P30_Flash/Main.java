package com.example.database.P30_Flash;

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

        entityManager.persist(student);

        // Не дожидаясь commit данные записываются в БД,
        // необходимо выполнять, если только все данные уже подготовлены
        entityManager.flush();
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
