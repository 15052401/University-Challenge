/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge.ButtonStates;

/**
 *
 * @author Edward
 */
public class ButtonStates {

    private UCButtonState buttonStateA = new ButtonBuzzState();
    private UCButtonState buttonStateB = new ButtonBuzzState();
    private boolean nextQButton;

    public ButtonStates(UCButtonState buttonStateA, UCButtonState buttonStateB) {
        this.buttonStateA = buttonStateA;
        this.buttonStateB = buttonStateB;
        nextQButton = true;
    }

    public UCButtonState getStateA() {
        return buttonStateA;
    }

    public UCButtonState getStateB() {
        return buttonStateB;
    }

    public boolean getNextQState() {
        return nextQButton;
    }

    public void setNextQState(boolean state) {
        nextQButton = state;
    }
}
