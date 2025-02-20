package day1_inheritance.ex;

public class InheritanceMain {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 2);
        Cat cat = new Cat("bully",3);
        Bird bird = new Bird("bird", 1);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}
