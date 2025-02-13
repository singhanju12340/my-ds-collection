package com.logics.ContestLeaderBoard.models.question;

import com.logics.ContestLeaderBoard.models.QuestionLevel;
import com.logics.ContestLeaderBoard.models.QuestionTag;

/**
 * @author anju
 * @created on 02/08/24 and 2:43 PM
 */
public class QuestionV1 extends Question implements QuestionByLevel, QuestionByScore, QuestionByTag {
    private QuestionLevel level;
    private Integer score;
    private QuestionTag tag;

    public QuestionV1(String name, String description, String questionId) {
        super(name, description, questionId);
    }

    @Override
    public void addQuestionLevel(QuestionLevel level) {
        this.level = level;
    }

    @Override
    public QuestionLevel getQuestionLevel() {
        return this.level;
    }

    @Override
    public void addQuestionScore(Integer score) {
        this.score = score;
    }

    @Override
    public Integer getQuestionScore() {
        return this.score;
    }

    @Override
    public void addTagToQuestion(QuestionTag tag) {
        this.tag = tag;
    }

    @Override
    public QuestionTag getQuestionTag() {
        return this.tag;
    }


    @Override
    public String toString() {
        return "QuestionV1{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                ", score=" + score +
                ", tag=" + tag +
                '}';
    }


}
