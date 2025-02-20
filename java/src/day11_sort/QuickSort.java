package day11_sort;

public class QuickSort<E> {
    E[] array;

    public QuickSort(E[] array) {
        this.array = array;
        quicksort(0,array.length-1);
    }
    // 위치 바꿔주는 함수
    private void swap(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    // 퀵정렬
    public void quicksort(int from, int to) {
        // 정렬 종료 조건
        if(from >= to) return;
        // pivot을 배열의 마지막 숫자로 선택
        E pivot = array[to];
        // pivot보다 큰 숫자를 가리키는 포인터
        int counter = from;
        // pivot 바로 앞까지 탐색
        for(int i = from; i < to; i++) {
            // pivot보다 작은 경우 pivot보다 큰 숫자의 자리와 교체
            if(((Comparable<E>)array[i]).compareTo(pivot) < 0){
                swap(counter,i);
                counter++;
            }
        }
        // pivot이 작은값과 큰값 중간에 오도록 위치.
        swap(counter,to);
        // pivot 왼쪽과 오른쪽에 동일한 과정 시행
        // pivot의 왼쪽과 오른쪽은 비교할 필요가 없음.
        quicksort(from,counter-1);
        quicksort(counter+1,to);
    }

    public E[] getArray(){
        return array;
    }
}
