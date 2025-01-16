package day7_hash.hashclass;

import day6_linkedlist.linkedlist.LinkedList;

import java.util.Iterator;

public class Hash<K,V> implements Iterable<K>{
    @Override
    public Iterator<K> iterator() {
        return new IteratorHelper<>();
    }

    class HashElement<K,V> implements Comparable<HashElement<K,V>>{
        K key;
        V value;
        public HashElement(K key, V value){
            this.key = key;
            this.value = value;
        }
        public int compareTo(HashElement<K,V> o){
            return ((Comparable<K>)this.key).compareTo(o.key);
        }
    }

    int numElements, tableSize;
    double maxLoadFactor;
    LinkedList<HashElement<K,V>>[] harray;
    public Hash(int tableSize){
        this.tableSize = tableSize;
        harray = (LinkedList<HashElement<K,V>>[])new LinkedList[tableSize];

        for(int i=0; i<tableSize; i++){
            harray[i] = new LinkedList<>();
        }
        numElements = 0;
        maxLoadFactor = 0.75;
    }

    public double loadFactor(){
        return numElements / (double)tableSize;
    }

    public boolean add(K key, V value){
        // resize
        if(loadFactor() > maxLoadFactor) resize(tableSize*2);

        // 키,값을 통해 저장해놓을 object he 정의
        HashElement<K,V> he = new HashElement<>(key, value);
        // he의 index찾기
        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7FFFFFFF;
        hashVal = hashVal % tableSize;
        // add he
        harray[hashVal].addFirst(he);

        numElements++;
        return true;
    }

    public boolean remove(K key){
        // 삭제하고 싶은 데이터를 찾기 위해 키 값이 같은 object 생성
        HashElement<K,V> he = new HashElement<>(key, null);
        // he의 index찾기
        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7FFFFFFF;
        hashVal = hashVal % tableSize;
        // add he
        harray[hashVal].remove(he);

        numElements--;
        return true;
    }

    public V getValue(K key){
        // 해당하는 index찾기
        int hashVal = (key.hashCode() & 0x7FFFFFFF) % tableSize;

        // harray[index]의 LinkedList에서 key값이 같은 element 찾기 위해 반복.
        for(HashElement<K,V> he : harray[hashVal]){
            if(((Comparable<K>)he.key).compareTo(key) == 0) return he.value;
        }
        return null;
    }

    public void resize(int newSize){
        LinkedList<HashElement<K,V>> [] newArray = (LinkedList<HashElement<K,V>>[]) new LinkedList[newSize];

        for(int i=0; i<newSize; i++){
            newArray[i] = new LinkedList<>();
        }

        for(K key : this){
            V val = getValue(key);
            HashElement<K,V> he = new HashElement<>(key, val);
            int hashVal = (key.hashCode()&0x7FFFFFFF)%newSize;
            newArray[hashVal].addFirst(he);
        }
        harray = newArray;
        tableSize = newSize;
    }

    class IteratorHelper<T> implements Iterator<T> {
        T[] keys;
        int position;
        public IteratorHelper(){
            keys = (T[]) new Object[numElements];
            int p = 0;
            for(int i=0; i<tableSize; i++){
                for(HashElement<K,V> he : harray[i]){
                    keys[p++] = (T)he.key;
                }
            }

            position = p;
        }

        @Override
        public boolean hasNext() {
            return position < keys.length;
        }

        @Override
        public T next() {
            if(!hasNext()) return null;
            return keys[position++];
        }
    }
}
