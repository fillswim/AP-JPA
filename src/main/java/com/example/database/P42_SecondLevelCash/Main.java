package com.example.database.P42_SecondLevelCash;

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

        // Получение кэша второго уровня
        Cache cache = entityManagerFactory.getCache();

        // Проверка наличия объекта в кэше
        System.out.println(cache.contains(Student.class, student1.getId()));

        // Удаление конкретного объекта из кэша
        cache.evict(Student.class, student1.getId());

        // Очистка всего кэша
        cache.evictAll();


        entityManager.close();
        entityManagerFactory.close();
    }
}
