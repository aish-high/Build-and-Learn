package Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        int sumTotal=0, leftSum = 0, rightSum;
        for(int num: nums){
            sumTotal += num;
        }
        int pivot=0;
        while(pivot<nums.length){
            rightSum = sumTotal - leftSum - nums[pivot];
            if(leftSum == rightSum) {
                System.out.println("Pivot index: " + pivot);
                break;
            }
            else {
                leftSum += nums[pivot];
                pivot++;
            }
        }
    }
}
