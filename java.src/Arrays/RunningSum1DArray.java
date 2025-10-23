package Arrays;

public class RunningSum1DArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int sum = 0, i = 0;
        int[] result = new int[nums.length];
        for (int n : nums) {
            sum += n;
            result[i++] = sum;
        }
        for (int n : result) {
            System.out.println(n);
        }
    }
}
