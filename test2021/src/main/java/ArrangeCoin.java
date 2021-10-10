/**
 * @Author : huzejun
 * @Date: 2021/10/10-18:18
 *
 * 排列硬币
 */
public class ArrangeCoin {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));
        System.out.println("==============");
        System.out.println(arrangeCoins2(10));
        System.out.println("=================");
        System.out.println(arrangeCoins3(10));
    }

    //迭代
    public static int arrangeCoins(int n){
        for (int i = 1; i <= n ; i++) {
            n = n - i;
            if (n <= i){
                return i;
            }
        }
        return 0;
    }

    //二分查找 时间复杂 log(n)
    public static int arrangeCoins2(int n){
        int low = 0,high = n;
        while (low <= high){
            int mid = (high - low)/2 + low;
            int cost = ((mid + 1) * mid) /2;
            if (cost == n){
                return mid;
            }else if (cost > n){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return high;
    }

    //牛顿迭代
    public static int arrangeCoins3(int n){
        if (n == 0) {
            return 0;
        }
        return (int) sqrt(n,n);
    }

    private static double sqrt(double x, int n) {
        double res = (x + (2 * n - x) / x) / 2;
        if (res == x) {
            return x;
        }else {
            return sqrt(res,n);
        }
    }
}
