package day11_sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = {2,14,8,9,6,7,15,63,20};
        QuickSort<Integer> qs = new QuickSort<>(arr);
        System.out.println(Arrays.toString(qs.getArray()));
    }
}
