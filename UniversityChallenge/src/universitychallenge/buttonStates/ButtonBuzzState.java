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
public class ButtonBuzzState implements UCButtonState {

    @Override
    public boolean getBonusButton() {
        return false;
    }


    @Override
    public boolean getBuzzButton() {
        return true;
    }

}
