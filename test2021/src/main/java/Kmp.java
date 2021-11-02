import java.util.Arrays;

/**
 * @Author : huzejun
 * @Date: 2021/11/2-23:18
 * 字符串搜索 Kmp算法
 */
public class Kmp {
    public static void main(String[] args) {
        String str1 = "ABCABCAABCABCD";
        String strPattern = "ABCABCD";
        int[] next = new int[strPattern.length()];
        getNext(strPattern.toCharArray(),next);
        int i = searcch(str1.toCharArray(),strPattern.toCharArray(),next);
        System.out.println(Arrays.toString(next));
        System.out.println(i);
        System.out.println(str1.indexOf(strPattern));
    }

    private static int searcch(char[] str, char[] pattern, int[] next) {
        int i = 0;
        int j = 0;

        while (i < str.length && j < pattern.length){
            if (j == -1 || str[i] == pattern[j]) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if (j == pattern.length) {
            return  i - j;
        }else {
            return -1;
        }
    }

    private static void getNext(char[] pattern, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;

        while (i < pattern.length){
            if (j == -1) {
                i++;
                j++;
            }else if (pattern[i] == pattern[j]) {
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
    }
}
