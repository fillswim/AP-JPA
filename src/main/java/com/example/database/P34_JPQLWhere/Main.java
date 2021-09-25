package com.example.database.P34_JPQLWhere;

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

        // AND, OR
//        Query query = entityManager.createQuery("select s from Student s where s.name = 'Mike' and s.id = 1");
//        List<Student> resultList = query.getResultList();
//        for (Student student : resultList) {
//            System.out.println(student);
//        }

        // >, <, ==, !=
//        Query query = entityManager.createQuery("select s from Student s where s.id != 1");
//        List<Student> resultList = query.getResultList();
//        for (Student student : resultList) {
//            System.out.println(student);
//        }

        // BETWEEN
//        Query query = entityManager.createQuery("select s from Student s where s.id between 2 and 4");
//        List<Student> resultList = query.getResultList();
//        for (Student student : resultList) {
//            System.out.println(student);
//        }

        // IN
//        Query query = entityManager.createQuery("select s from Student s where s.id in (2, 3, 4, 5)");
//        List<Student> resultList = query.getResultList();
//        for (Student student : resultList) {
//            System.out.println(student);
//        }

        // IS NULL
//        Query query = entityManager.createQuery("select s from Student s where s.id IS NOT NULL");
//        List<Student> resultList = query.getResultList();
//        for (Student student : resultList) {
//            System.out.println(student);
//        }

        // LIKE
        // % - любой набор символов
        // _ - любой символ
//        Query query = entityManager.createQuery("select s from Student s where s.name LIKE 'M%'");
//        List<Student> resultList = query.getResultList();
//        for (Student student : resultList) {
//            System.out.println(student);
//        }

        // SUBQUERY
        Query query = entityManager.createQuery("select s from Student s where s.name = " +
                "(select st.name from Student st where st.id = 1)");
        List<Student> resultList = query.getResultList();
        for (Student student : resultList) {
            System.out.println(student);
        }


        entityManager.close();
        entityManagerFactory.close();
    }
}
