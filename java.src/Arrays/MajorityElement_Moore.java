package Arrays;

public class MajorityElement_Moore {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2,1,1};
        int majorityElement = nums[0], count = 0, j=0;
        while(j<nums.length){
            if (count == 0){
                majorityElement = nums[j];
            }
            if(nums[j] == majorityElement){
                count++;
            } else
                count--;
            j++;
        }
        System.out.println("Majority element is: "+majorityElement);
    }
}
