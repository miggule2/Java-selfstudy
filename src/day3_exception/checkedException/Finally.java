package day3_exception.checkedException;

import java.io.FileWriter;
import java.io.IOException;

public class Finally {
    public static void main(String[] args) {
        FileWriter f = null;
        try{
            f = new FileWriter("data.txt");
            f.write("hello");
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(f != null){
                try{
                    f.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
