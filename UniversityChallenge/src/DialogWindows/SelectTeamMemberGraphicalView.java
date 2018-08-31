/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DialogWindows;

import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import universitychallenge.UCController;
import universitychallenge.UCModel;

/**
 *
 * @author Edward
 */
public class SelectTeamMemberGraphicalView extends Stage implements Observer {

    UCModel model;
    private UCController controller;
    Button[] players = new Button[4];

    public SelectTeamMemberGraphicalView( UCController controller,UCModel model) {
        this.controller = controller;
        this.model = model;
        model.addObserver(this);
        Button temp;
        HBox root = new HBox();
        for (int i = 0; i < 4; i++) {
            temp = new Button(controller.getTeam().getPlayer(i).getName());
            int index = i;
            temp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage = setDialogType(controller, model, index);
                    close();
                }
            });
            players[i] = temp;
            root.getChildren().add(temp);
        }
        setScene(new Scene(root));
        setTitle("Select player");
        update(null, null);
        show();
    }
    
    public Stage setDialogType(UCController contoller, UCModel model,int index){
        return new UpdatePointDialogWindow(contoller, model, index);
    }

    @Override
    public void update(Observable o, Object o1) {

    }

}
