package day8_treeandheap.tree;

import day8_treeandheap.tree.Node;

public class Tree<E> {
    private int currentSize;
    private Node<E> root;

    public Tree() {
        root = null;
        currentSize = 0;
    }

    // 사용자가 접근하는 add함수
    public void add(E obj){
        if(root == null){
            root = new Node<>(obj);
        }
        else add(obj,root);
        currentSize++;
    }

    // 실제로 사용되는 add함수
    private void add(E obj, Node<E> node){
        if(((Comparable<E>)obj).compareTo(node.data)>0){
            //go to right
            if(node.right == null){
                node.right = new Node(obj);
                return;
            }
            add(obj, node.right);
            return;

        }
        //go to left (같을 경우에도 왼쪽으로 감)
        if(node.left == null){
            node.left = new Node(obj);
            return;
        }
        add(obj, node.left);
        return;
    }

    // 사용자가 접근하는 contains함수
    public boolean contains(E obj){
        return contains(obj,root);
    }

    // 실제 사용되는 contains함수
    private boolean contains(E obj,Node<E> node){
        // 요소를 찾아 내려갔는데, null이 나오는 경우 -> 요소가 존재하지 않는 경우.
        if(node == null) return false;
        // node의 data와 일치.
        if(((Comparable<E>)obj).compareTo(node.data)==0) return true;
        // data가 node.data보다 큰 경우
        if(((Comparable<E>)obj).compareTo(node.data)>0) contains(obj,node.right);
        // data가 node.data보다 작은 경우
        return contains(obj,node.left);
    }
}
