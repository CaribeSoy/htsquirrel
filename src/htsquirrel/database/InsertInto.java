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

import htsquirrel.game.Cup;
import htsquirrel.game.League;
import htsquirrel.game.Match;
import htsquirrel.game.Team;
import htsquirrel.game.Transfer;
import htsquirrel.game.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class InsertInto {
    
    public static void insertIntoTeams(Connection connection, User user, Team team)
            throws IOException, SQLException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/teams.sql");
        sqlCode = sqlCode.replaceAll("#user_id#", String.valueOf(user.getUserId()));
        sqlCode = sqlCode.replaceAll("#login_name#", user.getLoginName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#supporter_tier#", user.getSupporterTier().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(team.getTeamId()));
        sqlCode = sqlCode.replaceAll("#team_name#", team.getTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#short_team_name#", team.getShortTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#founded_date#", String.valueOf(team.getFoundedDate()));
        sqlCode = sqlCode.replaceAll("#primary_club#", String.valueOf(team.isPrimaryClub()));
        sqlCode = sqlCode.replaceAll("#arena_id#", String.valueOf(team.getArenaId()));
        sqlCode = sqlCode.replaceAll("#arena_name#", team.getArenaName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#league_id#", String.valueOf(team.getLeagueId()));
        sqlCode = sqlCode.replaceAll("#league_name#", team.getLeagueName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#region_id#", String.valueOf(team.getRegionId()));
        sqlCode = sqlCode.replaceAll("#region_name#", team.getRegionName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#coach_id#", String.valueOf(team.getCoachId()));
        sqlCode = sqlCode.replaceAll("#league_level_unit_id#", String.valueOf(team.getLeagueLevelUnitId()));
        sqlCode = sqlCode.replaceAll("#league_level_unit_name#", team.getLeagueLevelUnitName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#league_level#", String.valueOf(team.getLeagueLevel()));
        sqlCode = sqlCode.replaceAll("#fanclub_id#", String.valueOf(team.getFanclubId()));
        sqlCode = sqlCode.replaceAll("#fanclub_name#", team.getFanclubName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#fanclub_size#", String.valueOf(team.getFanclubSize()));
        sqlCode = sqlCode.replaceAll("#logo_uri#", team.getLogoUri().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#dress_uri#", team.getDressUri().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#dress_alternate_uri#", team.getDressAlternateUri().replaceAll("'", "''"));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoCups(Connection connection, Cup cup)
            throws IOException, SQLException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/cups.sql");
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(cup.getTeamId()));
        sqlCode = sqlCode.replaceAll("#match_type#", String.valueOf(cup.getMatchType()));
        sqlCode = sqlCode.replaceAll("#cup_id#", String.valueOf(cup.getCupId()));
        sqlCode = sqlCode.replaceAll("#cup_name#", cup.getCupName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#cup_league_level#", String.valueOf(cup.getCupLeagueLevel()));
        sqlCode = sqlCode.replaceAll("#cup_level#", String.valueOf(cup.getCupLevel()));
        sqlCode = sqlCode.replaceAll("#cup_level_index#", String.valueOf(cup.getCupLevelIndex()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoTransfers(Connection connection, Transfer transfer)
            throws IOException, SQLException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/transfers.sql");
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(transfer.getTeamId()));
        sqlCode = sqlCode.replaceAll("#transfer_id#", String.valueOf(transfer.getTransferId()));
        sqlCode = sqlCode.replaceAll("#deadline#", String.valueOf(transfer.getDeadline()));
        sqlCode = sqlCode.replaceAll("#player_id#", String.valueOf(transfer.getPlayerId()));
        sqlCode = sqlCode.replaceAll("#player_name#", transfer.getPlayerName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#tsi#", String.valueOf(transfer.getTsi()));
        sqlCode = sqlCode.replaceAll("#transfer_type#", transfer.getTransferType().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#buyer_team_id#", String.valueOf(transfer.getBuyerTeamId()));
        sqlCode = sqlCode.replaceAll("#buyer_team_name#", transfer.getBuyerTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#seller_team_id#", String.valueOf(transfer.getSellerTeamId()));
        sqlCode = sqlCode.replaceAll("#seller_team_name#", transfer.getSellerTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#price#", String.valueOf(transfer.getPrice()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoMatches(Connection connection, Match match)
            throws IOException, SQLException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/matches.sql");
        sqlCode = sqlCode.replaceAll("#match_id#", String.valueOf(match.getMatchId()));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(match.getTeamId()));
        sqlCode = sqlCode.replaceAll("#team_name#", match.getTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#opponent_team_id#", String.valueOf(match.getOpponentTeamId()));
        sqlCode = sqlCode.replaceAll("#opponent_team_name#", match.getOpponentTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#venue#", match.getVenue().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#match_date#", String.valueOf(match.getMatchDate()));
        sqlCode = sqlCode.replaceAll("#season#", String.valueOf(match.getSeason()));
        sqlCode = sqlCode.replaceAll("#match_type#", String.valueOf(match.getMatchType()));
        sqlCode = sqlCode.replaceAll("#match_context_id#", String.valueOf(match.getMatchContextId()));
        sqlCode = sqlCode.replaceAll("#cup_level#", String.valueOf(match.getCupLevel()));
        sqlCode = sqlCode.replaceAll("#cup_level_index#", String.valueOf(match.getCupLevelIndex()));
        sqlCode = sqlCode.replaceAll("#goals_for#", String.valueOf(match.getGoalsFor()));
        sqlCode = sqlCode.replaceAll("#goals_against#", String.valueOf(match.getGoalsAgainst()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoLeagueIds(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/league_ids.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoLeagueNames(Connection connection, League league)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/league_names.sql");
        sqlCode = sqlCode.replaceAll("#league_level_unit_id#", String.valueOf(league.getLeagueLevelUnitId()));
        sqlCode = sqlCode.replaceAll("#league_level#", String.valueOf(league.getLeagueLevel()));
        sqlCode = sqlCode.replaceAll("#league_level_unit_name#", league.getLeagueLevelUnitName().replaceAll("'", "''"));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoLeagues(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/leagues.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
}
