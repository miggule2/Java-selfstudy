package day3_exception.exception;

public class ExceptionHandleApp {
    public static void main(String[] args) {
        System.out.println(1);
        try{
            System.out.println(2/0); // Run-Time Exception -> ArithmeticException
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic Exception");
        }
        System.out.println(3);
    }
}
