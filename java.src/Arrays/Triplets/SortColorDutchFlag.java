package Arrays.Triplets;

import java.util.Arrays;

public class SortColorDutchFlag {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        int low = 0, mid = 0, high = arr.length-1, temp;
        while(mid<=high){
            if(arr[mid]==0){
                temp = arr[low];
                arr[low++] = arr[mid];
                arr[mid++] = temp;
            } else if (arr[mid] == 1)
                mid++;
            else{
                temp = arr[high];
                arr[high--] = arr[mid];
                arr[mid] = temp;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
