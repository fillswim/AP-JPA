package com.example.database.P36_JPQLGroupByHaving;

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
        Student student4 = new Student("Mike");
        Student student5 = new Student("Nick");
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);
        entityTransaction.commit();

        // Группировка по именам
//        Query query = entityManager.createQuery("select s.name from Student s group by s.name");
//        List<String> resultList = query.getResultList();
//        for (String s : resultList) {
//            System.out.println(s);
//        }

        // Группировка по именам и вычисление количества значений
//        Query query = entityManager.createQuery("select count (s) from Student s group by s.name");
//        List<Long> resultList = query.getResultList();
//        for (long l : resultList) {
//            System.out.println(l);
//        }

        // Having наложение условий на вывод после группировки
        Query query = entityManager.createQuery("select count (s) from Student s group by s.name having count (s) < 3");
        List<Long> resultList = query.getResultList();
        for (long l : resultList) {
            System.out.println(l);
        }


        entityManager.close();
        entityManagerFactory.close();
    }
}
