package com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models;

/**
 * @author anju
 * @created on 05/08/24 and 12:20 PM
 */
public class LeaderBoard {
    private String name;
    private Long contestDate;
    private Integer totalScore;

    public LeaderBoard(String name, Long contestDate, Integer totalScore) {
        this.name = name;
        this.contestDate = contestDate;
        this.totalScore = totalScore;
    }
}
