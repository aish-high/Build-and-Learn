package Arrays.SlidingWindow;

import java.util.HashMap;

public class LongestSubarrayWithAtMostKFreq {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        int right=0, left=0, n=nums.length, maxLen = Integer.MIN_VALUE;
        while(right<n){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right]) > k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        System.out.println("Length of longest subarray: " + maxLen);
    }
}
