package com.logics.ContestLeaderBoard.models.question;

import com.logics.ContestLeaderBoard.models.QuestionTag;

/**
 * @author anju
 * @created on 02/08/24 and 2:34 PM
 */
public interface QuestionByTag {
    public void addTagToQuestion(QuestionTag tag);
    QuestionTag getQuestionTag();
}
