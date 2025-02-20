package day9_AVLtree.AvlTree;

public class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;
    Node<T> parent;
    public Node(T data){
        this.data = data;
        left = right = parent = null;
    }
}
