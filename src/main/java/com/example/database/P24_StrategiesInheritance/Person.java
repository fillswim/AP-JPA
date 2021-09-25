package com.example.database.P24_StrategiesInheritance;

import javax.persistence.*;

//@Entity
@DiscriminatorColumn(name = "ClassName") // Изменение названия поля с названием классв в БД
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // По умолчанию все наследуемые классы сохраняются в одну таблицу
//@Inheritance(strategy = InheritanceType.JOINED) // объекты и их классы разбиваются на связанные таблицы
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Для каждого класса будет отдельная таблица
public class Person {

    @Id
    @GeneratedValue
    int id;
    int age;
}
