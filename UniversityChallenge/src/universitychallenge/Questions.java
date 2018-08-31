/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edward
 */
public class Questions {

    private static ArrayList<String> questions;
    private static ArrayList<String> bouns;
    private static int bonusIndex;
    private static int questionIndex;

    Questions() {
        loadQuestions();
        bonusIndex = 0;
        questionIndex = 0;
    }

    private void loadQuestions() {
        questions = new ArrayList<>();
        bouns = new ArrayList<>();
        Scanner in;
        try {
            in = new Scanner(new FileReader("Packet.txt"));
            String question = in.nextLine();
            question = in.nextLine();
            boolean bonus = false;
            while (in.hasNextLine()) {
                question = in.nextLine();
                if (in.hasNextLine()) {
                    if (question.contains("BONUSES") || bonus) {
                        if (!bonus) {
                            in.nextLine();
                            bonus = true;
                        } else {
                            in.nextLine();
                            for (int i = 0; i < 3; i++) {
                                String bonusQ = question;
                                bonusQ += "\n" + in.nextLine();
                                in.nextLine();
                                bonusQ += "\n" + in.nextLine();
                                if (in.hasNextLine()) {
                                    in.nextLine();
                                }
                                bouns.add(bonusQ);
                            }
                        }
                    } else {
                        for (int i = 0; i < 3; i++) {
                            question += in.nextLine() + "\n";
                        }
                        questions.add(question);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Questions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public String nextQuestion() {
        assert questionIndex<21:"Question index out of bounds";
        String question;
        if (20 > questionIndex) {
            question = questions.get(questionIndex);
        } else {
            question = "Game over!!";
        }
        questionIndex++;
        return question;
    }

    public String nextBonus() {
        assert bonusIndex<61:"Bonus question index out of bounds";
        String question = bouns.get(bonusIndex);
        bonusIndex++;
        return question;
    }

}
