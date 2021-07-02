package leetcode.easy;


public class Q21 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
    public static void main(String[] args) {

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return new ListNode();
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int l1Val = 0;
        int l2Val = 0;
        ListNode answer = new ListNode();
        while(true) {
            if(l1 == null && l2 == null) return answer.next;
            if(l1 != null) l1Val = l1.val;
            if(l2 != null) l2Val = l2.val;
            if(l1 !=null && l1Val <= l2Val) {
                answer.next = new ListNode(l1Val);
                answer = answer.next;
                l1 = l1.next;
            } else {
                answer.next = new ListNode(l2Val);
                answer = answer.next;
                if(l2.next != null) l2 = l2.next;
                else l2 = null;
            }
        }
    }
}
