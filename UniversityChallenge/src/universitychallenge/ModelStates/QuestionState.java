/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge.ModelStates;

import universitychallenge.ButtonStates.ButtonStates;
import universitychallenge.Team;
import universitychallenge.GraphicalViewDialogStates.ControllerActiveTeamState;

/**
 *
 * @author Edward
 */
public interface QuestionState {

    public abstract String nextQuestion();

    public ButtonStates correct(int teamMember);

    public ButtonStates incorrect(int teamMember);

    public ButtonStates incorrectPenalty(int teamMember);

    public void setActiveTeam(ControllerActiveTeamState team);
                  
    public abstract QuestionState changeState();

    public Team getTeam();
    
    public ButtonStates getButtonsState();

}
