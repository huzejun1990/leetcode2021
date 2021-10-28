import java.util.Arrays;

/**
 * @Author : huzejun
 * @Date: 2021/10/23-23:52
 */
public class Triangles {
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3,6,2,3}));
    }

    private static int largestPerimeter(int[] a) {
        Arrays.sort(a);
        for (int i = a.length-1; i >= 2 ; i--) {
            if (a[i - 1] + a[i-2] > a[i]){
                return a[i-1] + a[i-2] + a[i];
            }
        }
        return 0;
    }


}
