package com.logics;

import java.io.IOException;

/**
 * @author anju
 * @created on 30/06/24 and 8:34 PM
 */
public class Test {
    public static void main(String[] args) throws IOException {

        String dependent = "a";
        String currExp = "${a} + 10";
        String oRes = "10";
        currExp.replace("${" + dependent + "}", oRes);


//        List<String> result = Result.evaluate("dsas");
//
//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();

    }
}

//class Result {
//
//    /*
//     * Complete the 'evaluate' function below.
//     *
//     * The function is expected to return a STRING_ARRAY.
//     * The function accepts STRING api as parameter.
//     */
//
//    public class APIResult {
//        List<Group> groups;
//    }
//
//    public class Group{
//        String groupName;
//        List<Expression> expressions;
//    }
//
//    public class Expression{
//        String name;
//        String expressionType;
//        String expression;
//        List<String> dependencies;
//    }
//
//    public static List<String> evaluate(String api) {
//        // Write your code here
//        System.out.println(api);
//        Gson gson = new Gson();
//        APIResult apiResult = gson.fromJson( api, APIResult.class );
//        List<String> result = new ArrayList<>();
//
//        for (Group group : apiResult.groups) {
//            String gRes=group.groupName;
//            Map<String, String> mRes = new HashMap<>();
//            for (Expression expression : group.expressions){
//                String cRes = toDo(expression, mRes);
//                mRes.put(expression.name, cRes);
//            }
//
//            for (Map.Entry<String, String> entry : mRes.entrySet()) {
//                System.out.println(entry.getKey() + "/" + entry.getValue());
//                gRes.concat(":" + entry.getKey() + ":"+ entry.getValue());
//            }
//            result.add(gRes);
//        }
//
//        return result;
//    }
//
//    public static String toDo(Expression expressionObj, Map<String, String> mRes){
//        String res=null;
//        if(expressionObj.dependencies.size() ==0 && expressionObj.expressionType.equals("DIRECT")){
//            res = expressionObj.expression;
//        }else if(expressionObj.expressionType.equals("RS_EXPRESSION")){
//            String cRes = fnReplace(expressionObj.dependencies, expressionObj.expression, mRes);
//            res = "("+cRes+") RS";
//        }else if(expressionObj.expressionType.equals("DOLLAR_EXPRESSION")){
//            String cRes = fnReplace(expressionObj.dependencies, expressionObj.expression, mRes);
//            res = "("+cRes+") $";
//        }
//
//        return res;
//    }
//
//    public static String fnReplace(List<String> dependencies, String currExp,  Map<String, String> mRes){
//        for (String dependent : dependencies) {
//            String oRes = mRes.get(dependent);
//            currExp.replace("${"+dependent+"}", oRes);
//        }
//        return currExp;
//    }
//
//}

