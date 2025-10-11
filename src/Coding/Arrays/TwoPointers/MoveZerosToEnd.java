package Coding.Arrays.TwoPointers;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {1,1,3,8,4,0,4,8,0};
        int slow = 0;
        for(int fast = 0; fast < arr.length; fast++) {
            if (arr[fast]!=0){
                int temp = arr[fast];
                arr[fast] = arr[slow];
                arr[slow] = temp;
                slow++;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
