package com.logics.jobScheduling;

import java.util.Arrays;

public class MeetingRoomIfPersoncanAttendAllMeeting {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
     * determine if a person could attend all meetings.
     *
     *
     *
     * @param intervals
     * @return true if a person can attend all meetings, false otherwise
     *
     * Input: [[0,30],[5,10],[15,20]]
     * Output: false
     */

    public boolean canAttendMeeting(int[][] intervals){
        Arrays.sort(intervals, (int[] a, int[]b)-> a[0]-b[0]);
        for(int i=1;i<intervals.length-1;i++){
            if(intervals[i-1][1] > intervals[i][0] ){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRoomIfPersoncanAttendAllMeeting meetingRoomIfPersoncanAttendAllMeeting = new MeetingRoomIfPersoncanAttendAllMeeting();
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println("Can attend all meetings: " + meetingRoomIfPersoncanAttendAllMeeting.canAttendMeeting(intervals));

        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println("Can attend all meetings: " + meetingRoomIfPersoncanAttendAllMeeting.canAttendMeeting(intervals2));
    }
}
