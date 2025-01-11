package day6_linkedlist.linkedlist;

public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = 10;
        for(int i = 0; i < n; i++){
            list.addFirst(i);
        }
        for(int num : list) {
            System.out.println(num);
        }
        for(int i = 0; i < n; i++){
            System.out.println(list.removeFirst());
        }
    }
}
