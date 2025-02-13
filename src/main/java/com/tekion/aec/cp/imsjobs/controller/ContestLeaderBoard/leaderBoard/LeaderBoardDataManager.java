package com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.leaderBoard;

import com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.QuestionLevel;
import com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.QuestionTag;
import com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.User;
import com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.UserReportCard;
import com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models.question.QuestionV1;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author anju
 * @created on 02/08/24 and 2:26 PM
 */
public class LeaderBoardDataManager {

    private Map<String, UserReportCard> contestedUserDetail; // keep userId and its currentScore
    private Integer totalScore;
    private Set<QuestionV1> contestQuestions;
    private List<User> contestant;
    private String name;
    private Long contestDate;


    private LeaderBoardDataManager(LeaderBoardDataManagerBuilder leaderBoardDataManagerBuilder) {
        name = leaderBoardDataManagerBuilder.name;
        totalScore = leaderBoardDataManagerBuilder.totalScore;
        contestDate = leaderBoardDataManagerBuilder.contestDate;

    }

    public static class LeaderBoardDataManagerBuilder {
        private String name;
        private Integer totalScore;
        private Long contestDate;
        private List<QuestionV1> questionV1s;

        //constructor for required fields
        public LeaderBoardDataManagerBuilder(String name, Integer score, List<QuestionV1> questionV1s) {
            this.name = name;
            this.totalScore = score;
            this.contestDate = Instant.now().getEpochSecond();
            this.questionV1s = questionV1s;
        }


        //Build the Employee object
        public LeaderBoardDataManager build() {
            return new LeaderBoardDataManager(this);
        }
    }



    public void setTotalScore(Integer score){
        this.totalScore = score;
    }

    public void setName(String name){
        this.name = name;
    }


    public void contestDate(){
        this.contestDate = Instant.now().getEpochSecond();
    }




    public List<QuestionV1> filterQuestion(QuestionLevel level){
        return this.contestQuestions.stream().filter(ques -> ques.getQuestionLevel() == level).collect(Collectors.toList());
    }

    public List<QuestionV1> filterQuestion(QuestionTag tag){
        return this.contestQuestions.stream().filter(ques -> ques.getQuestionTag() == tag).collect(Collectors.toList());
    }

    public List<QuestionV1> filterQuestion(Integer score){
        return this.contestQuestions.stream().filter(ques -> ques.getQuestionScore() == score).collect(Collectors.toList());
    }


    public void addQuestion(QuestionV1 questionV1){
        if(null == contestQuestions){
            this.contestQuestions = new HashSet<>();
        }
        contestQuestions.add(questionV1);
    }

    public void addContestant(User user) throws Exception {

        if(null== contestant){
            this.contestant = new ArrayList<>();
        }
        contestant.add(user);

        if(null== contestedUserDetail){
            contestedUserDetail = new HashMap<>();
        }
        UserReportCard userReportCard = new UserReportCard();

        // get all contest questionsIds
        if(null == contestQuestions){
            throw new Exception("Questions should be preset in contest, before user joins");
        }
        Set<String> questionIds = contestQuestions.stream().map(questionV1 -> questionV1.getQuestionId()).collect(Collectors.toSet());

        // add contestant
        contestedUserDetail.put(user.getName(), userReportCard.initUserReportCard(questionIds, user.getName()));
    }

    public void submitQuestion(User user, String questionId, Boolean complete){
        try{
            UserReportCard userReportCard = contestedUserDetail.get(user.getName());
            userReportCard.getUserCurrentDetail().put(questionId, complete);
        }catch (NullPointerException e){
            System.out.println("Failed to submit question, questionId or userName invalid");
        }
    }


    public void fetchWinner(){
        try{
            int max = Integer.MIN_VALUE;
            String winnerName = "No Winner";
            for(Map.Entry<String, UserReportCard> userUserReportCardMap :contestedUserDetail.entrySet()){
                String userName = userUserReportCardMap.getKey();
                Integer userScore = 0;
                for (String questionId: userUserReportCardMap.getValue().getUserCurrentDetail().keySet()) {
                   if(userUserReportCardMap.getValue().getUserCurrentDetail().get(questionId)){
                       userScore = userScore + getQuestionScore(questionId);
                   }
                }

                if(max < userScore){
                    winnerName = userName;
                    max = userScore;
                }
            }
            System.out.println("And the winner is "+ winnerName);
        }catch (NullPointerException e){
            System.out.println("Failed to submit question, questionId or userName invalid");
        }
    }

    private Integer getQuestionScore(String questionId){
            try {
                return contestQuestions.stream()
                        .filter(questionV1 -> questionV1.getQuestionId().equals(questionId))
                        .map(questionV1 -> questionV1.getQuestionScore()).findFirst().get();
            }catch (Exception e){
                System.out.println("Failed to fetch question details");
                throw e;
            }
    }


}
