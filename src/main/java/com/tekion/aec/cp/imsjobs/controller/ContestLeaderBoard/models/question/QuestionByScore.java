package com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.question;

import com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.QuestionLevel;

/**
 * @author anju
 * @created on 02/08/24 and 2:34 PM
 */
public interface QuestionByScore {
    public void addQuestionScore(Integer score);
    public Integer getQuestionScore();

}
