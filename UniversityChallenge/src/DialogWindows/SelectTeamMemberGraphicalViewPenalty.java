/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DialogWindows;

import javafx.stage.Stage;
import universitychallenge.UCModel;
import universitychallenge.UCController;

/**
 *
 * @author Edward
 */
public class SelectTeamMemberGraphicalViewPenalty extends SelectTeamMemberGraphicalView{
    
    public SelectTeamMemberGraphicalViewPenalty(UCController contoller, UCModel model) {
        super(contoller, model);
    }
    
    @Override
    public Stage setDialogType(UCController contoller, UCModel model,int index){
        return new UpdatePointDialogWindowPenalty(contoller, model, index);
        
    }
    
}
