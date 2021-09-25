package com.example.database.P33_JPQLSelect;

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

        // SELECT <select clause>
        // FROM <from clause>
        // [WHERE <where clause>]
        // [ORDER BY <order by clause>]
        // [GROUP BY <group by clause>]
        // [HAVING <having clause>]

//        Query query = entityManager.createQuery("select s from Student s");
//        Query query = entityManager.createQuery("select s from Student s where s.name = 'Mike'");
//        List<Student> students = query.getResultList();
//        for (Student student : students) {
//            System.out.println(student);
//        }

//        Query query = entityManager.createQuery("select s.id, s.name from Student s");
//        List<String> stringList = query.getResultList();
//        for (String s : stringList) {
//            System.out.println(s);
//        }

//        Query query = entityManager.createQuery("select s.name from Student s");
//        List<String> stringList = query.getResultList();
//        for (String s : stringList) {
//            System.out.println(s);
//        }

        // Вывод уникальных имен
//        Query query = entityManager.createQuery("select distinct s.name from Student s");
//        List<String> stringList = query.getResultList();
//        for (String s : stringList) {
//            System.out.println(s);
//        }

        // Подсчитать количество элементов
//        Query query = entityManager.createQuery("select count(s) from Student s");
//        List<Long> resultList = query.getResultList();
//        for (Long l : resultList) {
//            System.out.println(l);
//        }

        // Вывести максимальный id студента
//        Query query = entityManager.createQuery("select max (s.id) from Student s");
//        List<Integer> resultList = query.getResultList();
//        for (int i : resultList) {
//            System.out.println(i);
//        }

        // Функции для работы с числами
        // ABS, SQRT, MOD, SIZE, INDEX

        // Функции для работы со строками
        // CONCAT, SUBSTRING, TRIM, LOWER, UPPER, LENGTH, LOCATE

        // Функции для работы с датами
        // CURRENT DATE, CURRENT TIME, CURRENT TIMESTAMP

        // Перевести имя в верхний регистр
        Query query = entityManager.createQuery("select UPPER (s.name) from Student s");
        List<String> resultList = query.getResultList();
        for (String str : resultList) {
            System.out.println(str);
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
