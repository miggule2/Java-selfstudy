package day8_treeandheap.heap;

public class Heap<E> {
    private int lastPosition;
    private E[] array;

    public Heap(int size){
        lastPosition = 0;
        array = (E[]) new Object[size];
    }

    public void add(E obj){
        array[++lastPosition] = obj;
        trickleUp(lastPosition);
    }

    public void swap(int from, int to){
        E temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public void trickleUp(int position){
        if(position == 0) return;

        int parent = (int)Math.floor((position-1)/2);
        if(((Comparable<E>)array[position]).compareTo(array[parent])>0){
            swap(position,parent);
            trickleUp(parent);
        }
    }

    public E remove(E obj){
        E temp = array[0];
        swap(0,lastPosition--);
        trickleDown(0);
        return temp;
    }

    public void trickleDown(int position){
        int left = 2*position+1;
        int right = 2*position+2;

        // 마지막에 왼쪽 자식이 큰 경우
        if(left == lastPosition && ((Comparable<E>)array[position]).compareTo(array[left])<0){
            swap(position,left);
            return;
        }
        // 마지막에 오른쪽 자식이 큰 경우
        if(right == lastPosition && ((Comparable<E>)array[position]).compareTo(array[right])<0){
            swap(position,right);
            return;
        }
        // 마지막에 부모가 더 큰 경우
        if(left >= lastPosition || right >= lastPosition){
            return;
        }
        // 왼쪽 자식이 큰 경우
        if(((Comparable<E>)array[left]).compareTo(array[right])>0 && ((Comparable<E>)array[position]).compareTo(array[left])<0){
            swap(position,left);
            trickleDown(left);
            return;
        }
        // 오른쪽 자식이 큰 경우
        else if(((Comparable<E>)array[position]).compareTo(array[right])<0){
            swap(position,right);
            trickleDown(right);
            return;
        }
        // 나머지 중간에 부모가 더 큰 경우에는 그냥 return 처리된다.
    }
}
