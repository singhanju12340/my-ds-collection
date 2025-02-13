package com.logics.ContestLeaderBoard;

import com.logics.ContestLeaderBoard.leaderBoard.LeaderBoardDataManager;
import com.logics.ContestLeaderBoard.models.question.QuestionV1;
import com.logics.ContestLeaderBoard.models.QuestionLevel;
import com.logics.ContestLeaderBoard.models.QuestionTag;
import com.logics.ContestLeaderBoard.models.User;
import com.logics.ContestLeaderBoard.models.UserDepartment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 02/08/24 and 3:29 PM
 */
public class ContestMain {

    public static void main(String[] args) throws Exception {

        // add list of question for given user board
        List<QuestionV1> questions = createQuestionList();



        // create list of users
        User anju = new User("anju", UserDepartment.CONSUMER);
        User manju = new User("manju", UserDepartment.UI);
        User sanju = new User("sanju", UserDepartment.INTEGRATION);


        LeaderBoardDataManager leaderBoardDataManager = new LeaderBoardDataManager.
                LeaderBoardDataManagerBuilder("PayKaro Contest", 100, questions).build();

        leaderBoardDataManager.addContestant(anju);
        leaderBoardDataManager.addContestant(manju);
        leaderBoardDataManager.addContestant(sanju);

        // fetch all linked list questions
        System.out.println(leaderBoardDataManager.filterQuestion(QuestionTag.LINKED_LIST));

        // fetch all questions with score 10
        System.out.println(leaderBoardDataManager.filterQuestion(10));

        //sumit question by user
        leaderBoardDataManager.submitQuestion(manju, questions.get(2).getQuestionId(), true);

        //show user leader board
        leaderBoardDataManager.fetchWinner();

    }


    private static List<QuestionV1> createQuestionList(){
        List<QuestionV1> questions = new ArrayList<>();
        QuestionV1 q1 = new QuestionV1("Question1", "sort given array", "1");
        q1.addQuestionLevel(QuestionLevel.EASY);
        q1.addQuestionScore(10);
        q1.addTagToQuestion(QuestionTag.ARRAY);

        QuestionV1 q2 = new QuestionV1("Question2", "reverse linklist array", "2");
        q2.addQuestionLevel(QuestionLevel.MEDIUM);
        q2.addQuestionScore(20);
        q2.addTagToQuestion(QuestionTag.LINKED_LIST);


        QuestionV1 q3 = new QuestionV1("Question3", "Empty stack", "3");
        q3.addQuestionLevel(QuestionLevel.MEDIUM);
        q3.addQuestionScore(20);
        q3.addTagToQuestion(QuestionTag.STACK);

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        return questions;
    }


}
