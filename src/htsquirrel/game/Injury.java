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
public class Injury {
    
    private long matchId;
    private int teamId;
    private int injuryIndex;
    private int injuryPlayerId;
    private String injuryPlayerName;
    private int injuryTeamId;
    private int injuryType;
    private int injuryMinute;

    public Injury() {
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

    public int getInjuryIndex() {
        return injuryIndex;
    }

    public void setInjuryIndex(int injuryIndex) {
        this.injuryIndex = injuryIndex;
    }

    public int getInjuryPlayerId() {
        return injuryPlayerId;
    }

    public void setInjuryPlayerId(int injuryPlayerId) {
        this.injuryPlayerId = injuryPlayerId;
    }

    public String getInjuryPlayerName() {
        return injuryPlayerName;
    }

    public void setInjuryPlayerName(String injuryPlayerName) {
        this.injuryPlayerName = injuryPlayerName;
    }

    public int getInjuryTeamId() {
        return injuryTeamId;
    }

    public void setInjuryTeamId(int injuryTeamId) {
        this.injuryTeamId = injuryTeamId;
    }

    public int getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(int injuryType) {
        this.injuryType = injuryType;
    }

    public int getInjuryMinute() {
        return injuryMinute;
    }

    public void setInjuryMinute(int injuryMinute) {
        this.injuryMinute = injuryMinute;
    }
    
}
