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

    public void rotate(Node<K,V> node){
        if(node.isLeftChild){
            if(node.parent.isLeftChild){
                rightRotate(node.parent.parent);
                node.black = false;
                node.parent.black = true;
                if(node.parent.right != null) node.parent.right.black = false; // node,parent.right에 대한 판별은 필요없어보임.
                return;
            }
            leftRightRotate(node.parent.parent);
            node.black = true;
            node.left.black = false;
            node.right.black = false;
            return;
        } else {
            if(node.parent.isLeftChild){
                rightLeftRotate(node.parent.parent);
                node.black = true;
                node.left.black = false;
                node.right.black = false;
                return;
            }
            leftRotate(node.parent.parent);
            node.black = false;
            node.parent.black = true;
            node.parent.left.black = false;
            return;
        }
    }

    // 좌측회전 : 조부모 노드를 부모 노드의 왼쪽 자식노드 위치로 옮김.
    public void leftRotate(Node<K,V> node){
        Node<K,V> temp = node.right;
        node.right = temp.left;

        // temp.left가 node.right로 들어감.
        if(node.right != null){
            node.right.parent = node;
            node.right.isLeftChild = false;
        }
        // 조부모 노드가 루트인 경우
        if(node.parent == null){
            root = temp;
            temp.parent = null;
        }
        // 주부모 노드가 루트가 아닌 경우
        else {
            temp.parent = node.parent;
            if(node.isLeftChild){
                temp.parent.left = temp;
                temp.isLeftChild = true;
            } else {
                temp.parent.right = temp;
                temp.isLeftChild = false;
            }
        }
        temp.left = node;
        node.parent = temp;
        node.isLeftChild = true;
    }

    public void rightRotate(Node<K,V> node){
        Node<K,V> temp = node.left;
        node.left = temp.right;

        if(node.left != null){
            node.left.parent = node;
            node.left.isLeftChild = true;
        }

        if(node.parent == null){
            root = temp;
            temp.parent = null;
        } else {
            temp.parent = node.parent;
            if(node.isLeftChild){
                temp.parent.left = temp;
                temp.isLeftChild = true;
            } else {
                temp.parent.right = temp;
                temp.isLeftChild = false;
            }
        }
        temp.right = node;
        node.parent = temp;
        node.isLeftChild = false;
    }

    public void leftRightRotate(Node<K,V> node){
        leftRotate(node.left);
        rightRotate(node);
    }

    public void rightLeftRotate(Node<K,V> node){
        rightRotate(node.right);
        leftRotate(node);
    }

    public int height(){
        if(root == null) return 0;
        return height(root)-1;
    }

    public int height(Node<K,V> node){
        if(node == null) return 0;
        int leftHeight = height(node.left)+1;
        int rightHeight = height(node.right)+1;

        if(leftHeight > rightHeight){return leftHeight;}
        return rightHeight;
    }

    public int blackNodes(Node<K,V> node){
        if(node == null) return 0;
        int rightBlackNodes = blackNodes(node.right);
        int leftBlackNodes = blackNodes(node.left);

        // RedBlackTree의 규칙을 위반하는 경우(루트에서 리프까지의 경로까지 블랙노드의 수가 다른 경우) 발생 -> 오류 발생 or 해결
        if(leftBlackNodes != rightBlackNodes){
            // error 발생
            // 해결
        }

        // 현재 노드가 검정색이면 leftBlackNode++;
        if(node.black) leftBlackNodes++;
        return leftBlackNodes;
    }
}
