package com.logics.stackImp;

import java.util.Stack;

/**
 * @author anju
 * @created on 01/03/25 and 5:45 PM
 */
public class Spreadsheet {

    /***
     *A spreadsheet consists of a two-dimensional array of cells, labeled A1, A2, etc. Rows are
     * identified using letters, columns by numbers. Each cell contains either an integer (its value) or
     * an expression. Expressions contain integers, cell references, and the operators ‘+’, ‘-’, ‘*’, ‘/’ with
     * the usual rules of evaluation - note that the input is RPN and should be evaluated in stack order.
     * Write a program (in Python, C, C++, or Java) to read a spreadsheet from ‘stdin’, evaluate the
     * values of all the cells, and write the output to ‘stdout’.
     * The spreadsheet input is defined as follows:
     * ● Line 1: two integers, defining the width and height of the spreadsheet (n, m)
     * ● n*m lines each containing an expression which is the value of the corresponding cell
     * (cells enumerated in the order A1, A2, A<n>, B1, ...)
     * Your program must output its data in the same format, but each cell should be reduced to a
     * single floating-point value. For example, we would expect the following output.
     *
     *Input Output
     * 3 2
     * A2
     * 4 5 *
     * A1
     * A1 B2 / 2 +
     * 3
     * 39 B1 B2 * /
     *
     *OUTPUT
     *
     * 3 2
     * 20.00000
     * 20.00000
     * 20.00000
     * 8.66667
     * 3.00000
     * 1.50000
     *
     *        1            ,       2          ,             3
     * A ,     A2           ,      4 5 *      ,            A1
     * B ,   A1 B2 / 2 +     ,        3        ,     39 B1 B2 * /
     */


    public static void main(String[] args) {

        int n = 2;
        int m = 3;
        String[][] inputCells = new String[n][m];
        Double[][] resultCells = new Double[n][m];
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        String[] rawInput = new String[]{"A2", "4 5 *", "A1", "A1 B2 / 2 +", "3", "39 B1 B2 * /"};
        String[] rawNegInput = new String[]{"A2", "-4 5 *", "A1", "A1 B2 / 2 +", "3", "39 B1 B2 * /"};
        String[] rawCycleInput = new String[]{"A2", "4 5 *", "A1", "A1 B2 / 2 +", "B1", "39 B1 B2 * /"};
        String[] rawSingleOperatorInput = new String[]{"A2", "5++", "A1", "A1 B2 / 2 +", "3", "39 B1 B2 * /"};




        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){
                inputCells[i][j] = rawSingleOperatorInput[count++];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){
                resultCells[i][j] = new Spreadsheet().calculateCell(inputCells, resultCells,i, j, visited);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){

                System.out.println( String.format("%.5f", resultCells[i][j]));
            }
        }
    }

    public double calculateCell(String[][] input, Double[][] resultCells, int i, int j, boolean[][] visited){
        if(resultCells[i][j] != null){
            return resultCells[i][j];
        }

        if(visited[i][j])
            throw new RuntimeException("cyclic loop deteted");

        visited[i][j] = true;
        // Evaluate the expression in RPN using a stack.
        double value = calculate(input, resultCells, i, j, visited);
        resultCells[i][j] = value;
        visited[i][j] = false;
        return value;
    }

    public double calculate(String[][] input, Double[][] resultCells,int i, int j, boolean[][] visited){
        String[] expressionKeys = input[i][j].split("\\ ");
        Stack<Double> stack = new Stack<>();

        for(String key : expressionKeys){
            if(isOperator(key)){
                //post fix  expression
                double op1 = stack.pop();
                double op2 = stack.pop();
                double currResult = calculateValue(op1, op2, key);
                stack.push(currResult);
            }else if (isSingleOperator(key)){
                //single expression
                double currResult = calculateSingleOperatorValue(key);
                stack.push(currResult);
            }
            else if (isCell(key)){
                //
                double value  = calculateCell(input, resultCells, key.charAt(0)-'A', Integer.parseInt(String.valueOf(key.charAt(1)))-1, visited);
                stack.push(value);
            }else{
                // value
                stack.push(Double.parseDouble(key));
            }
        }
        return stack.pop();
    }

    private double calculateValue(double op1, double op2, String operator){
            switch (operator){
                case "+":  return op2 + op1;
                case "-":  return op2 - op2;
                case "*":  return op2 * op1;
                case "/":
                    if (op2 == 0) throw new ArithmeticException("Division by zero");
                    return op2 / op1;
                default:
                    throw new IllegalArgumentException("Unknown operator: " + operator);
            }
    }

    private double calculateSingleOperatorValue( String operator){
        if(operator.contains("++") )
            return Double.parseDouble(operator.substring(0,1))+1;

        if(operator.contains("--") )
            return Double.parseDouble(operator.substring(0,1))-1;
        throw new RuntimeException("Invalid single expression");
    }

    public boolean isOperator(String value){
        if(value.length() ==1 && (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")))
         return true;
        return false;
    }

    public boolean isSingleOperator(String value){
        if(value.length() ==3 && (value.contains("++") || value.contains("--")))
            return true;
        return false;
    }


    public boolean isCell(String cellValue){
        return cellValue.length() >= 2 &&
                Character.isLetter(cellValue.charAt(0)) &&
                Character.isDigit(cellValue.charAt(1));
    }




}
