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

    // 왼쪽 서브트리에 불균형이 있는 경우 -> right rotate
    public Node<E> rightRotate(Node<E> node){
        Node<E> temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    // 오른쪽 서브트리에 불균형이 있는 경우 -> left rotate
    public Node<E> leftRotate(Node<E> node){
        Node<E> temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    // 오른쪽 자식의 왼쪽 서브트리에 불균형이 있는 경우 -> 부모 노드에 대해서 right rotation, 조부모 노드를 left rotation
    public Node<E> rightLeftRotate(Node<E> node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    // 왼쪽 자식의 오른쪽 서브트리에 불균형이 있는 경우 -> 부모 노드에 대해서 left rotation, 조부모 노드를 right rotation
    public Node<E> leftRightRotate(Node<E> node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }
}
