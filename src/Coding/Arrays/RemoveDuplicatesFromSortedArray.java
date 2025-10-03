package Coding.Arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 2, 3, 4, 4, 4, 5};
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[i]!=arr[j]) {
                i++;
                arr[i]=arr[j];
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
