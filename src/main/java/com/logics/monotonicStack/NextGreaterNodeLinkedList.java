package com.logics.monotonicStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author anju
 * @created on 27/12/24 and 2:47 PM
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class NextGreaterNodeLinkedList {



    public  int[] nextLargerNodes(ListNode head) {
        List<Integer> indexArray = new ArrayList<>();
        ListNode temp = head;
        Stack<Integer> st = new Stack<>();

        while(temp != null){
            indexArray.add(temp.val);
            temp = temp.next;
        }

        int[] result = new int[indexArray.size()];

        for(int i=indexArray.size()-1; i>=0; i--){
            while(!st.isEmpty() && indexArray.get(st.peek()) <= indexArray.get(i)){
                st.pop();
            }
            result[i] = st.isEmpty()? 0: indexArray.get(st.peek());
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        new NextGreaterNodeLinkedList().nextLargerNodes(new ListNode());
    }
}
