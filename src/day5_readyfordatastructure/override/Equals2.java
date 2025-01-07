package day5_readyfordatastructure.override;

public class Equals2 {
    public static void main(String[] args) {
        Object one = "hello world!";
        Object two = "hello world!";
        // 오버라이딩 되어 있지 않다고 가정.
        if(one.equals(two)){
            System.out.println("they are the same");
        } else{
            System.out.println("they are not the same");
        }
    }
}
