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
import htsquirrel.game.Booking;
import htsquirrel.game.Cup;
import htsquirrel.game.Event;
import htsquirrel.game.Goal;
import htsquirrel.game.Injury;
import htsquirrel.game.Match;
import htsquirrel.game.MatchDetails;
import htsquirrel.game.Referee;
import htsquirrel.game.Team;
import htsquirrel.game.Transfer;
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
        if (!(tableExists(connection, "REFEREES"))) {
            createRefereesTable(connection);
        }
        if (!(tableExists(connection, "GOALS"))) {
            createGoalsTable(connection);
        }
        if (!(tableExists(connection, "BOOKINGS"))) {
            createBookingsTable(connection);
        }
        if (!(tableExists(connection, "INJURIES"))) {
            createInjuriesTable(connection);
        }
        if (!(tableExists(connection, "EVENTS"))) {
            createEventsTable(connection);
        }
        if (!(tableExists(connection, "TRANSFERS"))) {
            createTransfersTable(connection);
        }
        if (!(tableExists(connection, "LEAGUE_IDS"))) {
            createLeagueIdsTable(connection);
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
    
    // create referees table
    private static void createRefereesTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_referees.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    //create goals table
    private static void createGoalsTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_goals.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    // create bookings table
    private static void createBookingsTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_bookings.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    // create injuries table
    private static void createInjuriesTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_injuries.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    // create events table
    private static void createEventsTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_events.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    // create transfers table
    private static void createTransfersTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_transfers.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    // create league ids table
    private static void createLeagueIdsTable(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/create_table_league_ids.sql");
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

    // get missing matches
    public static ArrayList<Match> getMissingMatches(Connection connection,
            Team team) throws IOException, SQLException {
        ArrayList<Match> matches = new ArrayList<>();
        String sqlCode = sqlToString("htsquirrel/database/sql/select_missing_matches.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(team.getTeamId()));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            long matchId = resultSet.getLong("MATCH_ID");
            int teamId = resultSet.getInt("TEAM_ID");
            String teamName = resultSet.getString("TEAM_NAME");
            int opponentTeamId = resultSet.getInt("OPPONENT_TEAM_ID");
            String opponentTeamName = resultSet.getString("OPPONENT_TEAM_NAME");
            String venue = resultSet.getString("VENUE");
            Timestamp matchDate = resultSet.getTimestamp("MATCH_DATE");
            int season = resultSet.getInt("SEASON");
            int matchType = resultSet.getInt("MATCH_TYPE");
            int matchContextId = resultSet.getInt("MATCH_CONTEXT_ID");
            int cupLevel = resultSet.getInt("CUP_LEVEL");
            int cupLevelIndex = resultSet.getInt("CUP_LEVEL_INDEX");
            int goalsFor = resultSet.getInt("GOALS_FOR");
            int goalsAgainst = resultSet.getInt("GOALS_AGAINST");
            Match match = new Match(matchId, teamId, teamName, opponentTeamId,
                    opponentTeamName, venue, matchDate, season, matchType,
                    matchContextId, cupLevel, cupLevelIndex, goalsFor,
                    goalsAgainst);
            matches.add(match);
        }
        statement.close();
        return matches;
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
    
    public static void deleteFromTransfers(Connection connection, Team team)
            throws SQLException, IOException {
        String sqlCode = "DELETE FROM TRANSFERS WHERE TEAM_ID = " +
                team.getTeamId();
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

    public static void insertIntoTeams(Connection connection, User user,
            Team team) throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_teams.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_USER_ID\\b", String.valueOf(user.getUserId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LOGIN_NAME\\b", user.getLoginName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SUPPORTER_TIER\\b", user.getSupporterTier().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(team.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_NAME\\b", team.getTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SHORT_TEAM_NAME\\b", team.getShortTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_FOUNDED_DATE\\b", String.valueOf(team.getFoundedDate()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_PRIMARY_CLUB\\b", String.valueOf(team.isPrimaryClub()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_ARENA_ID\\b", String.valueOf(team.getArenaId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_ARENA_NAME\\b", team.getArenaName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_ID\\b", String.valueOf(team.getLeagueId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_NAME\\b", team.getLeagueName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REGION_ID\\b", String.valueOf(team.getRegionId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REGION_NAME\\b", team.getRegionName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_COACH_ID\\b", String.valueOf(team.getCoachId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_LEVEL_UNIT_ID\\b", String.valueOf(team.getLeagueLevelUnitId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_LEVEL_UNIT_NAME\\b", team.getLeagueLevelUnitName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LEAGUE_LEVEL\\b", String.valueOf(team.getLeagueLevel()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_FANCLUB_ID\\b", String.valueOf(team.getFanclubId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_FANCLUB_NAME\\b", team.getFanclubName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_FANCLUB_SIZE\\b", String.valueOf(team.getFanclubSize()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_LOGO_URI\\b", team.getLogoUri().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_DRESS_URI\\b", team.getDressUri().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_DRESS_ALTERNATE_URI\\b", team.getDressAlternateUri().replaceAll("'", "''"));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

    public static void insertIntoMatches(Connection connection, Match match)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_matches.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_ID\\b", String.valueOf(match.getMatchId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(match.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_NAME\\b", match.getTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_TEAM_ID\\b", String.valueOf(match.getOpponentTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_TEAM_NAME\\b", match.getOpponentTeamName().replaceAll("'", "''"));
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
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_NAME\\b", cup.getCupName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEAGUE_LEVEL\\b", String.valueOf(cup.getCupLeagueLevel()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEVEL\\b", String.valueOf(cup.getCupLevel()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEVEL_INDEX\\b", String.valueOf(cup.getCupLevelIndex()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

    public static void insertIntoMatchDetails(Connection connection,
            MatchDetails matchDetails) throws IOException, SQLException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_match_details.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_ID\\b", String.valueOf(matchDetails.getMatchId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(matchDetails.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_NAME\\b", matchDetails.getTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_TEAM_ID\\b", String.valueOf(matchDetails.getOpponentTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_TEAM_NAME\\b", matchDetails.getOpponentTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOALS_FOR\\b", String.valueOf(matchDetails.getGoalsFor()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOALS_AGAINST\\b", String.valueOf(matchDetails.getGoalsAgainst()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_TYPE\\b", String.valueOf(matchDetails.getMatchType()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_CONTEXT_ID\\b", String.valueOf(matchDetails.getMatchContextId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEVEL\\b", String.valueOf(matchDetails.getCupLevel()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_CUP_LEVEL_INDEX\\b", String.valueOf(matchDetails.getCupLevelIndex()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SEASON\\b", String.valueOf(matchDetails.getSeason()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_DATE\\b", String.valueOf(matchDetails.getMatchDate()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_FINISHED_DATE\\b", String.valueOf(matchDetails.getFinishedDate()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_VENUE\\b", matchDetails.getVenue());
        sqlCode = sqlCode.replaceAll("\\bVALUE_ARENA_ID\\b", String.valueOf(matchDetails.getArenaId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_ARENA_NAME\\b", matchDetails.getArenaName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SOLD_TOTAL\\b", String.valueOf(matchDetails.getSoldTotal()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SOLD_TERRACES\\b", String.valueOf(matchDetails.getSoldTerraces()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SOLD_BASIC\\b", String.valueOf(matchDetails.getSoldBasic()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SOLD_ROOF\\b", String.valueOf(matchDetails.getSoldRoof()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SOLD_VIP\\b", String.valueOf(matchDetails.getSoldVip()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_WEATHER_ID\\b", String.valueOf(matchDetails.getWeatherId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_DRESS_URI\\b", matchDetails.getDressUri().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_FORMATION\\b", matchDetails.getFormation().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TACTIC_TYPE\\b", String.valueOf(matchDetails.getTacticType()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TACTIC_SKILL\\b", String.valueOf(matchDetails.getTacticSkill()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ATTITUDE\\b", String.valueOf(matchDetails.getTeamAttitude()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_RATING_M\\b", String.valueOf(matchDetails.getRatingM()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_RATING_RD\\b", String.valueOf(matchDetails.getRatingRD()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_RATING_CD\\b", String.valueOf(matchDetails.getRatingCD()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_RATING_LD\\b", String.valueOf(matchDetails.getRatingLD()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_RATING_RA\\b", String.valueOf(matchDetails.getRatingRA()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_RATING_CA\\b", String.valueOf(matchDetails.getRatingCA()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_RATING_LA\\b", String.valueOf(matchDetails.getRatingLA()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_RATING_ISPD\\b", String.valueOf(matchDetails.getRatingISPD()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_RATING_ISPA\\b", String.valueOf(matchDetails.getRatingISPA()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_POSSESSION_1\\b", String.valueOf(matchDetails.getPossession1()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_POSSESSION_2\\b", String.valueOf(matchDetails.getPossession2()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_DRESS_URI\\b", matchDetails.getOpponentDressUri().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_FORMATION\\b", matchDetails.getOpponentFormation().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_TACTIC_TYPE\\b", String.valueOf(matchDetails.getOpponentTacticType()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_TACTIC_SKILL\\b", String.valueOf(matchDetails.getOpponentTacticSkill()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_RATING_M\\b", String.valueOf(matchDetails.getOpponentRatingM()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_RATING_RD\\b", String.valueOf(matchDetails.getOpponentRatingRD()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_RATING_CD\\b", String.valueOf(matchDetails.getOpponentRatingCD()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_RATING_LD\\b", String.valueOf(matchDetails.getOpponentRatingLD()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_RATING_RA\\b", String.valueOf(matchDetails.getOpponentRatingRA()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_RATING_CA\\b", String.valueOf(matchDetails.getOpponentRatingCA()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_RATING_LA\\b", String.valueOf(matchDetails.getOpponentRatingLA()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_RATING_ISPD\\b", String.valueOf(matchDetails.getOpponentRatingISPD()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_RATING_ISPA\\b", String.valueOf(matchDetails.getOpponentRatingISPA()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_POSSESSION_1\\b", String.valueOf(matchDetails.getOpponentPossession1()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_OPPONENT_POSSESSION_2\\b", String.valueOf(matchDetails.getOpponentPossession2()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoReferees(Connection connection,
            Referee referee) throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_referees.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_ID\\b", String.valueOf(referee.getMatchId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(referee.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REFEREE_ROLE\\b", String.valueOf(referee.getRefereeRole()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REFEREE_ID\\b", String.valueOf(referee.getRefereeId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REFEREE_NAME\\b", referee.getRefereeName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REFEREE_COUNTRY_ID\\b", String.valueOf(referee.getRefereeCountryId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REFEREE_COUNTRY_NAME\\b", referee.getRefereeCountryName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REFEREE_TEAM_ID\\b", String.valueOf(referee.getRefereeTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_REFEREE_TEAM_NAME\\b", referee.getRefereeTeamName().replaceAll("'", "''"));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoGoals(Connection connection, Goal goal)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_goals.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_ID\\b", String.valueOf(goal.getMatchId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(goal.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOAL_INDEX\\b", String.valueOf(goal.getGoalIndex()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOAL_PLAYER_ID\\b", String.valueOf(goal.getGoalPlayerId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOAL_PLAYER_NAME\\b", goal.getGoalPlayerName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOAL_TEAM_ID\\b", String.valueOf(goal.getGoalTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOAL_GOALS_FOR\\b", String.valueOf(goal.getGoalGoalsFor()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOAL_GOALS_AGAINST\\b", String.valueOf(goal.getGoalGoalsAgainst()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_GOAL_MINUTE\\b", String.valueOf(goal.getGoalMinute()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoBookings(Connection connection, Booking booking)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_bookings.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_ID\\b", String.valueOf(booking.getMatchId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(booking.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_BOOKING_INDEX\\b", String.valueOf(booking.getBookingIndex()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_BOOKING_PLAYER_ID\\b", String.valueOf(booking.getBookingPlayerId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_BOOKING_PLAYER_NAME\\b", booking.getBookingPlayerName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_BOOKING_TEAM_ID\\b", String.valueOf(booking.getBookingTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_BOOKING_TYPE\\b", String.valueOf(booking.getBookingType()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_BOOKING_MINUTE\\b", String.valueOf(booking.getBookingMinute()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoInjuries(Connection connection, Injury injury)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_injuries.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_ID\\b", String.valueOf(injury.getMatchId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(injury.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_INJURY_INDEX\\b", String.valueOf(injury.getInjuryIndex()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_INJURY_PLAYER_ID\\b", String.valueOf(injury.getInjuryPlayerId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_INJURY_PLAYER_NAME\\b", injury.getInjuryPlayerName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_INJURY_TEAM_ID\\b", String.valueOf(injury.getInjuryTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_INJURY_TYPE\\b", String.valueOf(injury.getInjuryType()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_INJURY_MINUTE\\b", String.valueOf(injury.getInjuryMinute()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoEvents(Connection connection, Event event)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_events.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_MATCH_ID\\b", String.valueOf(event.getMatchId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(event.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_EVENT_INDEX\\b", String.valueOf(event.getEventIndex()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_EVENT_MINUTE\\b", String.valueOf(event.getEventMinute()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_EVENT_TYPE\\b", String.valueOf(event.getEventType()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_EVENT_VARIATION\\b", String.valueOf(event.getEventVariation()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_EVENT_SUBJECT_TEAM_ID\\b", String.valueOf(event.getEventSubjectTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_EVENT_SUBJECT_PLAYER_ID\\b", String.valueOf(event.getEventSubjectPlayerId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_EVENT_OBJECT_PLAYER_ID\\b", String.valueOf(event.getEventObjectPlayerId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_EVENT_TEXT\\b", event.getEventText().replaceAll("'", "''"));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoTransfers(Connection connection, Transfer transfer)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/insert_into_transfers.sql");
        sqlCode = sqlCode.replaceAll("\\bVALUE_TEAM_ID\\b", String.valueOf(transfer.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TRANSFER_ID\\b", String.valueOf(transfer.getTransferId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_DEADLINE\\b", String.valueOf(transfer.getDeadline()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_PLAYER_ID\\b", String.valueOf(transfer.getPlayerId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_PLAYER_NAME\\b", transfer.getPlayerName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TSI\\b", String.valueOf(transfer.getTsi()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_TRANSFER_TYPE\\b", transfer.getTransferType().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_BUYER_TEAM_ID\\b", String.valueOf(transfer.getBuyerTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_BUYER_TEAM_NAME\\b", transfer.getBuyerTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SELLER_TEAM_ID\\b", String.valueOf(transfer.getSellerTeamId()));
        sqlCode = sqlCode.replaceAll("\\bVALUE_SELLER_TEAM_NAME\\b", transfer.getSellerTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("\\bVALUE_PRICE\\b", String.valueOf(transfer.getPrice()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }

}
