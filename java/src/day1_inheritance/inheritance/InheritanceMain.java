package day1_inheritance.inheritance;

public class InheritanceMain {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 2);
        Cat cat = new Cat("bully",3);

        dog.makeSound();
        cat.makeSound();
    }
}
