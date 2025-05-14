package com.logics.monotonicStack;

/**
 * @author anju
 * @created on 27/12/24 and 2:47 PM
 */

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
        next = null;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
