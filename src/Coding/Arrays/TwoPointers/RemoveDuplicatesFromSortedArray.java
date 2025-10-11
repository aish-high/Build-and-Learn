package Coding.Arrays.TwoPointers;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 2, 3, 4, 4, 4, 5};
        int slow =0;
        for (int fast = 1; fast < arr.length; fast++) {
            if(arr[slow]!=arr[fast]) {
                arr[++slow]=arr[fast];
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
