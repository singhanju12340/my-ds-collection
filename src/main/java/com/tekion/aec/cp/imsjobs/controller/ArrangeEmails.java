package com.tekion.aec.cp.imsjobs.controller;

import java.util.*;

/**
 * @author anju
 * @created on 19/10/24 and 7:51 PM
 */
public class ArrangeEmails {

    public List<List<String>> accountsMerge2(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parentKeyMap = new HashMap<>();
        Map<String, String> parentMap = new HashMap<>();
        Map<String, String> link = new HashMap<>();
        Map<String, TreeSet<String>> result = new HashMap<>();

        // parent is assigned to parent
        int key=0;
        for(List<String> row : accounts){
            String parent = row.get(0);
            parentMap.put(String.valueOf(key), String.valueOf(key));
            parentKeyMap.put( String.valueOf(key), parent);

            // decide link
            for(int i=1; i< row.size() ; i++){
                if( link.get(row.get(i)) == null ){
                    link.put(row.get(i), String.valueOf(key));
                }else{
                    String parentDestination = link.get(row.get(i));
                    parentMap.put(String.valueOf(key), parentDestination);
                }
            }
            key++;
        }

        // create final result
        for(String val : link.keySet()){

            String l = findParent(parentMap,link, val);
            if(result.get(l) == null) {
                result.put(l, new TreeSet<>());
            }
            result.get(l).add(val);
        }

        // convert map to List<List<String>>
        List<List<String>> result2 = new ArrayList<>();

        for(String val : result.keySet()){
            List<String> arr = new ArrayList<>(result.get(val));
            arr.add(0, parentKeyMap.get(val));
            result2.add(arr);
        }

        return result2;
    }

    public String findParent(Map<String, String> parentMap,Map<String, String> link, String current) {
        String newCurrent = link.get(current);

        while(true){
            if(!parentMap.get(newCurrent).equals(newCurrent)){
                newCurrent = parentMap.get(newCurrent);
            }else{
                return parentMap.get(newCurrent);
            }
        }
    }

    public static void main(String[] args) {
//        List<List<String>> accounts = new ArrayList<>();
//        accounts.add(Arrays.asList (new String[]{"John","johnsmith@mail.com","john_newyork@mail.com"}));
//        accounts.add(Arrays.asList (new String[]{"John","johnsmith@mail.com","john00@mail.com"}));
//        accounts.add(Arrays.asList (new String[]{"Mary","mary@mail.com"}));
//        accounts.add(Arrays.asList (new String[]{"John","johnnybravo@mail.com"}));

        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList (new String[]{"David","David0@m.co","David1@m.co"}));
        accounts.add(Arrays.asList (new String[]{"David","David3@m.co","David4@m.co"}));
        accounts.add(Arrays.asList (new String[]{"David","David4@m.co","David5@m.co"}));
        accounts.add(Arrays.asList (new String[]{"David","David2@m.co","David3@m.co"}));
        accounts.add(Arrays.asList (new String[]{"David","David1@m.co","David2@m.co"}));

        new ArrangeEmails().accountsMerge(accounts);
    }

}
