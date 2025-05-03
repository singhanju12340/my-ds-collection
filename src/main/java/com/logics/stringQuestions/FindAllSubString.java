package com.logics.stringQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 20/04/25 and 1:43 PM
 */
public class FindAllSubString {

    public List<List<Character>> subsets(char[] nums) {
        List<List<Character>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // empty

        for(int i=0;i<nums.length; i++){
            for(int j=i+1;j<=nums.length; j++){
                List<Character> current = new ArrayList<>();
                for(int k=i; k<j;k++){
                    current.add(nums[k]);
                }
                result.add(current);
            }
        }
        return result;

    }
}
