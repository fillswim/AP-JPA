package com.example.database.P38_DinamicQuery;

import javax.persistence.*;

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

        // Возврат единственного объекта
//        TypedQuery<Student> query = entityManager.createQuery("select s from Student s where s.id = 1", Student.class);
//        Student student = query.getSingleResult();
//        System.out.println(student);

        // Динамические запросы
        // ?1 - 1 параметр
        // ?2 - 2 параметр
        // Нумерованные параметры
//        TypedQuery<Student> query = entityManager.createQuery(
//                "select s from Student s where s.id = ?1", Student.class);
//        query.setParameter(1, 1);
//        Student student = query.getSingleResult();
//        System.out.println(student);

        // Именованные параметры
        // :idOne - именованный параметр
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s where s.id = :idOne", Student.class);
        query.setParameter("idOne", 1);
        Student student = query.getSingleResult();
        System.out.println(student);


        entityManager.close();
        entityManagerFactory.close();
    }
}
