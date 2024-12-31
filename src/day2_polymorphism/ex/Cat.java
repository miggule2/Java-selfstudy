package day2_polymorphism.ex;

public class Cat implements Animal {
    @Override
    public void makeSound(){
        System.out.println("meow!");
    }
}
