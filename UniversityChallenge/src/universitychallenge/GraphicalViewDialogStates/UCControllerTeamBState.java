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
public class UCControllerTeamBState implements ControllerActiveTeamState {

    UCModel model;

    public UCControllerTeamBState(UCModel model) {
        this.model = model;
    }

    @Override
    public ButtonStates correct(int teamMember) {
        model.correctB(teamMember);
        return new ButtonStates(new ButtonInactiveState(), new ButtonInactiveState());
    }

    @Override
    public ButtonStates correctBonus(int teamMember) {
        model.correctBonusB(teamMember);
        return new ButtonStates(new ButtonInactiveState(), new ButtonInactiveState());
    }

    @Override
    public ButtonStates incorrect(int teamMember) {
        model.incorrectB(teamMember);
        return new ButtonStates(new ButtonBuzzState(), new ButtonInactiveState());
    }

    @Override
    public ButtonStates incorrectPenalty(int teamMember) {
        model.incorrectPenaltyB(teamMember);
        return new ButtonStates(new ButtonBuzzState(), new ButtonInactiveState());
    }

    @Override
    public Team getTeam() {
        return model.getTeamB();
    }

    @Override
    public ButtonStates incorrectBonus(int teamMember) {
        model.incorrectB(teamMember);
        return new ButtonStates(new ButtonInactiveState(), new ButtonInactiveState());
    }

    @Override
    public ButtonStates getBonusButtons() {
        return new ButtonStates(new ButtonInactiveState(), new ButtonBonusState());
    }

}
