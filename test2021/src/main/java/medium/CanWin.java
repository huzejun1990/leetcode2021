package medium;

/**
 * @Author : huzejun
 * @Date: 2021/10/31-2:18
 */
public class CanWin {

    public static void main(String[] args) {
//        {5,200,1,3,6}
//        {5,200,1,3,5}

        int[] arr = new int[]{5,200,2,3};
/*        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int p1 = maxScore(arr,0,arr.length-1);
        System.out.println(p1 > sum - p1);*/
        System.out.println("===========");
//        System.out.println(maxScore1(arr, 0,arr.length-1));
        System.out.println(dp(arr));

//        System.out.println(maxScore1(arr,0,arr.length-1));
    }

    static int maxScore(int[] arr,int l,int r){
        if (l == r) {
            return arr[l];
        }
        int sLeft = 0,rRight = 0;
        if (r-l == 1) {
            sLeft =  arr[l];
            rRight = arr[r];
        }
        if (r - l >= 2) {
            sLeft = arr[l] + Math.min(maxScore(arr,l+2, r),maxScore(arr,l+1,r-1));
            rRight = arr[r] + Math.min(maxScore(arr,l+1,r-1),maxScore(arr,l,r-2));
        }
        return Math.max(sLeft,rRight);
    }

    static int maxScore1(int[] arr,int l,int r){
        if (l == r) {
            return arr[l];
        }
        int sLeft = arr[l] - maxScore1(arr, l+1, r);
        int rRight = arr[r] - maxScore1(arr,l, r-1);
        return Math.max(sLeft,rRight);
    }

    //动态规范 maxScore(arr,l+1,r)存储到 [i+1][j] [i][j-1] db数组
    //初始化 （二维数组）
/*    static boolean dp(int[] arr){
        int length = arr.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = arr[i];
        }
        for (int i = length - 2; i >= 0 ; i--) {
            for (int j = i+1 ; j > length; j++) {
//                dp[i][j] = Math.max(sLeft,rRight);
                dp[i][j] = Math.max(arr[i] - dp[i+1][j],arr[j] - dp[i][j-1]);
            }
        }

        return dp[0][length-1] >= 0;
    }*/

    //优化版 (一维数组)
    static boolean dp(int[] arr){
        int length = arr.length;
        //length如果是偶数，返回true
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = arr[i];
        }
        for (int i = length - 2; i >= 0 ; i--) {
            for (int j = i+1 ; j > length; j++) {
                dp[j] = Math.max(arr[i] - dp[j],arr[j] - dp[j-1]);
            }
        }
        return dp[length-1] >= 0;
    }
}
