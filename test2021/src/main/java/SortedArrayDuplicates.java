/**
 * @Author : huzejun
 * @Date: 2021/10/8-18:32
 * 去除重复元素-面试必考
 */
public class SortedArrayDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
