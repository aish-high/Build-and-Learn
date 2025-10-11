package Coding.Arrays.Triplets;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int i=0, sum;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        while(i<nums.length-2){
            int j =i+1;
            int k = nums.length-1;
            while(j<k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum==0)
                    set.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if (sum<0)
                    j++;
                else
                    k--;
            }
            i++;
        }
        List<List<Integer>> result = new ArrayList<>(set);
        result.forEach(System.out::println);
    }
}
