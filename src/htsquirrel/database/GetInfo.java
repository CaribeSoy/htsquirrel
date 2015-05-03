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
package htsquirrel.database;

import htsquirrel.game.Match;
import htsquirrel.game.Team;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class GetInfo {
    
    public static ArrayList<Team> getTeamsFromDb(Connection connection,
            int userId) throws SQLException {
        ArrayList<Team> teams = new ArrayList<>();
        String sqlCode = "SELECT * FROM TEAMS WHERE USER_ID = " + userId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            Team team = new Team();
            team.setTeamId(resultSet.getInt("TEAM_ID"));
            team.setTeamName(resultSet.getString("TEAM_NAME"));
            team.setShortTeamName(resultSet.getString("SHORT_TEAM_NAME"));
            team.setFoundedDate(resultSet.getTimestamp("FOUNDED_DATE"));
            team.setPrimaryClub(resultSet.getBoolean("PRIMARY_CLUB"));
            team.setArenaId(resultSet.getInt("ARENA_ID"));
            team.setArenaName(resultSet.getString("ARENA_NAME"));
            team.setLeagueId(resultSet.getInt("LEAGUE_ID"));
            team.setLeagueName(resultSet.getString("LEAGUE_NAME"));
            team.setRegionId(resultSet.getInt("REGION_ID"));
            team.setRegionName(resultSet.getString("REGION_NAME"));
            team.setCoachId(resultSet.getInt("COACH_ID"));
            team.setLeagueLevelUnitId(resultSet.getInt("LEAGUE_LEVEL_UNIT_ID"));
            team.setLeagueLevelUnitName(resultSet.getString("LEAGUE_LEVEL_UNIT_NAME"));
            team.setLeagueLevel(resultSet.getInt("LEAGUE_LEVEL"));
            team.setFanclubId(resultSet.getInt("FANCLUB_ID"));
            team.setFanclubName(resultSet.getString("FANCLUB_NAME"));
            team.setFanclubSize(resultSet.getInt("FANCLUB_SIZE"));
            team.setLogoUri(resultSet.getString("LOGO_URI"));
            team.setDressUri(resultSet.getString("DRESS_URI"));
            team.setDressAlternateUri(resultSet.getString("DRESS_ALTERNATE_URI"));
            teams.add(team);
        }
        statement.close();
        return teams;
    }
    
    public static int getLastSeasonFromDb(Connection connection, Team team)
            throws SQLException {
        int lastSeason = 1;
        String sqlCode = "SELECT MAX(SEASON) AS LAST_SEASON FROM MATCHES " +
                "WHERE TEAM_ID = " + team.getTeamId();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            lastSeason = resultSet.getInt("LAST_SEASON");
        }
        if (lastSeason == 0) {
            lastSeason = 1;
        }
        statement.close();
        return lastSeason;
    }
    
    public static Timestamp getLastMatchDateFromDb(Connection connection,
            Team team) throws SQLException {
        Timestamp lastMatchDate = null;
        String sqlCode = "SELECT MAX(MATCH_DATE) AS LAST_MATCH_DATE " +
                "FROM MATCHES WHERE TEAM_ID = " + team.getTeamId();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            lastMatchDate = resultSet.getTimestamp("LAST_MATCH_DATE");
        }
        if (lastMatchDate == null) {
            lastMatchDate = Timestamp.valueOf("1990-01-01 00:00:00.0");
        }
        statement.close();
        return lastMatchDate;
    }
    
    public static int getNumberOfSeasonsFromDb(Connection connection, Team team)
            throws SQLException {
        int seasons = 0;
        String sqlCode = "SELECT COUNT(*) AS SEASONS FROM LEAGUE_IDS WHERE TEAM_ID = " + team.getTeamId();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            seasons = resultSet.getInt("SEASONS");
        }
        return seasons;
    }
    
    public static ArrayList<Integer> getMissingSeasonsFromDb(Connection connection,
            Team team) throws SQLException {
        ArrayList<Integer> seasons = new ArrayList<>();
        String sqlCode = "SELECT SEASON FROM LEAGUE_IDS WHERE MATCH_CONTEXT_ID IS NULL AND TEAM_ID = " + team.getTeamId();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            int season = resultSet.getInt("SEASON");
            seasons.add(season);
        }
        return seasons;
    }
    
    public static int getMinSeasonFromDb(Connection connection, Team team)
            throws SQLException {
        int season = 0;
        String sqlCode = "SELECT MIN(SEASON) AS SEASON FROM LEAGUE_IDS WHERE TEAM_ID = " + team.getTeamId();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            season = resultSet.getInt("SEASON");
        }
        return season;
    }
    
    public static int getMaxSeasonFromDb(Connection connection, Team team)
            throws SQLException {
        int season = 0;
        String sqlCode = "SELECT MAX(SEASON) AS SEASON FROM LEAGUE_IDS WHERE TEAM_ID = " + team.getTeamId();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            season = resultSet.getInt("SEASON");
        }
        return season;
    }
    
    public static ArrayList<Integer> getLeagueIdsFromDb(Connection connection)
            throws SQLException {
        ArrayList<Integer> leagueIds = new ArrayList<>();
        String sqlCode = "SELECT DISTINCT MATCH_CONTEXT_ID FROM LEAGUE_IDS ORDER BY MATCH_CONTEXT_ID";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            int leagueId = resultSet.getInt("MATCH_CONTEXT_ID");
            leagueIds.add(leagueId);
        }
        return leagueIds;
    }
    
    public static ArrayList<Match> getMissingMatchesFromDb(Connection connection,
            Team team) throws IOException, SQLException {
        ArrayList<Match> matches = new ArrayList<>();
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/select/missing_matches.sql");
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(team.getTeamId()));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            Match match = new Match();
            match.setMatchId(resultSet.getLong("MATCH_ID"));
            match.setTeamId(resultSet.getInt("TEAM_ID"));
            match.setTeamName(resultSet.getString("TEAM_NAME"));
            match.setOpponentTeamId(resultSet.getInt("OPPONENT_TEAM_ID"));
            match.setOpponentTeamName(resultSet.getString("OPPONENT_TEAM_NAME"));
            match.setVenue(resultSet.getString("VENUE"));
            match.setMatchDate(resultSet.getTimestamp("MATCH_DATE"));
            match.setSeason(resultSet.getInt("SEASON"));
            match.setMatchType(resultSet.getInt("MATCH_TYPE"));
            match.setMatchContextId(resultSet.getInt("MATCH_CONTEXT_ID"));
            match.setCupLevel(resultSet.getInt("CUP_LEVEL"));
            match.setCupLevelIndex(resultSet.getInt("CUP_LEVEL_INDEX"));
            match.setGoalsFor(resultSet.getInt("GOALS_FOR"));
            match.setGoalsAgainst(resultSet.getInt("GOALS_AGAINST"));
            matches.add(match);
        }
        statement.close();
        return matches;
    }
    
}
