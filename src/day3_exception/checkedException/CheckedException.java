package day3_exception.checkedException;

import java.io.FileWriter;
import java.io.IOException;

public class CheckedException {
    public static void main(String[] args) {
        try{
            FileWriter f = new FileWriter("data.txt");
            f.write("hello");
            f.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
