package com.tekion.aec.cp.imsjobs.controller.bhiyaniMathProblems;

/**
 * @author anju
 * @created on 25/01/25 and 10:24 AM
 */
public class SocialNetworkNetworkCrunch {

    /***
     * https://arpitbhayani.me/math/4
     * You’re working on an experimental social network feature at Meta that tracks “friend clusters” - groups of friends who frequently interact together. For a test dataset of varying number of users, you need to analyze group interactions.
     *
     * The data is stored as follows: whenever users interact in a group (through group chat, group video calls, or group tags), you record a score of 1 for each pair of users in that group for that day. For example, if users A, B, and C have a group video call, you record interactions (A,B), (B,C), and (A,C).
     *
     * After collecting 30 days of data, you notice that your server’s memory usage is extremely high. Upon investigation, you find that most users interact with less than 50 other users per month, despite having hundreds of friends.
     *
     * Your task is to:
     *
     * Design an efficient data structure to store this interaction data
     * Write a function that can quickly find the top 3 users who interact most frequently with a given user
     * Estimate the memory usage of your solution for different number of users (as given below)
     * Compare your solution’s memory usage with a simple naive approach
     * Consider both time and space complexity in your solution, as this will be deployed in production. Inputs for which the approach should be compared against a simple one are
     *
     * (10000, 5000, 5)
     * (10000, 5000, 5)
     * (10000, 5000, 10)
     * (100000, 50000, 5)
     * (100000, 50000, 10)
     * (100000, 100000, 10)
     * Each of the above tuple is (n_users, n_groups, group_size) where
     *
     * n_users: The total number of users in the social network. For example, 1000 means there are 1000 unique users who could potentially interact.
     * n_groups: The number of group interactions that will be simulated. For example, 500 means there will be 500 different group gatherings/interactions. Each group interaction creates multiple pair-wise connections between its members
     * group_size: Number of people in each group interaction. For example, 5 means each group activity involves 5 people. For each group of size 5, we create (5 * 4) / 2 = 10 pair-wise interactions
     * Use this information to generate random data, build an efficient solution, and measure the efficiency and trade-offs.
     */


}
