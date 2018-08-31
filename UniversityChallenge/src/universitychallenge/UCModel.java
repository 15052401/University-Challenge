/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge;

import java.util.Observable;

/**
 *
 * @author Edward
 */
public class UCModel extends Observable {

    private static Team teamA;
    private static Team teamB;
    private static Questions questions;

    public UCModel() {
        teamA = new Team("A");
        teamB = new Team("B");
        questions = new Questions();
        initialise();
    }

    /**
     * @pre. questions is not null
     */
    public String nextQuestion() {
        assert questions != null : "Questions must not be null";
        return questions.nextQuestion();
    }

    /**
     * @pre. questions is not null
     */
    public String nextBonusQuestion() {
        assert questions != null : "Questions must not be null";
        return questions.nextBonus();
    }

    /**
     * @pre. teamA is not null and the teamMeber is in the valid range of 0-3
     * @post. teamA player at index teamMember has their tally of correct
     * answers incremented by 1
     */
    public void correctA(int teamMember) {
        assert teamA != null && teamA.getPlayer(teamMember) != null : "teamA or the the target player must not be null";
        assert teamMember <= 3 && teamMember >= 0 : "Invalid team member index, must be in the range 0<= index <=3";
        int score = teamA.getPlayer(teamMember).getScore();

        teamA.getPlayer(teamMember).correct();

        assert teamA.getPlayer(teamMember).getScore() == score + 10;
    }

    /**
     * @pre. teamB is not null and the teamMeber is in the valid range of 0-3
     * @post. teamB player at index teamMember has their tally of correct
     * answers incremented by 1
     */
    public void correctB(int teamMember) {
        assert teamB != null : "teamB must not be null";
        assert teamMember <= 3 && teamMember >= 0 : "Invalid team member index, must be in the range 0<= index <=3";
        int score = teamB.getPlayer(teamMember).getScore();

        teamB.getPlayer(teamMember).correct();

        assert teamB.getPlayer(teamMember).getScore() == score + 10;
    }

    /**
     * @pre. teamA is not null and the teamMeber is in the valid value of 1
     * @post. teamA player at index teamMember has their tally of correct
     * answers incremented by 1
     */
    public void correctBonusA(int teamMember) {
        assert teamA != null : "teamA must not be null";
        assert teamMember == 0 : "Invalid team member for correct bonus question answer";
        int score = teamA.getPlayer(teamMember).getScore();
        
        teamA.getPlayer(0).correctBonus();
        
        assert teamA.getPlayer(teamMember).getScore() == score + 5;
    }

    /**
     * @pre. teamB is not null and the teamMeber is in the valid value of 1
     * @post. teamB player at index teamMember has their tally of correct
     * answers incremented by 1
     */
    public void correctBonusB(int teamMember) {
        assert teamB != null : "teamB must not be null";
        assert teamMember == 0 : "Invalid team member for correct bonus question answer";
        int score = teamB.getPlayer(teamMember).getScore();
        
        teamB.getPlayer(0).correctBonus();
        
        assert teamB.getPlayer(teamMember).getScore() == score + 5;
    }

    /**
     * @pre. teamA is not null and the teamMeber is in the valid range of 0-3
     * @post. teamA player at index teamMember has their tally of incorrect
     * answers incremented by 1 and the score is unchanged 
     */
    public void incorrectA(int teamMember) {
        assert teamA != null : "teamA must not be null";
        assert teamMember <= 3 && teamMember >= 0 : "Invalid team member index, must be in the range 0<= index <=3";
        int score = teamA.getPlayer(teamMember).getScore();
        
        teamA.getPlayer(teamMember).incorrect();
        
        assert teamA.getPlayer(teamMember).getScore() == score;
    }

    /**
     * @pre. teamB is not null and the teamMeber is in the valid range of 0-3
     * @post. teamB player at index teamMember has their tally of incorrect
     * answers incremented by 1 and the score is unchanged 
     */
    public void incorrectB(int teamMember) {
        assert teamB != null : "teamB must not be null";
        assert teamMember <= 3 && teamMember >= 0 : "Invalid team member index, must be in the range 0<= index <=3";
        int score = teamB.getPlayer(teamMember).getScore();
        
        teamB.getPlayer(teamMember).incorrect();
        
        assert teamB.getPlayer(teamMember).getScore() == score;
    }

    /**
     * @pre. teamA is not null and the teamMeber is in the valid range of 0-3
     * @post. teamA player at index teamMember has their tally of
     * incorrectPenalty answers incremented by 1 
     */
    public void incorrectPenaltyA(int teamMember) {
        assert teamA != null : "teamA must not be null";
        assert teamMember <= 3 && teamMember >= 0 : "Invalid team member index, must be in the range 0<= index <=3";
        int score = teamA.getPlayer(teamMember).getScore();

        teamA.getPlayer(teamMember).incorrectPenalty();

        assert teamA.getPlayer(teamMember).getScore() == score - 5;
    }

    /**
     * @pre. teamB is not null and the teamMeber is in the valid range of 0-3
     * @post. teamB player at index teamMember has their tally of
     * incorrectPenalty answers incremented by 1
     */
    public void incorrectPenaltyB(int teamMember) {
        assert teamB != null : "teamB must not be null";
        assert teamMember <= 3 && teamMember >= 0 : "Invalid team member index, must be in the range 0<= index <=3";
        int score = teamB.getPlayer(teamMember).getScore();

        teamB.getPlayer(teamMember).incorrectPenalty();

        assert teamB.getPlayer(teamMember).getScore() == score - 5;
    }

    /**
     * @pre. teamA is not null
     */
    public Team getTeamA() {
        assert teamA != null : "teamA must not be null";
        return teamA;
    }

    /**
     * @pre. teamB is not null
     */
    public Team getTeamB() {
        assert teamB != null : "teamB must not be null";
        return teamB;
    }

    public void initialise() {
        setChanged();
        notifyObservers();
    }

}
