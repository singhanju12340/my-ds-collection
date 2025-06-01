package com.logics.jobScheduling;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2_253 {
    /**
     * find the minimum number of conference rooms required to accommodate a given set of meeting
     * time intervals. Each meeting is represented by a start time and an end time.
     *
     */

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort the meetings by start time
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));


        PriorityQueue<Integer> endTimes = new java.util.PriorityQueue<>();
        endTimes.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If the meeting starts after the earliest ending meeting, we can reuse that room
            if (intervals[i][0] >= endTimes.peek()) {
                endTimes.poll();
            }
            // Add the current meeting's end time to the queue
            endTimes.offer(intervals[i][1]);
        }

        // The size of the priority queue is the number of rooms required
        return endTimes.size();
    }

    public static void main(String[] args) {
        MeetingRoom2_253 meetingRoom2 = new MeetingRoom2_253();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Minimum number of meeting rooms required: " + meetingRoom2.minMeetingRooms(intervals));

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Minimum number of meeting rooms required: " + meetingRoom2.minMeetingRooms(intervals2));
    }
}
