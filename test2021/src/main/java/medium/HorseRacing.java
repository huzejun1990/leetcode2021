package medium;

import java.util.*;

/**
 * @Author : huzejun
 * @Date: 2021/11/3-17:58
 * 田忌赛马 ->优势洗牌
 * 给定两个大小相等的数组A和B,A相对于B的优势可以用满足 A[i] > B[i]的索引i的数目来描述。
 * 返回A的任意排列，使用其相对于B的优势最大化
 */
public class HorseRacing {

    public static void main(String[] args) {
        int[] A = new int[]{10,24,8,32};
        int[] B = new int[]{13,25,25,11};

        System.out.println(Arrays.toString(advantageCount(A,B)));
    }

    public static int[] advantageCount(int[] A, int[] B){
        int[]  sortB = B.clone();
        Arrays.sort(sortB);
        Arrays.sort(A);

        Map<Integer, Deque<Integer>> bMap = new HashMap<>();
        for (int b : B) {
            bMap.put(b,new LinkedList<>());
        }
        Deque<Integer> aq = new LinkedList<>();
        int j = 0;
        for (int a : A){
            if (a > sortB[j]){
                bMap.get(sortB[j++]).add(a);
            }else {
                aq.add(a);
            }
        }

        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            if (bMap.get(B[i]).size() > 0) {
                ans[i] = bMap.get(B[i]).removeLast();
            }else {
                ans[i] = aq.removeLast();
            }
        }
        return ans;
    }

}
