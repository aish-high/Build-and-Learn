package Coding.Arrays;

import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        Arrays.sort(arr);
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[i]==arr[j]){
                System.out.println("Found duplicate: "+arr[i]);
            }else
                i++;
        }
    }
}
