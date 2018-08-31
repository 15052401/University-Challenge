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
public class ButtonBonusState implements UCButtonState {


    @Override
    public boolean getBonusButton() {
        return true;
    }

    @Override
    public boolean getBuzzButton() {
        return false;
    }

}
