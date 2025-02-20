package day2_polymorphism.polymorphism;

public class Cat implements Animal{
    @Override
    public void makeSound(){
        System.out.println("meow!");
    }
}
