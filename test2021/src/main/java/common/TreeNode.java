package common;

/**
 * @Author : huzejun
 * @Date: 2021/10/25-15:53
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public int deep;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
