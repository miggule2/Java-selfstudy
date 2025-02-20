package day2_polymorphism.ex;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Bird();
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
