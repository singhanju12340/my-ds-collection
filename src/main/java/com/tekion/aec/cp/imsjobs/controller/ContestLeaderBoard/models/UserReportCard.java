package com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models;

import com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.question.QuestionV1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author anju
 * @created on 02/08/24 and 2:49 PM
 */
public class UserReportCard {
    Map<String, Boolean>  userCurrentDetail;
    String userId;



    public UserReportCard initUserReportCard(Set<String> questionIds, String userId){
        if(userCurrentDetail == null)
            this.userCurrentDetail = new HashMap<>();
        for (String questionId:questionIds) {
            this.userCurrentDetail.put(questionId, false);
        }
        this.userId = userId;

        return this;
    }

    public Map<String, Boolean> getUserCurrentDetail() {
        return userCurrentDetail;
    }

    public void setUserCurrentDetail(Map<String, Boolean> userCurrentDetail) {
        this.userCurrentDetail = userCurrentDetail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
