package com.logics.linkedList;

import com.logics.monotonicStack.ListNode;

public class ReverseList {


    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        // single node list
        ListNode next = null;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        System.out.println(new ReverseList().reverseList(node1).val);

    }


}
