package com.example.database.P32_Merge;

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
        entityTransaction.commit();
        System.out.println(entityManager.contains(student));

        // Очистка PersistenceContext
        entityManager.clear();
        System.out.println(entityManager.contains(student));

        // Изменение имени студента
        student.setName("Mike");
        entityTransaction.begin();
        // Обновление данных в базе
        entityManager.merge(student);
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
