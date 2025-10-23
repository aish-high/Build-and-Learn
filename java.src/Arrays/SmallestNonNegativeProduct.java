package Arrays;

public class SmallestNonNegativeProduct {
    public static void main(String[] args) {
        //For a given array A of N integers, return the smallest non-negative product of 2 elements of A
        // (both elements must be from different positions in A)

        int[] nums = {-2, 4, 1, -1, 3};

        int largNeg =Integer.MIN_VALUE, secLargNeg =Integer.MIN_VALUE;
        int smallPos=Integer.MAX_VALUE,secSmallPos=Integer.MAX_VALUE;

        int i=0;
        boolean hasZero=false;

        while (i<nums.length){
            if(nums[i] == 0) {
                hasZero = true;
                break;
            }
            else if(nums[i] >0 && nums[i]<smallPos){
                secSmallPos = smallPos;
                smallPos = nums[i];
            } else if(nums[i] >0 && nums[i]<secSmallPos)
                secSmallPos = nums[i];

            if(nums[i]<0 && nums[i]> largNeg){
                    secLargNeg = largNeg;
                    largNeg = nums[i];
            } else if(nums[i]<0 && nums[i] > secLargNeg){
                secLargNeg = nums[i];
            }
            i++;
        }
        int result = Integer.MAX_VALUE;
        if(smallPos!=Integer.MAX_VALUE && secSmallPos != Integer.MAX_VALUE)
           if(smallPos * secSmallPos >=0)
               result = Math.min(result,smallPos*secSmallPos);
        if(largNeg!=Integer.MIN_VALUE && secLargNeg != Integer.MIN_VALUE)
            if(largNeg * secLargNeg >=0)
                result = Math.min(result,largNeg*secLargNeg);
        System.out.println(hasZero ? 0: result);
    }
}
