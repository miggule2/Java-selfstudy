package day5_readyfordatastructure.genericprogramming;

public class Node<E> {
    E data;
    Node<E> next;
    public Node(E obj) {
        data = obj;
        next = null;
    }
}
