package Arrays.TwoPointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int len = height.length;
        int left=0, right=len-1, maxArea = 0;
        while(left<right){
            int currentHeight = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea, currentHeight * (right-left));
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        System.out.println(maxArea);
    }
}
