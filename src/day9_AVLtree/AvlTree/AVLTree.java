package day9_AVLtree.AvlTree;

import day9_AVLtree.AvlTree.Node;

public class AVLTree<E> {
    Node<E> root;
    int currentSize;

    public AVLTree(){
        root = null;
        currentSize = 0;
    }

    public void add(E obj){
        Node<E> newNode = new Node<>(obj);
        if(root == null){
            root = newNode;
            currentSize++;
            return;
        }

        add(root,newNode);
    }

    private void add(Node<E> parent, Node<E> newNode){
        // 새로운 노드가 기존 노드보다 큰 경우 -> 오른쪽 자식으로
        if(((Comparable<E>)newNode.data).compareTo(parent.data) > 0){
            // 오른쪽 자식이 없는 경우 -> 오른쪽 자식에 새로운 노드
            if(parent.right == null){
                parent.right = newNode;
                newNode.parent = parent;
                currentSize++;
            }
            // 오른쪽 자식이 있는 경우 -> 오른쪽 자식과 add 메서드
            else add(parent.right, newNode);
        }
        // 새로운 노드가 기존 노드보다 작거나 같은 경우 -> 왼쪽 자식
        else {
            if(parent.left == null){
                parent.left = newNode;
                newNode.parent = parent;
                currentSize++;
            }
            else add(parent.left, newNode);
        }
        // 노드를 추가한 뒤에는 균형이 맞는지 확인
        checkBalance(newNode);
    }

    private void checkBalance(Node<E> node){
        if(height(node.left) - height(node.right) > 1 || height(node.left) - height(node.right) < -1) rebalance(node);

        if(node.parent == null)
            return;
        checkBalance(node.parent);
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
        node.right = leftRotate(node.right);
        return rightRotate(node);
    }

    // 왼쪽 자식의 오른쪽 서브트리에 불균형이 있는 경우 -> 부모 노드에 대해서 left rotation, 조부모 노드를 right rotation
    public Node<E> leftRightRotate(Node<E> node){
        node.left = rightRotate(node.left);
        return leftRotate(node);
    }

    public void rebalance(Node<E> node){
        // 왼쪽 자식 > 오른쪽 자식
        if(height(node.left) - height(node.right) > 1){
            if(height(node.left.left) > height(node.left.right)) { rightRotate(node); } // 왼쪽 서브트리 > 오른쪽 서브트리 -> right rotate
            else { leftRightRotate(node); } // 오른쪽 서브트리 > 왼쪽 서브트리 -> left-right rotate
        }
        // 오른쪽 자식 > 왼쪽 자식
        else {
            if(height(node.right.left) > height(node.right.right)) { leftRightRotate(node); }// 왼쪽 서브트리 > 오른쪽 서브트리 -> right-left rotate
            else { leftRotate(node); }
        }
        // 루트가 올 때까지 반복
        if(node.parent == null) root = node;
    }

    public int height(){
        if(root == null) return 0;
        return height(root)-1;
    }

    public int height(Node<E> node){
        if(node == null) return 0;
        int leftHeight = height(node.left)+1;
        int rightHeight = height(node.right)+1;

        if(leftHeight > rightHeight){return leftHeight;}
        return rightHeight;
    }
}
