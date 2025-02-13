package com.tekion.aec.cp.imsjobs.controller.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author anju
 * @created on 25/11/24 and 3:52 PM
 */
public class LargestAreaHistogram {
    public static void main(String[] args) {
//       int[] heights = new int[] {2,1,5,6,2,3};
//        int[] heights = new int[] {2,4};
        int[] heights = new int[] {1,1};


        new LargestAreaHistogram().largestRectangleArea2(heights);
    }


    public int largestRectangleArea2(int[] heights){
        // find left nearest minimum
        // find right nearest minimum
        // calculate width between left min and right min for each height. then calculate area for the index

        int[] leftMin = new int[heights.length];
        Arrays.fill(leftMin, -1);

        int[] rightMin = new int[heights.length];
        Arrays.fill(rightMin, heights.length);

        Stack<Integer> st = new Stack<>();

        // find left minimum array
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()] >=heights[i]){
                st.pop();
            }
            leftMin[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        }

        // find right minimum array
        st.clear();
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >=heights[i]){
                st.pop();
            }

            rightMin[i] =  st.isEmpty()? heights.length : st.peek();
            st.push(i);
        }

        // calculate width and area for each height
        int maxHeight = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int currentHeightArea = (rightMin[i] - leftMin[i]-1 ) * heights[i];
            maxHeight = Math.max(maxHeight, currentHeightArea);
        }

        return maxHeight;
    }

}
