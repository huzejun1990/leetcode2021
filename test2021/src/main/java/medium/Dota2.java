package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : huzejun
 * @Date: 2021/11/3-15:25
 */
public class Dota2 {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));

    }

    public static String predictPartyVictory(String senate){
        //队列
        Queue<Integer> r = new LinkedList<Integer>();
        Queue<Integer> d = new LinkedList<Integer>();
        int length = senate.length();
        for (int i = 0; i < length; i++) {
            if (senate.charAt(i) == 'R') {
                r.offer(i);
            }else {
                d.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()){
            int rPool = r.poll(),dPoll = d.poll();
            if (rPool < dPoll) {
                r.offer(rPool+length); //让R进入下面一轮，不能干扰本轮
            }else {
                d.offer(dPoll + length);
            }

        }

        return d.isEmpty()? "R" : "D";

    }
}
