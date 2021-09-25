package com.example.database.P23_OrderBy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        // Создаем студента
        Student student1 = new Student("Pete");

        // Создаем книжки
        Book book1 = new Book("Author 1", "ZTitle", 3);
        Book book2 = new Book("Author 2", "CTitle", 2);
        Book book3 = new Book("Author 3", "BTitle", 5);
        Book book4 = new Book("Author 4", "HTitle", 1);

        // Создаем список книг
        List<Book> books1 = new ArrayList<>();
        books1.add(book1);
        books1.add(book2);
        books1.add(book3);
        books1.add(book4);

        // Добавляем книги для студента
        student1.setBooks(books1);

        entityTransaction.begin();

        // Сохранение студента в БД
        entityManager.persist(student1); // У студента student1 id = 1

        // Получение студента из БД
        Student student2 = entityManager.find(Student.class, 1);
        student2.printBooks();

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
