package Coding.Arrays.SlidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums ={2,3,1,2,4,3};
        int target =7;
        int left=0,right=0,window_sum=0,minLen=Integer.MAX_VALUE;
        while(right<nums.length){
            window_sum += nums[right];
            while(window_sum >= target){
                minLen = Math.min(minLen, right-left+1);
                window_sum -= nums[left++];
            }
            right++;
        }
        System.out.println(minLen!=Integer.MAX_VALUE?minLen:0);
    }
}
