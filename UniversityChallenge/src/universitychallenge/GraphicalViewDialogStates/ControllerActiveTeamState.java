/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge.GraphicalViewDialogStates;

import universitychallenge.ButtonStates.ButtonStates;
import universitychallenge.Team;

/**
 *
 * @author Edward
 */
public interface ControllerActiveTeamState {
            
    public ButtonStates correct(int teamMember);
    
    public ButtonStates correctBonus(int teamMember);

    public ButtonStates incorrect(int teamMember);
    
    public ButtonStates incorrectBonus(int teamMember);

    public ButtonStates incorrectPenalty(int teamMember);
    
    public Team getTeam();

    public ButtonStates getBonusButtons();
    

}
