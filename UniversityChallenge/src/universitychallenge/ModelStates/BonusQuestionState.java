/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge.ModelStates;

import universitychallenge.ButtonStates.ButtonStates;
import universitychallenge.ButtonStates.UCButtonState;
import universitychallenge.Team;
import universitychallenge.UCModel;
import universitychallenge.GraphicalViewDialogStates.ControllerActiveTeamState;

/**
 *
 * @author Edward
 */
public class BonusQuestionState implements QuestionState {

    private UCModel model;
    private int count;
    private ControllerActiveTeamState activeTeam;

    UCButtonState teamAButtonState;
    UCButtonState teamBButtonState;

    public BonusQuestionState(UCModel model, int count) {
        this.count = count;
        this.model = model;
    }

    @Override
    public ButtonStates incorrect(int teamMember) {
        return activeTeam.incorrectBonus(teamMember);
    }

    @Override
    public ButtonStates incorrectPenalty(int teamMember) {
        return activeTeam.incorrectPenalty(teamMember);
    }

    @Override
    public void setActiveTeam(ControllerActiveTeamState team) {
        activeTeam = team;
    }

    @Override
    public String nextQuestion() {
        return model.nextBonusQuestion();
    }

    @Override
    public ButtonStates correct(int teamMember) {
        return activeTeam.correctBonus(teamMember);
    }

    @Override
    public QuestionState changeState() {
        count++;
        QuestionState newState = new BonusQuestionState(model, count);
        newState.setActiveTeam(activeTeam);
        if (count == 3) {
            newState = new StarterQuestion(model);
        }
        return newState;
    }

    @Override
    public Team getTeam() {
        return activeTeam.getTeam();
    }

    @Override
    public ButtonStates getButtonsState() {
        return activeTeam.getBonusButtons();
    }
}
