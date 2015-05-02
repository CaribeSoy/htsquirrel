/*
 The MIT License (MIT)

 Copyright (c) 2015 Aleksandar Cvetković

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package htsquirrel.game;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Goal {
    
    private long matchId;
    private int teamId;
    private int goalIndex;
    private int goalPlayerId;
    private String goalPlayerName;
    private int goalTeamId;
    private int goalGoalsFor;
    private int goalGoalsAgainst;
    private int goalMinute;

    public Goal() {
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getGoalIndex() {
        return goalIndex;
    }

    public void setGoalIndex(int goalIndex) {
        this.goalIndex = goalIndex;
    }

    public int getGoalPlayerId() {
        return goalPlayerId;
    }

    public void setGoalPlayerId(int goalPlayerId) {
        this.goalPlayerId = goalPlayerId;
    }

    public String getGoalPlayerName() {
        return goalPlayerName;
    }

    public void setGoalPlayerName(String goalPlayerName) {
        this.goalPlayerName = goalPlayerName;
    }

    public int getGoalTeamId() {
        return goalTeamId;
    }

    public void setGoalTeamId(int goalTeamId) {
        this.goalTeamId = goalTeamId;
    }

    public int getGoalGoalsFor() {
        return goalGoalsFor;
    }

    public void setGoalGoalsFor(int goalGoalsFor) {
        this.goalGoalsFor = goalGoalsFor;
    }

    public int getGoalGoalsAgainst() {
        return goalGoalsAgainst;
    }

    public void setGoalGoalsAgainst(int goalGoalsAgainst) {
        this.goalGoalsAgainst = goalGoalsAgainst;
    }

    public int getGoalMinute() {
        return goalMinute;
    }

    public void setGoalMinute(int goalMinute) {
        this.goalMinute = goalMinute;
    }
    
}
