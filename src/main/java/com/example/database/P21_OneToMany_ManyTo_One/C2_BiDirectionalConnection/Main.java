package com.example.database.P21_OneToMany_ManyTo_One.C2_BiDirectionalConnection;

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

        // Создание студента
        Student student1 = new Student("Nate");
        Student student2 = new Student("Nick");

        // Создание книг
        Book book1 = new Book("Author1", "Title1", student1);
        Book book2 = new Book("Author2", "Title2", student1);
        Book book3 = new Book("Author3", "Title3", student2);
        Book book4 = new Book("Author4", "Title4", student2);

        // Создание списка книг
        List<Book> books1 = new ArrayList<>();
        books1.add(book1);
        books1.add(book2);

        List<Book> books2 = new ArrayList<>();
        books2.add(book3);
        books2.add(book4);

        // Добавление списка книг студенту
        student1.setBooks(books1);
        student2.setBooks(books2);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(student1);
        entityManager.persist(student2);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
