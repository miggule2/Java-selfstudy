package day1_inheritance.inheritance;

public class Dog extends Animal {
    Dog(String name,int age) {
        super(name, age);
    }

    @Override
    void makeSound(){
        System.out.println("Woof!");
    }
}
