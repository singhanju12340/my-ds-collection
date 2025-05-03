package com.logics.dp.dpString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author anju
 * @created on 16/04/25 and 4:52 PM
 */
public class PrintAllSubString {

    public static void main(String[] args) {
        String str = "anju";
        List<String> sets = new ArrayList<>();
        sets.add("");

        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                    sets.add(str.substring(i,j+1));
            }
        }
        System.out.println(sets);
    }
}
