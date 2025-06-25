package com.logics.jobScheduling;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom3 {
    /**
     * You are given an integer n. There are n rooms numbered from 0 to n - 1.
     *
     * You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.
     *
     * Meetings are allocated to rooms in the following manner:
     *
     * Each meeting will take place in the unused room with the lowest number.
     * If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
     * When a room becomes unused, meetings that have an earlier original start time should be given the room.
     * Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.
     *
     * A half-closed interval [a, b) is the interval between a and b including a and not including b.
     */



    class RoomOccupiedDetail{
        int roomNo;
        int endDuration;
        public RoomOccupiedDetail(int roomNo, int endDuration){
            this.roomNo = roomNo;
            this.endDuration = endDuration;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        Queue<Integer> availableRoom = new PriorityQueue<>();
        Queue<RoomOccupiedDetail> occupiedRoom = new PriorityQueue<>(
                (a,b)->{
                    if(a.endDuration==b.endDuration){
                        return a.roomNo-b.roomNo;
                    }
                    return a.endDuration-b.endDuration;
                }
        );
        int[] result = new int[n]; // room count mapping

        Arrays.sort(meetings, (int[] a, int[]b)-> a[0]-b[0]);

        for(int i=0;i<n;i++){
            availableRoom.offer(i); // add room in min heap
        }

        for(int[] meeting: meetings){
            while(!occupiedRoom.isEmpty()){
                // empty rooms whose end time less than current and make those rooms available
                if(occupiedRoom.peek().endDuration<= meeting[0]){
                    int room = occupiedRoom.peek().roomNo;
                    occupiedRoom.poll();
                    availableRoom.offer(room);
                }else{
                    break;
                }
            }

            // check if occupied room causes delay
            if(availableRoom.isEmpty()){
                // assign room with delay
                RoomOccupiedDetail rdetail = occupiedRoom.poll();
                rdetail.endDuration = rdetail.endDuration + (meeting[1]-meeting[0]); // update end duration
                occupiedRoom.offer(rdetail);
                result[rdetail.roomNo]++;
            }else if(!availableRoom.isEmpty()){
                // assign new room
                int newRoom = availableRoom.poll();
                result[newRoom]++;
                occupiedRoom.offer(new RoomOccupiedDetail(newRoom, meeting[1]));
            }
        }

        int maxRoomNo = -1;
        int maxCount = 0;
        for(int i=0;i<result.length;i++){
            if(maxCount < result[i]){
                maxRoomNo = i;
                maxCount = result[i];
            }
        }
        return maxRoomNo;

//        return Arrays.stream(result).max().isPresent()? Arrays.stream(result).max().getAsInt(): -1;
    }

    public static void main(String[] args) {
        MeetingRoom3 meetingRoom3 = new MeetingRoom3();
        int[][] meeting1 = new int[][]{{0,10},{1,5},{2,7},{3,4}};
        int n1 = 2; // number of rooms
        System.out.println("Most booked room: " + meetingRoom3.mostBooked(n1, meeting1));


        int[][] meetings = {{0,10}, {5,15}, {10,20}, {15,25}};
        int n = 2; // number of rooms
        System.out.println("Most booked room: " + meetingRoom3.mostBooked(n, meetings));

        int[][] meetings2 = {{0,5}, {1,10}, {2,7}, {3,4}};
        int n2 = 3; // number of rooms
        System.out.println("Most booked room: " + meetingRoom3.mostBooked(n2, meetings2));
    }
}
