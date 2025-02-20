package day7_hash.hashclass;

public class HashTester {
    public static void main(String[] args) {
        Hash<Integer, String> map = new Hash<>(10);
        map.add(1,"김동현");
        map.add(2,"rlagksthf");
        map.add(3,"france");

        for(int key : map){
            System.out.println(key + " " + map.getValue(key));
        }

        map.remove(1);

        for(int key : map){
            System.out.println(key + " " + map.getValue(key));
        }
    }
}
