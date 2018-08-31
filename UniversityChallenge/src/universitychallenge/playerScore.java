/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge;

/**
 *
 * @author Edward
 */
public class playerScore {
//I have tried to change this vairable name to playerScore to conform to naming conventions but the refactoring does not work correctly and causes the program to crash
    private String name;
    private int correct = 0;
    private int correctBonus = 0;
    private int incorrect = 0;
    private int incorrectPenalty = 0;

    playerScore(String name) {
        this.name = name;
    }

    public int getScore() {
        return ((correct * 10) + (correctBonus * 5)) - (incorrectPenalty * 5);
    }

    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrectPenalty;
    }

    public void correct() {
        correct++;
    }

    public void correctBonus() {
        correctBonus++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void incorrect() {
        incorrect++;
    }

    public void incorrectPenalty() {
        incorrectPenalty++;
    }
}

