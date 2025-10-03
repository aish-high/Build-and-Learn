package Coding.Arrays;

public class TwoSumSorted
{
    public static void main(String[] args) {
        int[] arr = {1,4,9,18,22,30};

        int left=0, right= arr.length-1,target=22,sum;
        while(left<right) {
            sum = arr[left] + arr[right];
            if(sum==target){
                System.out.println("Numbers: "+ arr[left] +"," + arr[right]);
                break;
            } else if(sum<target)
                left++;
            else
                right--;
        }
    }
}
