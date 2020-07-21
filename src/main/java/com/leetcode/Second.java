package com.leetcode;

/**
 * @program: basicDemo
 * @description: 两数相加，add two numbers
 * @author: 无能狂怒
 * @create: 2020-07-03 02:25
 **/
public class Second {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);

        showListNode(solution(l1,l2));

    }

    public static void showListNode(ListNode listNode) {
        StringBuilder s = new StringBuilder(String.valueOf(listNode.val));
        while (listNode.next != null) {
            listNode = listNode.next;
            s.append(listNode.val);
        }
        StringBuilder reverse = s.reverse();
        System.out.println(reverse.toString());
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode p = l1, q = l2, current = l3;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum%10 );
            current = current.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if (carry > 0) current.next = new ListNode(carry);
        return l3.next;
    }
}

class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
