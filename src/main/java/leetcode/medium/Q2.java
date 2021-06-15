package leetcode.medium;

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Q2 {
    public static void main(String[] args) {
        ListNode l1n1 = new ListNode(2);
        ListNode l1n2 = new ListNode(4);
        ListNode l1n3 = new ListNode(3);
        l1n2.next = l1n3;
        l1n1.next = l1n2;

        ListNode l2n1 = new ListNode(5);
        ListNode l2n2 = new ListNode(6);
        ListNode l2n3 = new ListNode(4);
        l2n2.next = l2n3;
        l2n1.next = l2n2;

        addTwoNumbers(l1n1, l2n1);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        ListNode node1 = l1;
        ListNode node2 = l2;
        int node1Val = 0;
        int node2Val = 0;
        int add = 0;
        int sumValue = 0;
        ListNode temp = null;
        boolean isFirst = true;
        while(true) {
            System.out.println("l1 : " + node1.val + " l2 : " + node2.val);
            if(node1.next == null && node2.next == null) {
                System.out.println("node sum : " + (node1.val + node2.val + add));
                ListNode sub = new ListNode(node1.val + node2.val + add);
                temp.next = sub;
                break;
            }
            if(node1.next != null) {
                node1Val = node1.val;
                node1 = node1.next;
            }
            if(node2.next != null) {
                node2Val = node2.val;
                node2 = node2.next;
            }
            int nodeVal = (node1Val + node2Val);
            if(nodeVal >= 10) {
                sumValue = (nodeVal%10) + add;
                add = nodeVal/10;
            } else {
                sumValue = (nodeVal+add);
                add = 0;
            }
            System.out.println("node sum : " + sumValue);
            if(isFirst) {
                result.val = sumValue;
                temp = result;
            } else {
                ListNode sub = new ListNode(sumValue);
                temp.next = sub;
                temp = sub;
            }
        }
        return result;
    }
}

















