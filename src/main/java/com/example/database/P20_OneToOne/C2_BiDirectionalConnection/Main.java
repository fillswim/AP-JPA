package com.example.database.P20_OneToOne.C2_BiDirectionalConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = new Student("Max");
        Address address = new Address("Moscow", "Pushkin st.", student);
        student.setAddress(address);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(student);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
