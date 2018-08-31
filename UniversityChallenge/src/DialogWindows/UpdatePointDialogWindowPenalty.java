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
import universitychallenge.UCModel;
import universitychallenge.UCController;

/**
 *
 * @author Edward
 */
public class UpdatePointDialogWindowPenalty extends Stage implements Observer {

    private UCModel model;
    private UCController controller;
    int teamMember;

    public UpdatePointDialogWindowPenalty(UCController controller, UCModel model, int teamMember) {
        HBox root;
        this.controller = controller;
        this.teamMember = teamMember;
        model.addObserver(this);
        Button correct = new Button("Correct");
        Button incorrect = new Button("Incorrect");

        correct.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.correct(teamMember);
                close();
            }
        });
        incorrect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.incorrect(teamMember);
                close();
            }
        });
        root = addIncorrectPenalty(correct,incorrect);
        setScene(new Scene(root));
        setTitle("Select outcome");
        update(null, null);
        show();
    }

    public HBox addIncorrectPenalty(Button correct,Button incorrect) {
        Button incorrectPenalty = new Button("Incorrect penalty");
        incorrectPenalty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.incorrectPenalty(teamMember);
                close();
            }
        });
        return new HBox(correct, incorrect, incorrectPenalty);
    }

    @Override
    public void update(Observable o, Object o1) {

    }

}