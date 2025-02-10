package day10_redblacktree;

public class RedBlackTree<K,V>{
    Node<K,V> root;
    int size;
    class Node<K,V>{
        K key;
        V value;
        Node<K,V> left,right,parent;
        boolean isLeftChild, black;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = right = parent = null;
            isLeftChild = false;
            black = false;
        }
    }

    // 사용자가 호출하는 add 메서드
    public void add(K key, V value){
        Node<K,V> newNode = new Node<>(key, value);
        if(root == null) {
            root = newNode;
            root.black = true;
            size++;
            return;
        }
        add(root,newNode);
        size++;
    }

    // 실직적으로 실행되는 add 메서드
    private void add(Node<K,V> parent, Node<K,V> newNode){
        // 새 노드가 부모보다 큰 경우
        if(((Comparable<K>)newNode.key).compareTo(parent.key) > 0){
            // 부모의 오른쪽 자식이 비어있는 경우
            if(parent.right == null){
                parent.right = newNode;
                newNode.parent = parent;
                newNode.black = false; // 새로운 노드는 항상 빨간색
                newNode.isLeftChild = false; // 새로운 노드는 부모의 오른쪽 자식
                checkColor(newNode); // 최종적으로 들어갈 때, 트리의 균형 확인
            }
            add(parent.right,newNode);  // 자식이 비어있는 경우가 나올 때까지 내려감
            return;
        }
        // 부모의 왼쪽 자식이 비어있는 경우
        if(parent.left == null){
            parent.left = newNode;
            newNode.parent = parent;
            newNode.black = false;
            newNode.isLeftChild = true; // 새로운 노드는 부모의 왼쪽 자식
            checkColor(newNode);  // 최종적으로 들어갈 때, 트리의 균형 확인
        }
        add(parent.left,newNode);  // 자식이 비어있는 경우가 나올 때까지 내려감
    }

    public void checkColor(Node<K,V> node) {
        if(node == root){
            node.black = true;
            return;
        }

        if(!node.black && !node.parent.black){
            correctTree(node);
        }

        checkColor(node.parent);
    }

    public void correctTree(Node<K,V> node){
        if(node.parent.isLeftChild){
            if(node.parent.parent.right == null || node.parent.parent.right.black){
                rotate(node);
                return;
            }
            if(node.parent.parent.right != null){
                node.parent.black = true;
                node.parent.parent.black = false;
                node.parent.parent.right.black = true;
                return;
            }
        }
        else {
            if (node.parent.parent.left == null || node.parent.parent.left.black) {
                rotate(node);
                return;
            }
            if (node.parent.parent.left != null) {
                node.parent.black = true;
                node.parent.parent.black = false;
                node.parent.parent.left.black = true;
                return;
            }
        }
    }
}
