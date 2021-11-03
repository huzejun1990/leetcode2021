package medium;

import common.TreeNode;

/**
 * @Author : huzejun
 * @Date: 2021/11/2-23:48
 * 打家劫舍（砸窑）
 */
public class Rob {
    public static void main(String[] args) {
/*//        int[] nums = new int[]{1,2,3,1};
        int[] nums = new int[]{2,7,9,3,1};
//        System.out.println(maxMoney(nums,nums.length-1));
        System.out.println(maxMoney1(nums));
        System.out.println(Math.max(maxMoney2(nums, 0, nums.length - 2), maxMoney2(nums, 1, nums.length - 1)));

        */

        TreeNode node5 = new TreeNode(1,null,null);
        TreeNode node4 = new TreeNode(3,null,null);
        TreeNode node3 = new TreeNode(3,null,node5);
        TreeNode node2 = new TreeNode(2,null,node4);
        TreeNode node1 = new TreeNode(3,node2,node3);
        int[] i = dfs(node1);
        System.out.println(Math.max(i[0], i[0]));
    }

    static int maxMoney(int [] nums,int index){
        if (nums == null || index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0];
        }
        return Math.max( maxMoney(nums, index - 1),maxMoney(nums, index - 2)+nums[index]);
    }

    //最优子结构 n -> n - 1 递推公司 重叠子问题
    static int maxMoney1(int [] nums){
        int length = nums.length;
        if (nums == null || length == 0){
            return 0;
        }
        if (length == 0){
            return nums[0];
        }
       /* int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
           dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i]);
        }*/
        int first = nums[0],second = nums[1];
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first+nums[i],second);
            first = temp;
        }
        return second;
    }

    //首尾相连
    static int maxMoney2(int [] nums,int start,int end) {
        int first = nums[start],secoud = Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            int temp = secoud;
            secoud = Math.max(first+nums[i],secoud);
            first = temp;
        }
        return secoud;
    }

    public static int[] dfs(TreeNode node){
        // int[]{select最优解,notselect最优解}
        if (node == null) {
            return new int[]{0,0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int select = node.val + l[1] + r[1];
        int notSelect = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return new int[]{select,notSelect};

    }
}
