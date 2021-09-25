package com.example.database.P27_EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        // Начало транзакции
        entityTransaction.begin();

        Student student = new Student("Pete");

        // Сохранение объекта в БД
        entityManager.persist(student);

        entityTransaction.commit();
//        entityTransaction.rollback(); // Отмена транзакции

        // Ищем студента с ID = 1
        Student studentFind = entityManager.find(Student.class, 1);
        System.out.println(studentFind);

        // Создается пустой объект Student, но при обращении к его полям данные подкачиваются из БД
        Student studentRef = entityManager.getReference(Student.class, 1);
        System.out.println(studentRef);

        entityTransaction.begin();
        // Удаление объекта из БД
        entityManager.remove(student);
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
