package com.example.database.P40_NativeQuery;

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

        // Создание запроса на SQL
        Query query = entityManager.createNativeQuery("select * from STUDENT", Student.class);
        List<Student> resultList = query.getResultList();
        for (Student student : resultList) {
            System.out.println(student);
        }



        entityManager.close();
        entityManagerFactory.close();
    }
}
