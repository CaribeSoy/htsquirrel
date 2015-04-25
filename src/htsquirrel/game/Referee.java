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
public class Referee {
    
    private long matchId;
    private int teamId;
    // refereeRole:
    // 0 - referee
    // 1 - referee assistant 1
    // 2 - referee assistant 2
    private int refereeRole;
    private int refereeId;
    private String refereeName;
    private int refereeCountryId;
    private String refereeCountryName;
    private int refereeTeamId;
    private String refereeTeamName;

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

    public int getRefereeRole() {
        return refereeRole;
    }

    public void setRefereeRole(int refereeRole) {
        this.refereeRole = refereeRole;
    }

    public int getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(int refereeId) {
        this.refereeId = refereeId;
    }

    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName;
    }

    public int getRefereeCountryId() {
        return refereeCountryId;
    }

    public void setRefereeCountryId(int refereeCountryId) {
        this.refereeCountryId = refereeCountryId;
    }

    public String getRefereeCountryName() {
        return refereeCountryName;
    }

    public void setRefereeCountryName(String refereeCountryName) {
        this.refereeCountryName = refereeCountryName;
    }

    public int getRefereeTeamId() {
        return refereeTeamId;
    }

    public void setRefereeTeamId(int refereeTeamId) {
        this.refereeTeamId = refereeTeamId;
    }

    public String getRefereeTeamName() {
        return refereeTeamName;
    }

    public void setRefereeTeamName(String refereeTeamName) {
        this.refereeTeamName = refereeTeamName;
    }

    public Referee() {
    }
    
}
