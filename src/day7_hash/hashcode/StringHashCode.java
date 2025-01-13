package day7_hash.hashcode;

public class StringHashCode {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(hash(str));
    }

    public static int hash(String str){
        int g = 31;
        int hash = 0;
        for(int i = 0; i < str.length(); i++){
            hash = hash * g + str.charAt(i);
        }
        return hash;
    }
}
