package com.logics.heapQuestions;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given a list of tasks, where each task is represented as below:
 * <task_id, queue_time, expected_execution_time>
 * Your goal is to determine the order in which the CPU should execute these tasks. The CPU follows these rules:
 *
 * • It can only execute tasks that have already arrived (i.e., queue_time ≤ current time).
 *
 * • Among the available tasks, it always selects the one with the shortest expected execution time.
 *
 * • If multiple tasks have the same expected execution time, you may assume any consistent tie-breaking rule (e.g., by task ID or arrival order).
 *
 *
 * Input:
 * <t1, 0, 10>
 *
 * <t1, 0, 10>, <t3, 11, 2>, <t2, 11, 3>
 *
 */

class Task {
    String taskId;
    int queueTime;
    int expectedExecutionTime;

    public Task(String taskId, int queueTime, int expectedExecutionTime) {
        this.taskId = taskId;
        this.queueTime = queueTime;
        this.expectedExecutionTime = expectedExecutionTime;
    }
}

public class TaskOrderCoupang {

    List<String> findOrder(List<Task> task){
        int currentTime = 0;
        Queue<Task> availableTasks = new PriorityQueue<>(
                (a, b) -> {
                    if (a.expectedExecutionTime == b.expectedExecutionTime) {
                        return a.taskId.compareTo(b.taskId) ; // tie-break by queue time
                    }
                    return a.expectedExecutionTime - b.expectedExecutionTime; // sort by execution time
                }
        );

        List<String> order = new java.util.ArrayList<>();
        int i=0;
        int n = task.size();

        while( i<n ){

            while(i<n && task.get(i).queueTime <= currentTime){
                availableTasks.offer(task.get(i));
                i++;
            }

            while(!availableTasks.isEmpty()){
                Task t1 = availableTasks.poll();
                order.add(t1.taskId);
                currentTime += t1.expectedExecutionTime;

            }

            if(i+1<n &&  task.get(i).queueTime> currentTime){
                currentTime = task.get(i).queueTime;
            }
        }

        return order;

    }


    public static void main(String[] args) {
        TaskOrderCoupang taskOrderCoupang = new TaskOrderCoupang();
        List<Task> tasks = List.of(
                new Task("t1", 0, 10),
                new Task("t2", 11, 3),
                new Task("t3", 11, 2)
        );


        //<t1, 0, 10>, <t3, 0, 2>, <t2, 11, 3>
//        List<Task> tasks = List.of(
//                new Task("t1", 0, 10),
//                new Task("t3", 0, 2),
//                new Task("t2", 11, 3)
//        );

        List<String> order = taskOrderCoupang.findOrder(tasks);
        System.out.println(order); // Output: [t1, t3, t2]
    }

}
