/**
 * @Author : huzejun
 * @Date: 2021/10/10-16:47
 * 斐波那契数列
 * 求取斐波那契数列第N位的值
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(calculate(10));
        System.out.println("=================");
        System.out.println(calculate2(10));
        System.out.println("==================");
        System.out.println(iterate(10));    //时间复杂度 o(n) 空间 o(1)
    }

    //暴力递归
    public static int calculate(int num){
        if (num == 0){
            return 0;
        }
        if (num == 1){
            return 1;
        }
        return calculate(num-1) + calculate(num-2);
    }

    public static int calculate2(int num){
        int[] arr = new int[num + 1];

        return recurse(arr,num);
    }

    //去重递归
    private static int recurse(int[] arr,int num){
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (arr[num] != 0 ){
            return arr[num];
        }
        arr[num] = recurse(arr,num-1)+recurse(arr,num-2);
        return arr[num];
    }

    //双指针迭代
    private static int iterate(int num){
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int low = 0,high = 1;
        for (int i = 2; i <= num; i++) {
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }
}
