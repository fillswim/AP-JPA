package com.example.database.P43_Versioning;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        // Сохранение объекта
        entityTransaction.begin();
        Student student = new Student("Mike");
        System.out.println(student.getVersion()); // Version: 0
        entityManager.persist(student);

        System.out.println(student.getVersion()); // Version: 0
        student.setName("newName");
        System.out.println(student.getVersion()); // Version: 0

        entityTransaction.commit();

        // Версия меняется только после коммита и после изменения объекта
        System.out.println(student.getVersion()); // Version: 1


        entityManager.close();
        entityManagerFactory.close();
    }
}
