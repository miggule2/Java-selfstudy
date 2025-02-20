package day3_exception.throwException;

import java.io.FileWriter;
import java.io.IOException;

public class Throws {
    public static void main(String[] args) throws IOException{
        FileWriter f = new FileWriter("data.txt");
        f.write("hello");
        f.close();
    }
}
