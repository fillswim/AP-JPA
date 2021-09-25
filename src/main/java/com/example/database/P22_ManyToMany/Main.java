package com.example.database.P22_ManyToMany;

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

        // Создание списка адресов
        List<Address> addresses1 = new ArrayList<>();
        List<Address> addresses2 = new ArrayList<>();
        // Создание списка студентов
        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();

        // Создаем студента
        Student student1 = new Student("Nate");
        Student student2 = new Student("Mate");
        Student student3 = new Student("Pete");
        Student student4 = new Student("Mike");
        // Создаем адрес для студента
        Address address1 = new Address("Moscow", "Street 1");
        Address address2 = new Address("Moscow", "Street 2");
        Address address3 = new Address("Moscow", "Street 3");
        Address address4 = new Address("Moscow", "Street 4");

        // Добавление адреса в список адресов
        addresses1.add(address1);
        addresses1.add(address2);
        addresses1.add(address3);
        // Добавдление студента в список студентов
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);

        // Добавляем студенту список адресов
        student1.setAddresses(addresses1);
        student2.setAddresses(addresses1);
        // Добавляем список студентов адресу
        address1.setStudents(students1);

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        // Сохранение
        entityManager.persist(student1);
        entityManager.persist(student2);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
