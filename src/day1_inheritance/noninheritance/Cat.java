package day1_inheritance.noninheritance;

public class Cat {
    String name;
    int age;

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound(){
        System.out.println("Meow!");
    }
}

