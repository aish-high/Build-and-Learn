package Coding.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = nums[0],i=1,currSum=nums[0];
        while(i<nums.length){
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum, currSum);
            i++;
        }
        System.out.println("Maximum sum is :"+maxSum);
    }
}
