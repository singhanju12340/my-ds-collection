package com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.question;

import com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.QuestionLevel;

/**
 * @author anju
 * @created on 02/08/24 and 2:32 PM
 */
public interface QuestionByLevel {
        public void addQuestionLevel(QuestionLevel level);
        public QuestionLevel getQuestionLevel();

}
