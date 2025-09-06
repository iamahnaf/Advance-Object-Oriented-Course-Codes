package ConstructorOverloading;

public class Student {
    String name;
    int roll;
    int age;
    Student(String name, int roll, int age) {
        this.name = name;
        this.roll = roll;
        this.age = age;
    }
    Student(){}
}
