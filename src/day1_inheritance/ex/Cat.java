package day1_inheritance.ex;

public class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound(){
        System.out.println("meow!");
    }
}
