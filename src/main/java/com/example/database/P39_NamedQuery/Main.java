package com.example.database.P39_NamedQuery;

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

        // Вызов именованных запросов с помощью финализированной строки из класса Student
//        Query query = entityManager.createNamedQuery(Student.FIND_ALL, Student.class);
//        List<Student> resultList = query.getResultList();
//        for (Student student : resultList) {
//            System.out.println(student);
//        }

        // Вызов именованных запросов с параметрами
//        Query query = entityManager.createNamedQuery("selectById", Student.class);
//        query.setParameter("id", 2);
//        List<Student> resultList = query.getResultList();
//        for (Student student : resultList) {
//            System.out.println(student);
//        }

        // Вызов именованных запросов с параметрами
        Query query = entityManager.createNamedQuery("getAll", Student.class);
        List<Student> resultList = query.getResultList();
        for (Student student : resultList) {
            System.out.println(student);
        }



        entityManager.close();
        entityManagerFactory.close();
    }
}
