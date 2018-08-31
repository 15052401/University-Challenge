/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge;

import universitychallenge.ButtonStates.ButtonInactiveState;
import universitychallenge.ButtonStates.ButtonStates;
import universitychallenge.GraphicalViewDialogStates.UCControllerTeamAState;
import universitychallenge.GraphicalViewDialogStates.UCControllerTeamBState;
import universitychallenge.ModelStates.QuestionState;
import universitychallenge.ModelStates.StarterQuestion;

/**
 *
 * @author Edward
 */
public class UCController {

    UCModel model;
    UniversityChallenge view;
    QuestionState questionState;
    ButtonStates buttonStates;
    

    public UCController(UCModel model) {
        this.model = model;
        questionState = new StarterQuestion(model);
    }

    public void setAActiveTeam() {
        questionState.setActiveTeam(new UCControllerTeamAState(model));
    }

    public void setBActiveTeam() {
        questionState.setActiveTeam(new UCControllerTeamBState(model));
    }

    public void setView(UniversityChallenge view) {
        this.view = view;
    }

    public void correct(int player) {
        buttonStates = questionState.correct(player);
        setButtons();
        view.update(null, null);
    }

    public void incorrect(int player) {
        buttonStates = questionState.incorrect(player);
        setButtons();
        view.update(null, null);
    }

    public void incorrectPenalty(int player) {
        buttonStates = questionState.incorrectPenalty(player);
        setButtons();
        view.update(null, null);
    }

    public String nextQuestion() {
        questionState = questionState.changeState();
        buttonStates = questionState.getButtonsState();
        String nextQ = questionState.nextQuestion();
        if(nextQ.contains("Game over!!")){
            buttonStates = new ButtonStates(new ButtonInactiveState(),new ButtonInactiveState());
            buttonStates.setNextQState(false);
        }
        setButtons();
        view.update(null, null);
        return nextQ;
    }

    public UCModel getModel() {
        return model;
    }

    public Team getTeam() {
        return questionState.getTeam();
    }

    private void setButtons() {
        view.setBonusA(!buttonStates.getStateA().getBonusButton());
        view.setBonusB(!buttonStates.getStateB().getBonusButton());
        view.setBuzzB(!buttonStates.getStateB().getBuzzButton());
        view.setBuzzA(!buttonStates.getStateA().getBuzzButton());
        view.setNextQuestion(!buttonStates.getNextQState());
    }

}
