package day6_linkedlist.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E>{
    public Iterator<E> iterator() {
        return new IteratorHelper<>();
    }

    class IteratorHelper<E> implements Iterator<E>{
        LinkedList<E>.Node<E> index;
        public IteratorHelper(){
            index = (LinkedList<E>.Node<E>) head;
        }
        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E val = index.data;
            index = index.next;
            return val;
        }
    }

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

    public E removeFirst(){
        // 경계 조건 1
        if(head==null){
            return null;
        }
        E temp = head.data;
        // 경계 조건 2
        if(head.next == null){
            head = tail = null;
        }
        // 일반적인 경우
        else {
            head = head.next;
        }
        currentSize--;
        return temp;
    }

    public E removeLast(){
        // 자료구조가 비어있는 경우
        if(head==null) { return null; }
        E temp = head.data;
        // 자료구조에 단 하나의 요소만 있는 경우
        if(head == tail){
            return removeFirst();
        }

        Node<E> current = head, previous = null;
        while(current != tail){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = null;
        currentSize--;
        return temp;
    }

    public E remove(E obj){
        Node<E> current = head, previous = null;
        while(current != null){ // removeFirst와 달리 current != null 까지 보는 이유는 마지막 노드까지 처리해주기 위함
            if(((Comparable<E>)obj).compareTo(current.data) == 0){ // 찾은 경우
                if(current == head){ return removeFirst();} // 1번째 노드인 경우
                if(current == tail){ return removeLast(); } // 마지막 노드인 경우
                currentSize--;
                previous.next = current.next; // remove해주는 코드
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(E obj){
        Node<E> current = head;
        while(current != null){ // removeFirst와 달리 current != null 까지 보는 이유는 마지막 노드까지 처리해주기 위함
            if(((Comparable<E>)obj).compareTo(current.data) == 0){ return true;}
            current = current.next;
        }
        return false;
    }

    public E peekFirst(){
        if(head == null){return null;}
        return head.data;
    }

    public E peekLast(){
        if(tail == null){return null;}
        return tail.data;
    }
}


