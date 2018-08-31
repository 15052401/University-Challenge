/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DialogWindows;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import universitychallenge.UCModel;
import universitychallenge.UCController;


/**
 *
 * @author Edward
 */
public class UpdatePointDialogWindow extends UpdatePointDialogWindowPenalty {

    public UpdatePointDialogWindow(UCController contoller, UCModel model, int teamMember) {
        super(contoller, model, teamMember);
    }

    @Override
    public HBox addIncorrectPenalty(Button correct, Button incorrect) {
        return new HBox(correct, incorrect);
    }

}
