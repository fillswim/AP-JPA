package com.example.database.P37_DeleteUpdate;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        Student student1 = new Student("Mike");
        Student student2 = new Student("Nick");
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityTransaction.commit();

        // Update name
//        entityTransaction.begin();
//        Query query = entityManager.createQuery("update Student s set s.name = 'Jake' where s.id = 1");
//        query.executeUpdate();
//        entityTransaction.commit();

        // Delete student
        entityTransaction.begin();
        Query query = entityManager.createQuery("delete from Student s where s.id = 1");
        query.executeUpdate();
        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
