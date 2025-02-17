package day11_sort;

import java.util.Arrays;

public class MergeSort {
    int[] array,temp;
    public MergeSort(int[] array) {
        this.array = array;
        // 빈 배열을 만들어 중간중간 병합되는 배열들을 일시적으로 저장
        temp = new int[array.length];
        split(0,array.length-1);
    }

    // 리스트에 하나만 남을 때까지 split
    public void split(int low, int high){
        if(low == high) return;
        int mid = (low+high)/2;
        split(low,mid);
        split(mid+1,high);
        merge(low,mid,high);
    }

    // 쪼개진 두 배열을 병합&정렬
    private void merge(int low, int mid, int high){
        int i = low, j = mid+1, tempPos = low;
        // 두 쪼개진 리스트의 요소를 각각 비교하면서 병합
        while(i <= mid && j <= high){
            if(array[i] <= array[j]){
                temp[tempPos++] = array[i++];
            } else{
                temp[tempPos++] = array[j++];
            }
        }
        // 쪼개진 두 배열 중 남은 요소들을 temp에 저장
        while(i <= mid)  temp[tempPos++] = array[i++];
        while(j <= high) temp[tempPos++] = array[j++];
        // 원래 배열에 정렬된 배열 복사
        for(tempPos = low; tempPos <= high; tempPos++){
            array[tempPos] = temp[tempPos];
        }
    }

    public int[] getArray(){
        return array;
    }
}
