package day1_inheritance.inheritance;

public class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound(){
        System.out.println("animal sound");
    }
}
