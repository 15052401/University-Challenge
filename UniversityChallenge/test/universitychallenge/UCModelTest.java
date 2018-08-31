/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Edward
 */
public class UCModelTest {

    public UCModelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of nextQuestion method, of class UCModel.
     */
    @Test
    public void testNextQuestion() {
        System.out.println("nextQuestion");
        UCModel instance = new UCModel();
        String expResult = "1. Scott Aaronson at the University of Texas maintains an online \"zoo\" devoted to classifying these things. The spacing between these collections are both arbitrarily large and possible to calculate according to the Borodin-Trakhtenbrot Gap Theorem. Laszlo Kalmar coined the term ELEMENTARY for one of these sets, which is formed by taking the union of a group of sets that comprise the exponential hierarchy. Two spatial examples of these sets are equivalent according to Savitch's theorem. A specific one of these sets is defined as the group of problems whose solutions are verifiable using a nondeterministic Turing machine in polynomial time. The hardest problems in many of these sets are termed \"complete.\" For 10 points, name these sets used to classify computational complexity, such as P and NP.\n"
                + "ANSWER: computational complexity classes\n"
                + "\n"
                + "";
        String result = instance.nextQuestion();
        assertEquals(expResult, result);
    }

    /**
     * Test of nextBonusQuestion method, of class UCModel.
     * 
     */
    @Test
    public void testNextBonusQuestion() {
        System.out.println("nextBonusQuestion");
        UCModel instance = new UCModel();
        String expResult = "1. This form of search evaluates nodes by combining its path cost from the start node with a heuristic estimating the distance to the goal node. For 5 points each:\n"
                + "[5] Name this widely-used form of best-first search differentiated from uniform cost search by its usage of a heuristic. The graph-search version of this technique is guaranteed to be optimal if its heuristic is consistent.\n"
                + "ANSWER: A star search";
        String result = instance.nextBonusQuestion();
        assertEquals(expResult, result);
    }

    /**
     * Test of correctA method, of class UCModel. Testing that the correct score
     * is is created after the inputs
     */
    @Test
    public void testScoring() {
        System.out.println("testScoring");
        int teamMember = 0;
        int expResult = 10;
        UCModel instance = new UCModel();
        for (int i = 0; i < 4; i++) {
            instance.getTeamA().addPlayer("");
        }
        instance.correctA(teamMember);
        instance.correctBonusA(teamMember);
        instance.incorrectPenaltyA(teamMember);
        instance.incorrectA(teamMember);
        int result = instance.getTeamA().getTeamScore();
        assertEquals(expResult, result);
    }

}
