/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitychallenge;

import java.util.ArrayList;

/**
 *
 * @author Edward
 */
public class Team {

    private String teamName;
    private ArrayList<playerScore> team;

    Team(String teamName) {
        this.teamName = teamName;
        team = new ArrayList<playerScore>(4);
    }

    public playerScore getPlayer(int index) {
        return team.get(index);
    }

    public void addPlayer(String player) {
        team.add(new playerScore(player));
    }

    public int getTeamScore() {
        int total = 0;
        for (playerScore p : team) {
            total += p.getScore();
        }
        return total;
    }

    public String getTeamName() {
        return teamName;
    }
}
