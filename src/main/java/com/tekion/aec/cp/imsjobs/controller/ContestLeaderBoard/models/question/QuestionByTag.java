package com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.question;

import com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.QuestionTag;

/**
 * @author anju
 * @created on 02/08/24 and 2:34 PM
 */
public interface QuestionByTag {
    public void addTagToQuestion(QuestionTag tag);
    QuestionTag getQuestionTag();
}
