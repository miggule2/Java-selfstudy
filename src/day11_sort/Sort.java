package day11_sort;

public class Sort {
    private void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length;j++){
                if(arr[j] < arr[minIndex]){ minIndex = j; }
            }
            swap(arr, i, minIndex);
        }
    }

    public void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j;
            int temp = arr[i];
            for(j = i-1; j >= 0; j++){
                if(arr[j] <= temp) break;
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }
}
