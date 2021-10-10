import java.util.HashSet;
import java.util.Set;

/**
 * @Author : huzejun
 * @Date: 2021/10/10-22:43
 * 链表是否有环
 */
public class LinkCycle {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        node5.next = node3;

        System.out.println(hasCycle(node1));
        System.out.println("==================");
        System.out.println(hasCycle2(node1));
    }

    private static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
    //双指针
    public static boolean hasCycle2(ListNode head){
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick){
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

}
