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

import java.sql.Timestamp;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Match {
    
    private long matchId;
    private int teamId;
    private String teamName;
    private int opponentTeamId;
    private String opponentTeamName;
    private String venue;
    private Timestamp matchDate;
    private int season;
    private int matchType;
    private int matchContextId;
    private int cupLevel;
    private int cupLevelIndex;
    private int goalsFor;
    private int goalsAgainst;

    public Match() {
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getOpponentTeamId() {
        return opponentTeamId;
    }

    public void setOpponentTeamId(int opponentTeamId) {
        this.opponentTeamId = opponentTeamId;
    }

    public String getOpponentTeamName() {
        return opponentTeamName;
    }

    public void setOpponentTeamName(String opponentTeamName) {
        this.opponentTeamName = opponentTeamName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Timestamp getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Timestamp matchDate) {
        this.matchDate = matchDate;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getMatchType() {
        return matchType;
    }

    public void setMatchType(int matchType) {
        this.matchType = matchType;
    }

    public int getMatchContextId() {
        return matchContextId;
    }

    public void setMatchContextId(int matchContextId) {
        this.matchContextId = matchContextId;
    }

    public int getCupLevel() {
        return cupLevel;
    }

    public void setCupLevel(int cupLevel) {
        this.cupLevel = cupLevel;
    }

    public int getCupLevelIndex() {
        return cupLevelIndex;
    }

    public void setCupLevelIndex(int cupLevelIndex) {
        this.cupLevelIndex = cupLevelIndex;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }
    
}
