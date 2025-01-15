package day7_hash.hashclass;

import day6_linkedlist.linkedlist.LinkedList;

public class Hash<K,V>{
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
}
