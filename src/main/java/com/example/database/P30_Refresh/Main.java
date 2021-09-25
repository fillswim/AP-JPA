package com.example.database.P30_Refresh;

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

        System.out.println(student.getName());

        // Присвоение нового имени для объекта в памяти
        student.setName("Nate");
        System.out.println(student.getName());

        entityTransaction.begin();
        entityManager.refresh(student); // Восстановление объекта из БД, данные в объекте перезаписываются
        entityTransaction.commit();

        System.out.println(student.getName());

        entityManager.close();
        entityManagerFactory.close();
    }
}
