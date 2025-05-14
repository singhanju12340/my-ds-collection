package com.logics.linkedList;

import com.logics.monotonicStack.ListNode;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for(ListNode currentLL : lists){
            result = mergeTwo(result, currentLL);

        }
        return result;

    }

    public ListNode mergeTwo(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1, null);
        ListNode headDummy = dummy;
        while(l1!=null && l2!=null){
            if(l1.val< l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else {
                dummy.next = l2;
                l2=l2.next;
            }
            dummy = dummy.next;
        }
        if(l1!=null){
            dummy.next = l1;
        }else{
            dummy.next = l2;
        }

        return headDummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode[] lists = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5, null))),
                new ListNode(1, new ListNode(3, new ListNode(4, null))),
                new ListNode(2, new ListNode(6, null))

        };

        mergeKSortedList.mergeKLists(lists);
    }
}
