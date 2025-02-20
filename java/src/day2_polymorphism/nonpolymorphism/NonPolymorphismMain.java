package day2_polymorphism.nonpolymorphism;

public class NonPolymorphismMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat  = new Cat();

        dog.makeSound();
        cat.makeSound();
    }
}
