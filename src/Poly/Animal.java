package Poly;

public class Animal {
    void makeSound(){
        System.out.println("Make sound");
    }
}
class Cat extends Animal{
    void makeSound(){
        System.out.println("meow mewoww");
    }
}
class Dog extends Animal{
    void makeSound(){
        System.out.println("bark bark");
    }
}
