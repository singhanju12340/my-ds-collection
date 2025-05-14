package com.logics.linkedList;

import com.logics.monotonicStack.ListNode;

public class Sort {

    public ListNode sortList(ListNode head) {

        ListNode tempNode = head;
        ListNode prevHead = null;

        while(head != null) {
            ListNode currNode = head;
            tempNode = head.next;
            ListNode prev = null;

            while(tempNode != null) {
                ListNode t1 = null;
                if (tempNode.val < head.val) {
                    // swap temp and head
                    t1= tempNode.next;
                    prev.next = tempNode.next;

                    if(prevHead == null){
                        head = tempNode;
                    }else {
                        prevHead.next = tempNode;
                        tempNode.next = head.next;
                    }

                    prev.next = head;
                    head.next = t1;
                }else {
                    prev = tempNode;
                    tempNode = tempNode.next;
                }
            }

            prevHead = currNode;
            head = currNode;
            head = head.next;
        }
        return head;
    }





    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(3, new ListNode(2, null)));
        System.out.println(new ReverseList().reverseList(node1).val);

    }
}
