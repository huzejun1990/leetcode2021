import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : huzejun
 * @Date: 2021/10/9-0:30
 * 数组中两数之和，手写算法出现最多之一
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5,6},10)));
        System.out.println(Arrays.toString(solution1(new int[]{1,2,3,4,5,6},10)));
        System.out.println("======================");
        System.out.println(Arrays.toString(twoSearch(new int[]{1,2,3,4,5,6},10)));
        System.out.println("====================");
        System.out.println(Arrays.toString(twoPoint(new int[]{1,2,3,4,5,6},10)));
    }

    private static int[] solution(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    private static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSearch(int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++) {
            int low = i, high = numbers.length - 1;
            while (low <= high){
                int mid = (high - low)/2 + low;
                if (numbers[mid] == target - numbers[i]){
                    return new int[]{i,mid};
                }else if (numbers[mid] > target - numbers[i]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{0};
    }

    public static int[]  twoPoint(int[] numbers, int target) {
        int low = 0,high = numbers.length - 1;
        while (low < high){
            int sum = numbers[low] + numbers[high];
            if (sum == target){
                return new int[]{low,high};
            }else if (sum < target){
                low++;
            }else {
                high--;
            }
        }

        return new int[]{0};
    }








}
