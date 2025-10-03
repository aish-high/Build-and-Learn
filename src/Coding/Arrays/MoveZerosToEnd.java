package Coding.Arrays;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {1,1,3,8,4,0,4,8,0};
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
