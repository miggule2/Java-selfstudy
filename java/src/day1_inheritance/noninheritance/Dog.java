package day1_inheritance.noninheritance;

public class Dog {
    String name;
    int age;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound(){
        System.out.println("Woof!");
    }
}

