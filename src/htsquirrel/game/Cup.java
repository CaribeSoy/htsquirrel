/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Aleksandar Cvetković
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package htsquirrel.game;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Cup {
    
    private int teamId;
    private final int matchType = 3;
    private int cupId;
    private String cupName;
    private int cupLeagueLevel;
    private int cupLevel;
    private int cupLevelIndex;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    
    public int getMatchType() {
        return matchType;
    }

    public int getCupId() {
        return cupId;
    }

    public void setCupId(int cupId) {
        this.cupId = cupId;
    }

    public String getCupName() {
        return cupName;
    }

    public void setCupName(String cupName) {
        this.cupName = cupName;
    }

    public int getCupLeagueLevel() {
        return cupLeagueLevel;
    }

    public void setCupLeagueLevel(int cupLeagueLevel) {
        this.cupLeagueLevel = cupLeagueLevel;
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

    public Cup(int teamId, int cupId, String cupName, int cupLeagueLevel,
            int cupLevel, int cupLevelIndex) {
        this.teamId = teamId;
        this.cupId = cupId;
        this.cupName = cupName;
        this.cupLeagueLevel = cupLeagueLevel;
        this.cupLevel = cupLevel;
        this.cupLevelIndex = cupLevelIndex;
    }
    
}
