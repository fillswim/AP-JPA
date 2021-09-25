package com.example.database.P31_ContainceClearDetach;

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

        // Присутствует ли объект в PersistenceContext
        System.out.println(entityManager.contains(student));

        // Удаляем объект из PersistenceContext
//        entityTransaction.begin();
//        entityManager.remove(student);
//        entityTransaction.commit();

        // Проверяем еще раз наличие объекта в PersistenceContext
//        System.out.println(entityManager.contains(student));

        // Очищает PersistenceContext, в нем не остается ни одного объекта
        entityManager.clear();
        // Проверяем еще раз наличие объекта в PersistenceContext
        System.out.println(entityManager.contains(student));

        entityManager.close();
        entityManagerFactory.close();
    }
}
