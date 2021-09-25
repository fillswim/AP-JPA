package com.example.database.P28_DeleteOrphan;

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

        // Создаем студента и адрес
        Student student = new Student("Pete");
        Address address = new Address("Moscow", "Pushkin str.");

        // Добавляем студенту адрес
        student.setAddress(address);

        // Сохраняем студента
        entityManager.persist(address);
        entityManager.persist(student);

        entityTransaction.commit();

        // Удаление студента
        entityTransaction.begin();
        entityManager.remove(student);
        entityTransaction.commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
