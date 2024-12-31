package day2_polymorphism.polymorphism;

public class Dog implements Animal {
    @Override
    public void makeSound(){
        System.out.println("woof");
    }
}
