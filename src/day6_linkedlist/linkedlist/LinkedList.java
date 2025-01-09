package day6_linkedlist.linkedlist;

import java.util.List;

public class LinkedList<E> { //implements List<E>
    // 노드 정의
    class Node<E> {
        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    // 노드 개수 세는 변수
    private int currentSize;
    // 기본 연결 리스트
    public LinkedList(){
        head = null;
        currentSize = 0;
    }

    public void addFirst (E obj){
        Node<E> node = new Node<>(obj);
        node.next = head;
        head = node;
        currentSize++;
    }

    public void addLast (E obj){
        Node<E> node = new Node<>(obj);
        Node<E> temp = head;
        if(head==null){
            head = node;
            currentSize++;
            return;
        }
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        currentSize++;
    }

    public void newAddLast (E obj){
        Node<E> node = new Node<>(obj);
        Node<E> temp = head;
        if(head==null){
            tail = head = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }
}


