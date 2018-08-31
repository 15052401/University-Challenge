/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge.GraphicalViewDialogStates;

import universitychallenge.ButtonStates.ButtonBonusState;
import universitychallenge.ButtonStates.ButtonBuzzState;
import universitychallenge.ButtonStates.ButtonInactiveState;
import universitychallenge.ButtonStates.ButtonStates;
import universitychallenge.Team;
import universitychallenge.UCModel;

/**
 *
 * @author Edward
 */
public class UCControllerTeamAState implements ControllerActiveTeamState {

    UCModel model;

    public UCControllerTeamAState(UCModel model) {
        this.model = model;
    }

    @Override
    public ButtonStates correct(int teamMember) {
        model.correctA(teamMember);
        return new ButtonStates(new ButtonInactiveState(), new ButtonInactiveState());
    }

    @Override
    public ButtonStates incorrect(int teamMember) {
        model.incorrectA(teamMember);
        return new ButtonStates(new ButtonInactiveState(),new ButtonBuzzState());
    }

    @Override
    public ButtonStates incorrectPenalty(int teamMember) {
        model.incorrectPenaltyA(teamMember);
        return new ButtonStates(new ButtonInactiveState(),new ButtonBuzzState());
    }

    @Override
    public Team getTeam() {
        return model.getTeamA();
    }

    @Override
    public ButtonStates correctBonus(int teamMember) {
        model.correctBonusA(teamMember);
        return new ButtonStates(new ButtonInactiveState(),new ButtonInactiveState());
    }

    @Override
    public ButtonStates incorrectBonus(int teamMember) {
        model.incorrectA(teamMember);
        return new ButtonStates(new ButtonInactiveState(),new ButtonInactiveState());
    }

    @Override
    public ButtonStates getBonusButtons() {
        return new ButtonStates(new ButtonBonusState(),new ButtonInactiveState());
    }

}
