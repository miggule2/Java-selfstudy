package day2_polymorphism.ex;

public class Dog implements Animal {
    @Override
    public void makeSound(){
        System.out.println("woof");
    }
}
