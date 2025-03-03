package com.logics.graph.dfs;

import java.util.*;

/**
 * @author anju
 * @created on 24/01/25 and 2:29 PM
 */
public class EvaluateDivision {

    /**
     * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
     *
     * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
     *
     * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
     *
     * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
     *
     * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
     *
     *Example 1:
     *
     * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * Explanation:
     * Given: a / b = 2.0, b / c = 3.0
     * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
     * note: x is undefined => -1.0
     * Example 2:
     *
     * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
     * Output: [3.75000,0.40000,5.00000,0.20000]
     * Example 3:
     *
     * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
     * Output: [0.50000,2.00000,-1.00000,-1.00000]
     *
     * */

    class Node{
        String des;
        Double value;

        public Node(String des, Double value) {
            this.des = des;
            this.value = value;
        }
    }










    public static void main(String[] args) {

        List<List<String>> equ = new ArrayList<>();
        equ.add(Arrays.asList(new String[]{"a","b"}));
        equ.add(Arrays.asList(new String[]{"b","c"}));


        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList(new String[]{"a","c"}));
        queries.add(Arrays.asList(new String[]{"b","a"}));
        queries.add(Arrays.asList(new String[]{"a","e"}));
        queries.add(Arrays.asList(new String[]{"a","a"}));
        queries.add(Arrays.asList(new String[]{"x","x"}));


        double[] values = new double[] {2.0,3.0};
        new EvaluateDivision().calcEquation(equ, values, queries);
    }





    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, List<Node>> graph = createGraph(equations, values);

        for(int i=0;i<queries.size();i++){
            HashSet<String> visited = new HashSet<>();
            List<String> query = queries.get(i);
            String qStart = query.get(0);
            String qEnd = query.get(1);
            result[i] = dfs(qStart, qEnd, graph, visited);
        }
        return result;
    }

    private double dfs(String start , String end, Map<String, List<Node>> graph,  HashSet<String> visited){

        // equation can not be evaluated
        if(!graph.containsKey(start) || !graph.containsKey(end) ){
            return -1;
        }

        if(start.equals( end))
            return 1;

        List<Node> adjacentNode = graph.get(start);
        visited.add(start);

        for(int i=0;i<adjacentNode.size();i++){
            Node currNode = adjacentNode.get(i);
            if(!visited.contains(currNode.des)){
                double r = dfs(currNode.des, end, graph, visited);
                if(r != -1) {
                    return r * currNode.value;
                }
            }
        }
        return -1;
    }

    public Map<String,List<Node>> createGraph(List<List<String>> equations, double[] values){
        Map<String, List<Node>> graph = new HashMap<String, List<Node>>();
        for(int i=0; i<values.length; i++){
            List<String> currEq = equations.get(i);
            graph.putIfAbsent(currEq.get(0), new ArrayList<Node>());
            graph.putIfAbsent(currEq.get(1), new ArrayList<Node>());
            graph.get(currEq.get(0)).add(new Node(currEq.get(1), values[i]));
            graph.get(currEq.get(1)).add(new Node(currEq.get(0), 1/values[i]));
        }
        return graph;
    }

}
