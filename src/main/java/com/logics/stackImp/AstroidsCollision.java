package com.logics.stackImp;

import java.util.ArrayList;
import java.util.Stack;

public class AstroidsCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean survived = true;
        for(int i=0;i<asteroids.length;i++){
            int current = asteroids[i];
            survived = true;
            while(!stack.isEmpty() && stack.peek()>0 && current< 0){
                if(Math.abs(stack.peek())< Math.abs(current)){
                    stack.pop();
                }else if(Math.abs(stack.peek()) ==  Math.abs(current)){
                    stack.pop();
                    survived = false;
                    break;
                }else{
                    survived = false;
                    break;
                }
            }
            if( survived){
                stack.push(current);
            }
        }

        int[] result = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        new AstroidsCollision().asteroidCollision(new int[]{-2,1,-1,-2});
//        new AstroidsCollision().asteroidCollision(new int[]{10,2,-5});
//        new AstroidsCollision().asteroidCollision(new int[]{10,2,-5});


    }
}
