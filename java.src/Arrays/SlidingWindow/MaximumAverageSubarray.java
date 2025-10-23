package Arrays.SlidingWindow;

public class MaximumAverageSubarray {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int windowSum = 0, k=4;
        for(int i=0; i<k ; i++){
            windowSum += nums[i];
        }
        double maxSum = windowSum;
        for(int i = k; i<nums.length; i++){
            windowSum = windowSum - nums[i-k] + nums[i];
            maxSum = Math.max(windowSum, maxSum);
        }
        System.out.println("Maximum average: " + maxSum /k);
    }
}
