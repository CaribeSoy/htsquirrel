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
public class Team {
    
    private int teamId;
    private String teamName;
    private String shortTeamName;
    private Timestamp foundedDate;
    private boolean primaryClub;
    private int arenaId;
    private String arenaName;
    private int leagueId;
    private String leagueName;
    private int regionId;
    private String regionName;
    private int coachId;
    private int leagueLevelUnitId;
    private String leagueLevelUnitName;
    private int leagueLevel;
    private int fanclubId;
    private String fanclubName;
    private int fanclubSize;
    private String logoUri;
    private String dressUri;
    private String dressAlternateUri;

    public Team() {
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

    public String getShortTeamName() {
        return shortTeamName;
    }

    public void setShortTeamName(String shortTeamName) {
        this.shortTeamName = shortTeamName;
    }

    public Timestamp getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(Timestamp foundedDate) {
        this.foundedDate = foundedDate;
    }

    public boolean isPrimaryClub() {
        return primaryClub;
    }

    public void setPrimaryClub(boolean primaryClub) {
        this.primaryClub = primaryClub;
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

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public int getLeagueLevelUnitId() {
        return leagueLevelUnitId;
    }

    public void setLeagueLevelUnitId(int leagueLevelUnitId) {
        this.leagueLevelUnitId = leagueLevelUnitId;
    }

    public String getLeagueLevelUnitName() {
        return leagueLevelUnitName;
    }

    public void setLeagueLevelUnitName(String leagueLevelUnitName) {
        this.leagueLevelUnitName = leagueLevelUnitName;
    }

    public int getLeagueLevel() {
        return leagueLevel;
    }

    public void setLeagueLevel(int leagueLevel) {
        this.leagueLevel = leagueLevel;
    }

    public int getFanclubId() {
        return fanclubId;
    }

    public void setFanclubId(int fanclubId) {
        this.fanclubId = fanclubId;
    }

    public String getFanclubName() {
        return fanclubName;
    }

    public void setFanclubName(String fanclubName) {
        this.fanclubName = fanclubName;
    }

    public int getFanclubSize() {
        return fanclubSize;
    }

    public void setFanclubSize(int fanclubSize) {
        this.fanclubSize = fanclubSize;
    }

    public String getLogoUri() {
        return logoUri;
    }

    public void setLogoUri(String logoUri) {
        this.logoUri = logoUri;
    }

    public String getDressUri() {
        return dressUri;
    }

    public void setDressUri(String dressUri) {
        this.dressUri = dressUri;
    }

    public String getDressAlternateUri() {
        return dressAlternateUri;
    }

    public void setDressAlternateUri(String dressAlternateUri) {
        this.dressAlternateUri = dressAlternateUri;
    }
    
}
