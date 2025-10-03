package Coding.Arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 1, 2, 3, 4, 4, 4, 5};
        int[] arr2 = {2,4,5,6,8,9,10,11};

        int[] merged = new int[arr1.length+ arr2.length];

        int i=0,j= 0,result=0;
        while (i< arr1.length){
            if(arr1[i] <= arr2[j]) {
                merged[result++] = arr1[i++];
            }
            else {
                merged[result++] = arr2[j++];
            }
        }
        for (int k = arr2.length-(arr1.length + arr2.length-result); k < arr2.length; k++) {
            merged[result] = arr2[k];
            result++;
        }
        System.out.println(Arrays.toString(merged));
    }
}
