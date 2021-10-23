/**
 * @Author : huzejun
 * @Date: 2021/10/23-22:54
 */
public class MaxSeq {
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1,2,3,2,3,4,3,4,5,6,7}));
    }

    private static int findLength(int[] nums) {
        int start = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                start = i;
            }
            max = Math.max(max,i - start + 1);
        }

        return max;
    }
}
