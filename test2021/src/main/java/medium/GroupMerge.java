package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : huzejun
 * @Date: 2021/10/28-17:23
 */
public class GroupMerge {

    public static void main(String[] args) {
//        System.out.println(getProvince(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));  //2
//        System.out.println(getProvince(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));  //3

//        System.out.println(bfs(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));  //2
//        System.out.println(bfs(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));  //3

        System.out.println(mergeFind(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));  //2
        System.out.println(mergeFind(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));  //3


    }

    //广度优先
    private static int bfs(int[][] citysConnected) {
        int citys = citysConnected.length;
        boolean[] visited = new boolean[citys];
        int provinces = 0; //计数器
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < citys; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()){
                    int poll = queue.poll();
                    visited[poll] = true;
                    for (int j = 0; j < citys; j++){
                        if (citysConnected[i][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }

                }
                provinces++;

            }
        }
        return provinces;
    }

    private static int getProvince(int[][] citysConnected) {
        int citys = citysConnected.length;
        boolean[] visited = new boolean[citys];
        int provinces = 0; //计数器
        for (int i = 0; i < citys; i++) {
            if (!visited[i]) {
                //深度优先
                dfs(i,citys,visited,citysConnected);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int i, int citys, boolean[] visited, int[][] citysConnected) {
        for (int j = 0; j < citys; j++) {
            if (citysConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(j, citys,  visited,  citysConnected);
            }
        }
    }

    // 并查集
    private static int mergeFind(int[][] citysConnected) {
        int citys = citysConnected.length;
        int[] head = new int[citys];
        int[] level = new int[citys];
        for (int i = 0; i < citys; i++) {
            head[i] = i;
            level[i] = 1;
        }
        for (int i = 0; i < citys; i++) {
            for (int j = i + 1; j < citys; j++) {
                if (citysConnected[i][j] == 1) {
                    merge(i,j,head,level);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < citys; i++) {
            if (head[i] == i) {
                count++;
            }
        }
        return count;
    }

    static void merge(int x,int y,int[] head,int[] level){
        int i = find(x,head);
        int j = find(y,head);

        if (i == j) {
            return;
        }
        if (level[i] <= level[j]) {
            head[i] = j;
        }else {
            head[j] = i;
        }
        if (level[i] == level[j]) {
            level[i]++;
            level[j]++;
        }

    }

    private static int find(int x, int[] head) {
        if (head[x] == x) {
            return x;
        }
        head[x] = find(head[x],head);
        return head[x];

    }


}
