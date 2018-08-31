/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge;

import DialogWindows.SelectTeamMemberGraphicalView;
import DialogWindows.SelectTeamMemberGraphicalViewPenalty;
import DialogWindows.UpdatePointDialogWindow;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 15052401
 */
public class UniversityChallenge extends Application implements Observer, ChangeButtons {

    private UCModel model;
    private UCController controller;

    boolean initalised = false;

    final static private Label[] teamACorrect = new Label[4];
    final static private Label[] teamAIncorrect = new Label[4];
    final static private Label[] teamAScores = new Label[4];
    final static private TextField[] teamANames = new TextField[4];
    final static private TextField teamAName = new TextField();
    final static private Label teamAScore = new Label();

    final static private Label[] teamBCorrect = new Label[4];
    final static private Label[] teamBIncorrect = new Label[4];
    final static private Label[] teamBScores = new Label[4];
    final static private TextField[] teamBNames = new TextField[4];
    final static private TextField teamBName = new TextField();
    final static private Label teamBScore = new Label();

    final static private TextField Tournament = new TextField("Tournament");
    final static private TextField round = new TextField("round");

    final static private TextField reader = new TextField("reader");
    final static private TextField room = new TextField("room");

    final static private Button buzzA = new Button();
    final static private Button bonusA = new Button();

    final static private Button buzzB = new Button();
    final static private Button bonusB = new Button();

    final static private Button nextQuestion = new Button();
    final static private TextArea questionDisplay = new TextArea();
    final static private String instructions = "Enter game information and then click the next question button below to start the game";

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) {
        model = new UCModel();
        controller = new UCController(model);
        controller.setView(this);

        VBox root = new VBox(3);
        root.getChildren().add(createInfoPane());
        questionDisplay.setEditable(false);
        questionDisplay.setWrapText(true);
        questionDisplay.setPrefSize(WINDOW_WIDTH, 200);
        questionDisplay.setText(instructions);
        root.getChildren().add(questionDisplay);
        root.getChildren().add(createButtons());
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setTitle("University Challenge");
        primaryStage.setScene(scene);
        primaryStage.show();
        model.addObserver(this);
    }

    public HBox createButtons() {
        HBox buttons = new HBox(2);
        VBox left = new VBox(2);

        buzzA.setText("Buzz!");
        buzzA.setPrefWidth(WINDOW_WIDTH / 2);
        buzzA.setDisable(true);
        buzzA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.setAActiveTeam();
                if (buzzB.isDisable()) {
                    Stage stage = new SelectTeamMemberGraphicalView(controller, model);
                } else {
                    Stage stage = new SelectTeamMemberGraphicalViewPenalty(controller, model);
                }
                update(null, null);
            }
        });
        left.getChildren().add(buzzA);

        bonusA.setText("+ Bonus");
        bonusA.setPrefWidth(WINDOW_WIDTH / 2);
        bonusA.setDisable(true);
        bonusA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.setAActiveTeam();
                Stage stage = new UpdatePointDialogWindow(controller, model, 0);
                update(null, null);
            }
        });
        left.getChildren().add(bonusA);

        VBox right = new VBox(3);
        buzzB.setText("Buzz!");
        buzzB.setPrefWidth(WINDOW_WIDTH / 2);
        buzzB.setDisable(true);
        buzzB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.setBActiveTeam();
                if (buzzA.isDisable()) {
                    Stage stage = new SelectTeamMemberGraphicalView(controller, model);
                } else {
                    Stage stage = new SelectTeamMemberGraphicalViewPenalty(controller, model);
                }
                update(null, null);
            }
        });
        right.getChildren().add(buzzB);

        bonusB.setText("+ Bonus");
        bonusB.setPrefWidth(WINDOW_WIDTH / 2);
        bonusB.setDisable(true);
        bonusB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.setBActiveTeam();
                Stage stage = new UpdatePointDialogWindow(controller, model, 0);
                update(null, null);
            }
        });
        right.getChildren().add(bonusB);

        nextQuestion.setText(">");
        nextQuestion.setPrefWidth(WINDOW_WIDTH / 2);
        nextQuestion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!initalised) {
                    initialise();
                }
                questionDisplay.setText(controller.nextQuestion());
                update(null, null);
            }
        });
        right.getChildren().add(nextQuestion);

        buttons.getChildren().add(left);
        buttons.getChildren().add(right);

        return buttons;
    }

    public HBox createInfoPane() {
        HBox playerInfo = new HBox(4);
        playerInfo.setSpacing(10);
        playerInfo.setAlignment(Pos.CENTER);

        VBox roundInfo = new VBox();
        roundInfo.getChildren().add(Tournament);
        roundInfo.getChildren().add(round);
        playerInfo.getChildren().add(roundInfo);

        playerInfo.getChildren().add(createTeamInfo(teamANames, teamACorrect, teamAIncorrect, teamAScores, teamAName, teamAScore));

        playerInfo.getChildren().add(createTeamInfo(teamBNames, teamBCorrect, teamBIncorrect, teamBScores, teamBName, teamBScore));

        VBox roomInfo = new VBox();
        roomInfo.getChildren().add(room);
        roomInfo.getChildren().add(reader);
        playerInfo.getChildren().add(roomInfo);

        return playerInfo;
    }

    public VBox createTeamInfo(TextField[] textFields, Label[] correct, Label[] incorrect, Label[] score, TextField teamName, Label teamTotalScore) {
        VBox teamPlayers = new VBox();
        HBox row = new HBox(4);
        row.setSpacing(6);
        teamName.setText("Team name");
        row.getChildren().add(teamName);
        row.getChildren().add(new Label("+10"));
        row.getChildren().add(new Label("-5"));
        teamTotalScore.setText("0");
        row.getChildren().add(teamTotalScore);
        teamPlayers.getChildren().add(row);

        for (int i = 0; i < 4; i++) {
            row = new HBox(4);
            row.setSpacing(13);
            String player = "Player " + (i + 1);
            textFields[i] = new TextField(player);
            row.getChildren().add(textFields[i]);

            correct[i] = new Label("0");
            row.getChildren().add(correct[i]);

            incorrect[i] = new Label("0");
            row.getChildren().add(incorrect[i]);

            score[i] = new Label("0");
            row.getChildren().add(score[i]);
            teamPlayers.getChildren().add(row);
        }
        return teamPlayers;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void update(Observable o, Object arg) {
        updateScores();
    }

    private void updateScores() {
        for (int i = 0; i < 4; i++) {
            teamACorrect[i].setText(Integer.toString(model.getTeamA().getPlayer(i).getCorrect()));
            teamBCorrect[i].setText(Integer.toString(model.getTeamB().getPlayer(i).getCorrect()));
            teamAIncorrect[i].setText(Integer.toString(model.getTeamA().getPlayer(i).getIncorrect()));
            teamBIncorrect[i].setText(Integer.toString(model.getTeamB().getPlayer(i).getIncorrect()));
            teamAScores[i].setText(Integer.toString(model.getTeamA().getPlayer(i).getScore()));
            teamBScores[i].setText(Integer.toString(model.getTeamB().getPlayer(i).getScore()));
        }
        teamAScore.setText(Integer.toString(model.getTeamA().getTeamScore()));
        teamBScore.setText(Integer.toString(model.getTeamB().getTeamScore()));

    }

    private void initialise() {
        if (!initalised) {
            for (int i = 0; i < 4; i++) {
                model.getTeamA().addPlayer(teamANames[i].getText());
                model.getTeamB().addPlayer(teamBNames[i].getText());
                teamBNames[i].setEditable(false);
                teamANames[i].setEditable(false);
            }
            teamAName.setEditable(false);
            teamBName.setEditable(false);
            room.setEditable(false);
            reader.setEditable(false);
            round.setEditable(false);
            Tournament.setEditable(false);
            initalised = true;
        }
    }

    @Override
    public void setBuzzA(boolean isActive) {
        buzzA.setDisable(isActive);
    }

    @Override
    public void setBuzzB(boolean isActive) {
        buzzB.setDisable(isActive);
    }

    @Override
    public void setBonusA(boolean isActive) {
        bonusA.setDisable(isActive);
    }

    @Override
    public void setBonusB(boolean isActive) {
        bonusB.setDisable(isActive);
    }

    @Override
    public void setNextQuestion(boolean isActive) {
        nextQuestion.setDisable(isActive);
    }

}
