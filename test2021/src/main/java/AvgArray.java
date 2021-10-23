/**
 * @Author : huzejun
 * @Date: 2021/10/23-15:26
 */
public class AvgArray {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }

    private static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        //先统计第一个窗口的和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < n; i++){
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(sum, max);
        }
        
        return 1.0 * max/k;
    }

}
