package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

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
//        ListNode l1n1 = new ListNode(0);
//        ListNode l2n1 = new ListNode(1);

        ListNode result = addTwoNumbers(l1n1, l2n1);
        List<Integer> ll = new ArrayList<>();
        dfs(result, ll);
        System.out.println();
        System.out.println(ll.toString());
    }
    public static void dfs(ListNode root, List<Integer> list) {
        if(root.next == null) {
            System.out.print(root.val + " ");
            list.add(root.val);
            return;
        }
        dfs(root.next, list);
        System.out.print(root.val + " ");
        list.add(root.val);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int carry = 0;
        ListNode temp = result;
        while(true) {
            if (l1 != null || l2 != null) {
                int l1Value = (l1==null) ? 0:l1.val;
                int l2Value = (l2==null) ? 0:l2.val;
                int sum = l1Value + l2Value + carry;
                int sumValue = sum % 10;
                carry = sum / 10;
                System.out.println("l1 : " + l1Value + ", l2 : " + l2Value + ", carry : " + carry);
                temp.next = new ListNode(sumValue);
                temp = temp.next;
                if(l1!=null) l1 = l1.next;
                if(l2!=null) l2 = l2.next;
            } else {
                System.out.println("last carry : " + carry);
                if(carry > 0) {
                    temp.next = new ListNode(carry);
                }
                break;
            }
        }
        return result.next;
    }
    public static void makeNodes(ListNode root, int index, List<Integer> list) {
        if(list.size() == 1) {
            root.val = list.get(index);
            return;
        }
        if(index > list.size()-2) return;
        root.val = list.get(index++);
        root.next = new ListNode(list.get(index));
        makeNodes(root.next, index, list);
    }

}

















