package day2_polymorphism.ex;

public class Bird implements Animal{
    @Override
    public void makeSound() {
        System.out.println("peow~");
    }
}
