package com.logics.ContestLeaderBoard.models.question;

/**
 * @author anju
 * @created on 02/08/24 and 2:22 PM
 */
public class Question {
    String name;
    String description;
    private String questionId;

    public Question(String name, String description, String questionId) {
        this.name = name;
        this.description = description;
        this.questionId = questionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Only getter is allowed, once question is created id will not change
    public String getQuestionId() {
        return questionId;
    }
}
