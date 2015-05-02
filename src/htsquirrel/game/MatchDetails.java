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
public class MatchDetails {
    
    private long matchId;
    private int teamId;
    private String teamName;
    private int opponentTeamId;
    private String opponentTeamName;
    private int goalsFor;
    private int goalsAgainst;
    private int matchType;
    private int matchContextId;
    private int cupLevel;
    private int cupLevelIndex;
    private int season;
    private Timestamp matchDate;
    private Timestamp finishedDate;
    private String venue;
    private int arenaId;
    private String arenaName;
    private int soldTotal;
    private int soldTerraces;
    private int soldBasic;
    private int soldRoof;
    private int soldVip;
    private int weatherId;
    private String dressUri;
    private String formation;
    private int tacticType;
    private int tacticSkill;
    private int teamAttitude;
    private int ratingM;
    private int ratingRD;
    private int ratingCD;
    private int ratingLD;
    private int ratingRA;
    private int ratingCA;
    private int ratingLA;
    private int ratingISPD;
    private int ratingISPA;
    private int possession1;
    private int possession2;
    private String opponentDressUri;
    private String opponentFormation;
    private int opponentTacticType;
    private int opponentTacticSkill;
    private int opponentRatingM;
    private int opponentRatingRD;
    private int opponentRatingCD;
    private int opponentRatingLD;
    private int opponentRatingRA;
    private int opponentRatingCA;
    private int opponentRatingLA;
    private int opponentRatingISPD;
    private int opponentRatingISPA;
    private int opponentPossession1;
    private int opponentPossession2;

    public MatchDetails() {
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

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public Timestamp getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Timestamp matchDate) {
        this.matchDate = matchDate;
    }

    public Timestamp getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Timestamp finishedDate) {
        this.finishedDate = finishedDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getArenaId() {
        return arenaId;
    }

    public void setArenaId(int arenaId) {
        this.arenaId = arenaId;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public int getSoldTotal() {
        return soldTotal;
    }

    public void setSoldTotal(int soldTotal) {
        this.soldTotal = soldTotal;
    }

    public int getSoldTerraces() {
        return soldTerraces;
    }

    public void setSoldTerraces(int soldTerraces) {
        this.soldTerraces = soldTerraces;
    }

    public int getSoldBasic() {
        return soldBasic;
    }

    public void setSoldBasic(int soldBasic) {
        this.soldBasic = soldBasic;
    }

    public int getSoldRoof() {
        return soldRoof;
    }

    public void setSoldRoof(int soldRoof) {
        this.soldRoof = soldRoof;
    }

    public int getSoldVip() {
        return soldVip;
    }

    public void setSoldVip(int soldVip) {
        this.soldVip = soldVip;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getDressUri() {
        return dressUri;
    }

    public void setDressUri(String dressUri) {
        this.dressUri = dressUri;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public int getTacticType() {
        return tacticType;
    }

    public void setTacticType(int tacticType) {
        this.tacticType = tacticType;
    }

    public int getTacticSkill() {
        return tacticSkill;
    }

    public void setTacticSkill(int tacticSkill) {
        this.tacticSkill = tacticSkill;
    }

    public int getTeamAttitude() {
        return teamAttitude;
    }

    public void setTeamAttitude(int teamAttitude) {
        this.teamAttitude = teamAttitude;
    }

    public int getRatingM() {
        return ratingM;
    }

    public void setRatingM(int ratingM) {
        this.ratingM = ratingM;
    }

    public int getRatingRD() {
        return ratingRD;
    }

    public void setRatingRD(int ratingRD) {
        this.ratingRD = ratingRD;
    }

    public int getRatingCD() {
        return ratingCD;
    }

    public void setRatingCD(int ratingCD) {
        this.ratingCD = ratingCD;
    }

    public int getRatingLD() {
        return ratingLD;
    }

    public void setRatingLD(int ratingLD) {
        this.ratingLD = ratingLD;
    }

    public int getRatingRA() {
        return ratingRA;
    }

    public void setRatingRA(int ratingRA) {
        this.ratingRA = ratingRA;
    }

    public int getRatingCA() {
        return ratingCA;
    }

    public void setRatingCA(int ratingCA) {
        this.ratingCA = ratingCA;
    }

    public int getRatingLA() {
        return ratingLA;
    }

    public void setRatingLA(int ratingLA) {
        this.ratingLA = ratingLA;
    }

    public int getRatingISPD() {
        return ratingISPD;
    }

    public void setRatingISPD(int ratingISPD) {
        this.ratingISPD = ratingISPD;
    }

    public int getRatingISPA() {
        return ratingISPA;
    }

    public void setRatingISPA(int ratingISPA) {
        this.ratingISPA = ratingISPA;
    }

    public int getPossession1() {
        return possession1;
    }

    public void setPossession1(int possession1) {
        this.possession1 = possession1;
    }

    public int getPossession2() {
        return possession2;
    }

    public void setPossession2(int possession2) {
        this.possession2 = possession2;
    }

    public String getOpponentDressUri() {
        return opponentDressUri;
    }

    public void setOpponentDressUri(String opponentDressUri) {
        this.opponentDressUri = opponentDressUri;
    }

    public String getOpponentFormation() {
        return opponentFormation;
    }

    public void setOpponentFormation(String opponentFormation) {
        this.opponentFormation = opponentFormation;
    }

    public int getOpponentTacticType() {
        return opponentTacticType;
    }

    public void setOpponentTacticType(int opponentTacticType) {
        this.opponentTacticType = opponentTacticType;
    }

    public int getOpponentTacticSkill() {
        return opponentTacticSkill;
    }

    public void setOpponentTacticSkill(int opponentTacticSkill) {
        this.opponentTacticSkill = opponentTacticSkill;
    }

    public int getOpponentRatingM() {
        return opponentRatingM;
    }

    public void setOpponentRatingM(int opponentRatingM) {
        this.opponentRatingM = opponentRatingM;
    }

    public int getOpponentRatingRD() {
        return opponentRatingRD;
    }

    public void setOpponentRatingRD(int opponentRatingRD) {
        this.opponentRatingRD = opponentRatingRD;
    }

    public int getOpponentRatingCD() {
        return opponentRatingCD;
    }

    public void setOpponentRatingCD(int opponentRatingCD) {
        this.opponentRatingCD = opponentRatingCD;
    }

    public int getOpponentRatingLD() {
        return opponentRatingLD;
    }

    public void setOpponentRatingLD(int opponentRatingLD) {
        this.opponentRatingLD = opponentRatingLD;
    }

    public int getOpponentRatingRA() {
        return opponentRatingRA;
    }

    public void setOpponentRatingRA(int opponentRatingRA) {
        this.opponentRatingRA = opponentRatingRA;
    }

    public int getOpponentRatingCA() {
        return opponentRatingCA;
    }

    public void setOpponentRatingCA(int opponentRatingCA) {
        this.opponentRatingCA = opponentRatingCA;
    }

    public int getOpponentRatingLA() {
        return opponentRatingLA;
    }

    public void setOpponentRatingLA(int opponentRatingLA) {
        this.opponentRatingLA = opponentRatingLA;
    }

    public int getOpponentRatingISPD() {
        return opponentRatingISPD;
    }

    public void setOpponentRatingISPD(int opponentRatingISPD) {
        this.opponentRatingISPD = opponentRatingISPD;
    }

    public int getOpponentRatingISPA() {
        return opponentRatingISPA;
    }

    public void setOpponentRatingISPA(int opponentRatingISPA) {
        this.opponentRatingISPA = opponentRatingISPA;
    }

    public int getOpponentPossession1() {
        return opponentPossession1;
    }

    public void setOpponentPossession1(int opponentPossession1) {
        this.opponentPossession1 = opponentPossession1;
    }

    public int getOpponentPossession2() {
        return opponentPossession2;
    }

    public void setOpponentPossession2(int opponentPossession2) {
        this.opponentPossession2 = opponentPossession2;
    }
    
}
