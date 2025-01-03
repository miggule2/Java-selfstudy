package day3_exception.exception;

public class ExceptionHandleApp2 {
    public static void main(String[] args) {
        System.out.println(1);
        int[] scores = {10, 20, 30};
        try {
            System.out.println(2);
            System.out.println(3);
            System.out.println(2 / 0); //ArithmeticException
            System.out.println(4);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(5);
    }
}


