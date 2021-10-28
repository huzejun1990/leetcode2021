import common.TreeNode;

import java.util.*;


/**
 * @Author : huzejun
 * @Date: 2021/10/25-15:56
 */
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
//        preorder(node1);
//        ArrayList list = new ArrayList();
//        levelOrder(node1,1,list);
//        System.out.println(Arrays.toString(list.toArray()));
//        preorder2(node1);
//        midorder(node1);
//        postorder(node1);
//        midorder(node1);
//        morrisPre(node1);
//        morrisMid(node1);
        morrisPos(node1);

    }

    private static void preorder(TreeNode root) {
        if (root == null){
            return;
        }
//        System.out.println(root.val);   //前序：第一次成为栈顶元素即打印
        preorder(root.left);
//        System.out.println(root.val);   //中序：第二次成为栈顶元素即打印
        preorder(root.right);
        System.out.println(root.val);     //后序：第三次成为栈顶元素立即打印

    }

    private static void levelOrder(TreeNode root,int i,ArrayList list) {
        if (root == null){
            return;
        }
        int length = list.size();
        if (length <= i) {
            for (int j = 0; j <= i - length; j++) {
                list.add(length + j,null);
            }
        }
        list.set(i,root.val);
        levelOrder(root.left,2 * i,list);
        levelOrder(root.right,2 * i + 1,list);
    }

    //前序遍历：根 左右
    private static void preorder2(TreeNode root) {
        if (root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(root);
            while (!stack.isEmpty()){
                root = stack.pop();
                if (root != null) {
                    System.out.println(root.val);
                    stack.push(root.right);
                    stack.push(root.left);
                }
            }

        }

    }

    //中序遍历： 左根右
    private static void midorder(TreeNode root) {
        if (root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
//            stack.add(root);
            while (!stack.isEmpty() || root != null){
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }

        }

    }

    //后序遍历： 右左根
    private static void postorder(TreeNode root) {
        if (root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode prev = null;
            while (!stack.isEmpty() || root != null){
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    System.out.println(root.val);
                    prev = root;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }
            }

        }

    }

    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.println(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

    }

    public static void morrisPre(TreeNode cur){
        if (cur == null) {
            return;
        }
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
            while (mostRight.right != null && mostRight.right != cur) {
                mostRight = mostRight.right;
            }
            if (mostRight.right == null) {  //建立线索指针
                mostRight.right = cur;
                System.out.println(cur.val);
                cur = cur.left;
                continue;
            }else {     // mostRight.right == cur  删除线索指指针
                mostRight.right = null;
            }
        }else {
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

    //中序打印
    public static void morrisMid(TreeNode cur){
        if (cur == null) {
            return;
        }
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {  //建立线索指针
                    mostRight.right = cur;
//                    System.out.println(cur.val);
                    cur = cur.left;
                    continue;
                }else {     // mostRight.right == cur  删除线索指指针
                    mostRight.right = null;
                }
            }else {
//                System.out.println(cur.val);
            }
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    //后序打印 morris
    public static void morrisPos(TreeNode cur){
        if (cur == null) {
            return;
        }
        TreeNode root = cur;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {  //建立线索指针
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {     // mostRight.right == cur  删除线索指指针
                    mostRight.right = null;
                    printNode(cur.left);
                }
            }
            cur = cur.right;
        }
        printNode(root);
    }

    //打印node
    private static void printNode(TreeNode head) {
        TreeNode tail = reverse(head);
        while (tail != null){
            System.out.println(tail.val);
            tail = tail.right;
        }
        reverse(tail);
    }

    private static TreeNode reverse(TreeNode head) {
        TreeNode prev = null,curr,next;
        curr = head;
        while (curr != null){
          next =  curr.right;
          curr.right = prev;
          prev = curr;
          curr = next;
        }
        return prev;
    }
}
