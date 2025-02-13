package com.tekion.aec.cp.imsjobs.controller.graph.dfs;

import java.util.*;

/**
 * @author anju
 * @created on 24/01/25 and 5:00 PM
 */
public class EvalDivision2 {
    class Node{
        String des;
        Double value;

        public Node(String des, Double value) {
            this.des = des;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, ArrayList<Node>> graph = createGraph(equations, values);

        for(int i=0;i<queries.size();i++){
            HashSet<String> visited = new HashSet<>();
            List<String> query = queries.get(i);
            String qStart = query.get(0);
            String qEnd = query.get(1);
            result[i] = dfs(qStart, qEnd, graph, visited);
        }
        return result;
    }

    public double dfs(String start, String end, Map<String, ArrayList<Node>> graph, HashSet<String> visited){
        if(!graph.containsKey(start) || !graph.containsKey(end)){
            return -1.0;
        }
        if(start.equals(end))
            return 1.0;
        visited.add(start);

        ArrayList<Node> adj = graph.get(start);
        for(Node linkedNode : adj){

            if(!visited.contains(linkedNode.des)){
                double res = dfs(linkedNode.des, end, graph, visited);
                if(res != -1)
                    return res * linkedNode.value;
            }
        }

        return -1;
    }

    public Map<String, ArrayList<Node>> createGraph(List<List<String>> equations, double[] values){
        Map<String, ArrayList<Node>> graph = new HashMap<String, ArrayList<Node>>();
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
