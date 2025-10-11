package Coding.Arrays;

public class MaximumSubarray_Kadane {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = nums[0],i=1,currSum=nums[0];
        while(i<nums.length){
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum, currSum);
            i++;
        }
        System.out.println("Maximum sum is :"+maxSum);

        //print maximum subarray
        int resStart = 0, resEnd = 0;
        int currStart = 0;

        maxSum = nums[0];
        int maxEnding = nums[0];

        for (int j = 1; j < nums.length; j++) {

            // If starting a new subarray from the current element
            // has greater sum than extending the previous subarray
            if (maxEnding + nums[j] < nums[j]) {
                // Update current subarray sum with current element
                // and start of current subarray with current index
                maxEnding = nums[j];
                currStart = j;
            }
            else {
                // Add current element to current subarray sum
                maxEnding += nums[j];
            }

            // If current subarray sum is greater than maximum subarray sum
            if (maxEnding > maxSum) {

                // Update maximum subarray sum
                maxSum = maxEnding;

                // Update start and end of maximum sum subarray
                resStart = currStart;
                resEnd = j;
            }
        }
        for (int k = resStart; k <= resEnd; k++)
            System.out.println(nums[k]);

    }
}
