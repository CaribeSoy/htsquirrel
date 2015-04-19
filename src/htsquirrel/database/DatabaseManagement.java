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
package htsquirrel.database;

import static htsquirrel.FileManagement.*;
import htsquirrel.HTSquirrel;
import htsquirrel.game.Cup;
import htsquirrel.game.Match;
import htsquirrel.game.Team;
import htsquirrel.game.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class DatabaseManagement {

    // create database connection
    public static Connection createDatabaseConnection()
            throws IOException,ClassNotFoundException, SQLException {
        deleteDatabaseDir();
        String dbUrl = "jdbc:h2:" + getDatabasePathShort();
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }

    // convert sql code from file to string
    public static String sqlToString(String sqlPath) throws IOException {
        URL sqlUrl = new URL(HTSquirrel.getClassPath() + sqlPath);
        InputStream inputStream = sqlUrl.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append(" ");
            line = bufferedReader.readLine();
        }
        return stringBuilder.toString();
    }

    // check if table exists
    public static boolean tableExists(Connection connection, String tableName)
            throws SQLException {
        boolean tableExists = false;
        DatabaseMetaData dbMetaData = connection.getMetaData();
        ResultSet resultSet = dbMetaData.getTables(null, null, null, null);
        while (resultSet.next()) {
            if (tableName.equals(resultSet.getString("TABLE_NAME"))) {
                tableExists = true;
            }
        }
        return tableExists;
    }

    // create missing tables
    public static void checkTablesExist(Connection connection)
            throws SQLException, IOException {
        if (!(tableExists(connection, "TEAMS"))) {
            createTeamsTable(connection);
        }
        if (!(tableExists(connection, "MATCHES"))) {
            createMatchesTable(connection);
        }
        if (!(tableExists(connection, "MATCH_DETAILS"))) {
            createMatchDetailsTable(connection);
        }
        if (!(tableExists(connection, "CUPS"))) {
            createCupsTable(connection);
        }
    }

    // create teams table
    private static void createTeamsTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_teams.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

    // create matches table
    private static void createMatchesTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_matches.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

    // create match details table
    private static void createMatchDetailsTable(Connection connection)
            throws IOException, SQLException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_match_details.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

    // create cups table
    private static void createCupsTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_cups.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

    // get team ids
    public static ArrayList<Integer> getTeamIds(Connection connection,
            int userId) throws SQLException, IOException {
        ArrayList<Integer> teamIds = new ArrayList<>();
        String sqlCode = "SELECT TEAM_ID FROM TEAMS " +
                "WHERE USER_ID = " + userId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            teamIds.add(resultSet.getInt("TEAM_ID"));
        }
        statement.close();
        return teamIds;
    }

    // get league id
    public static int getLeagueId(Connection connection, Team team)
            throws SQLException {
        int leagueId = 1; // TODO check this - returns Sweden
        String sqlCode = "SELECT LEAGUE_ID FROM TEAMS " +
                "WHERE TEAM_ID = " + team.getTeamId();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            leagueId = resultSet.getInt("LEAGUE_ID");
        }
        statement.close();
        return leagueId;
    }

    // get last season
    public static int getLastSeason(Connection connection, Team team)
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

    // get last match date
    public static Timestamp getLastMatchDate(Connection connection, Team team)
            throws SQLException {
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

    public static void deleteFromTeams(Connection connection, User user)
            throws SQLException, IOException {
        String sqlCode = "DELETE FROM TEAMS WHERE USER_ID = " +
                user.getUserId();
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void deleteFromCups(Connection connection, Team team)
            throws SQLException, IOException {
        String sqlCode = "DELETE FROM CUPS WHERE TEAM_ID = " +
                team.getTeamId();
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

    public static void insertIntoTeams(Connection connection, User user,
            Team team) throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_teams.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_USER_ID\\b", String.valueOf(user.getUserId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LOGIN_NAME\\b", user.getLoginName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_SUPPORTER_TIER\\b", user.getSupporterTier());
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(team.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_NAME\\b", team.getTeamName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_SHORT_TEAM_NAME\\b", team.getShortTeamName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_FOUNDED_DATE\\b", String.valueOf(team.getFoundedDate()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_PRIMARY_CLUB\\b", String.valueOf(team.isPrimaryClub()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_ARENA_ID\\b", String.valueOf(team.getArenaId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_ARENA_NAME\\b", team.getArenaName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_ID\\b", String.valueOf(team.getLeagueId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_NAME\\b", team.getLeagueName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_REGION_ID\\b", String.valueOf(team.getRegionId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REGION_NAME\\b", team.getRegionName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_COACH_ID\\b", String.valueOf(team.getCoachId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_LEVEL_UNIT_ID\\b", String.valueOf(team.getLeagueLevelUnitId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_LEVEL_UNIT_NAME\\b", team.getLeagueLevelUnitName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_LEVEL\\b", String.valueOf(team.getLeagueLevel()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_FANCLUB_ID\\b", String.valueOf(team.getFanclubId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_FANCLUB_NAME\\b", team.getFanclubName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_FANCLUB_SIZE\\b", String.valueOf(team.getFanclubSize()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LOGO_URI\\b", team.getLogoUri());
        sqlCode = sqlCode.replaceAll("\\bVALUE_DRESS_URI\\b", team.getDressUri());
        sqlCode = sqlCode.replaceAll("\\bVALUE_DRESS_ALTERNATE_URI\\b", team.getDressAlternateUri());
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

    public static void insertIntoMatches(Connection connection, Match match)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_matches.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_ID\\b", String.valueOf(match.getMatchId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(match.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_NAME\\b", match.getTeamName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_TEAM_ID\\b", String.valueOf(match.getOpponentTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_TEAM_NAME\\b", match.getOpponentTeamName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_VENUE\\b", match.getVenue());
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_DATE\\b", String.valueOf(match.getMatchDate()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SEASON\\b", String.valueOf(match.getSeason()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_TYPE\\b", String.valueOf(match.getMatchType()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_CONTEXT_ID\\b", String.valueOf(match.getMatchContextId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEVEL\\b", String.valueOf(match.getCupLevel()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEVEL_INDEX\\b", String.valueOf(match.getCupLevelIndex()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOALS_FOR\\b", String.valueOf(match.getGoalsFor()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOALS_AGAINST\\b", String.valueOf(match.getGoalsAgainst()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoCups(Connection connection, Cup cup)
            throws IOException, SQLException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_cups.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(cup.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_TYPE\\b", String.valueOf(cup.getMatchType()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_ID\\b", String.valueOf(cup.getCupId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_NAME\\b", cup.getCupName());
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEAGUE_LEVEL\\b", String.valueOf(cup.getCupLeagueLevel()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEVEL\\b", String.valueOf(cup.getCupLevel()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEVEL_INDEX\\b", String.valueOf(cup.getCupLevelIndex()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

}
