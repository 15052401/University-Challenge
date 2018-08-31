/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge.ModelStates;
import universitychallenge.ButtonStates.ButtonBuzzState;
import universitychallenge.ButtonStates.ButtonInactiveState;
import universitychallenge.ButtonStates.ButtonStates;
import universitychallenge.Team;
import universitychallenge.UCModel;
import universitychallenge.GraphicalViewDialogStates.ControllerActiveTeamState;

/**
 *
 * @author Edward
 */
public class StarterQuestion implements QuestionState {

    private UCModel model;
    private ControllerActiveTeamState activeTeam;
    private boolean bonusRound;
    private int count;

    public StarterQuestion(UCModel model) {
        this.model = model;
        bonusRound = false;
        count = 0;
    }

    @Override
    public ButtonStates correct(int teamMember) {
        bonusRound = true;
        return activeTeam.correct(teamMember);
    }

    @Override
    public ButtonStates incorrect(int teamMember) {
        count++;
        ButtonStates newStates = activeTeam.incorrect(teamMember);
        if (count == 2) {
            newStates = new ButtonStates(new ButtonInactiveState(),new ButtonInactiveState());
        }
        return newStates;
    }

    @Override
    public ButtonStates incorrectPenalty(int teamMember) {
        count++;
        ButtonStates newStates = activeTeam.incorrectPenalty(teamMember);
        if (count == 2) {
            newStates = new ButtonStates(new ButtonInactiveState(),new ButtonInactiveState());
        }
        return newStates;
    }

    @Override
    public void setActiveTeam(ControllerActiveTeamState team) {
        activeTeam = team;
    }

    @Override
    public String nextQuestion() {
        return model.nextQuestion();
    }

    @Override
    public QuestionState changeState() {
        QuestionState nextState = new StarterQuestion(model);
        if (bonusRound) {
            nextState = new BonusQuestionState(model, 0);
            nextState.setActiveTeam(activeTeam);
        }
        return nextState;
    }

    @Override
    public Team getTeam() {
        return activeTeam.getTeam();
    }

    @Override
    public ButtonStates getButtonsState() {
        return new ButtonStates(new ButtonBuzzState(), new ButtonBuzzState());
    }

}
