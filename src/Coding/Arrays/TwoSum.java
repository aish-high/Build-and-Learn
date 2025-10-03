package Coding.Arrays;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {8,7,2,9};
        int target = 15;
        HashMap<Integer,Integer> seenMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int complement = target - nums[i];
            if(seenMap.containsKey(complement)){
                System.out.println("Indices that sums to target: " + i + "," + seenMap.get(complement));
            }
            seenMap.put(nums[i],i);
        }
    }
}
