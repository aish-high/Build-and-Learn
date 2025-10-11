package Coding.Arrays.TwoPointers;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,3,-4};
        int n=nums.length,maxProduct=nums[0],i=0,p=0,s=0;
        while(i<n){
            p = (p==0?1:p) * nums[i];
            s = (s==0?1:s) * nums[n-i-1];
            maxProduct = Math.max(maxProduct,Math.max(p,s));
            i++;
        }
        System.out.println("Maximum product: "+maxProduct);
    }
}
