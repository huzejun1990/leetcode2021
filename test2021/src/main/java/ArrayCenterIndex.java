import java.util.Arrays;

/**
 * @Author : huzejun
 * @Date: 2021/10/8-22:00
 */
public class ArrayCenterIndex {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));

    }

    public static int pivotIndex(int[] nums){
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == sum){
                return i;
            }
            sum = sum - nums[i];

        }


        return -1;
    }
}
