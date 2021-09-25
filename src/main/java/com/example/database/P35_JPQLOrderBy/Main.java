package com.example.database.P35_JPQLOrderBy;

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
        Student student3 = new Student("Mike");
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityTransaction.commit();

        // Сортировка
//        Query query = entityManager.createQuery("select s from Student s order by s.name");
//        List<Student> resultList = query.getResultList();
//        for (Student student : resultList) {
//            System.out.println(student);
//        }

        // Сортировка в обратном порядке
        Query query = entityManager.createQuery("select s from Student s order by s.name desc");
        List<Student> resultList = query.getResultList();
        for (Student student : resultList) {
            System.out.println(student);
        }


        entityManager.close();
        entityManagerFactory.close();
    }
}
