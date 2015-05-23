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

import htsquirrel.game.Booking;
import htsquirrel.game.Cup;
import htsquirrel.game.Event;
import htsquirrel.game.Goal;
import htsquirrel.game.Injury;
import htsquirrel.game.League;
import htsquirrel.game.Match;
import htsquirrel.game.MatchDetails;
import htsquirrel.game.Referee;
import htsquirrel.game.StartingLineup;
import htsquirrel.game.Substitution;
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
    
    public static void insertIntoMatchDetails(Connection connection,
            MatchDetails matchDetails) throws IOException, SQLException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/match_details.sql");
        sqlCode = sqlCode.replaceAll("#match_id#", String.valueOf(matchDetails.getMatchId()));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(matchDetails.getTeamId()));
        sqlCode = sqlCode.replaceAll("#team_name#", matchDetails.getTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#opponent_team_id#", String.valueOf(matchDetails.getOpponentTeamId()));
        sqlCode = sqlCode.replaceAll("#opponent_team_name#", matchDetails.getOpponentTeamName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#goals_for#", String.valueOf(matchDetails.getGoalsFor()));
        sqlCode = sqlCode.replaceAll("#goals_against#", String.valueOf(matchDetails.getGoalsAgainst()));
        sqlCode = sqlCode.replaceAll("#match_type#", String.valueOf(matchDetails.getMatchType()));
        sqlCode = sqlCode.replaceAll("#match_context_id#", String.valueOf(matchDetails.getMatchContextId()));
        sqlCode = sqlCode.replaceAll("#cup_level#", String.valueOf(matchDetails.getCupLevel()));
        sqlCode = sqlCode.replaceAll("#cup_level_index#", String.valueOf(matchDetails.getCupLevelIndex()));
        sqlCode = sqlCode.replaceAll("#season#", String.valueOf(matchDetails.getSeason()));
        sqlCode = sqlCode.replaceAll("#match_date#", String.valueOf(matchDetails.getMatchDate()));
        sqlCode = sqlCode.replaceAll("#finished_date#", String.valueOf(matchDetails.getFinishedDate()));
        sqlCode = sqlCode.replaceAll("#venue#", matchDetails.getVenue());
        sqlCode = sqlCode.replaceAll("#arena_id#", String.valueOf(matchDetails.getArenaId()));
        sqlCode = sqlCode.replaceAll("#arena_name#", matchDetails.getArenaName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#sold_total#", String.valueOf(matchDetails.getSoldTotal()));
        sqlCode = sqlCode.replaceAll("#sold_terraces#", String.valueOf(matchDetails.getSoldTerraces()));
        sqlCode = sqlCode.replaceAll("#sold_basic#", String.valueOf(matchDetails.getSoldBasic()));
        sqlCode = sqlCode.replaceAll("#sold_roof#", String.valueOf(matchDetails.getSoldRoof()));
        sqlCode = sqlCode.replaceAll("#sold_vip#", String.valueOf(matchDetails.getSoldVip()));
        sqlCode = sqlCode.replaceAll("#weather_id#", String.valueOf(matchDetails.getWeatherId()));
        sqlCode = sqlCode.replaceAll("#dress_uri#", matchDetails.getDressUri().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#formation#", matchDetails.getFormation().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#tactic_type#", String.valueOf(matchDetails.getTacticType()));
        sqlCode = sqlCode.replaceAll("#tactic_skill#", String.valueOf(matchDetails.getTacticSkill()));
        sqlCode = sqlCode.replaceAll("#team_attitude#", String.valueOf(matchDetails.getTeamAttitude()));
        sqlCode = sqlCode.replaceAll("#rating_m#", String.valueOf(matchDetails.getRatingM()));
        sqlCode = sqlCode.replaceAll("#rating_rd#", String.valueOf(matchDetails.getRatingRD()));
        sqlCode = sqlCode.replaceAll("#rating_cd#", String.valueOf(matchDetails.getRatingCD()));
        sqlCode = sqlCode.replaceAll("#rating_ld#", String.valueOf(matchDetails.getRatingLD()));
        sqlCode = sqlCode.replaceAll("#rating_ra#", String.valueOf(matchDetails.getRatingRA()));
        sqlCode = sqlCode.replaceAll("#rating_ca#", String.valueOf(matchDetails.getRatingCA()));
        sqlCode = sqlCode.replaceAll("#rating_la#", String.valueOf(matchDetails.getRatingLA()));
        sqlCode = sqlCode.replaceAll("#rating_ispd#", String.valueOf(matchDetails.getRatingISPD()));
        sqlCode = sqlCode.replaceAll("#rating_ispa#", String.valueOf(matchDetails.getRatingISPA()));
        sqlCode = sqlCode.replaceAll("#possession_1#", String.valueOf(matchDetails.getPossession1()));
        sqlCode = sqlCode.replaceAll("#possession_2#", String.valueOf(matchDetails.getPossession2()));
        sqlCode = sqlCode.replaceAll("#opponent_dress_uri#", matchDetails.getOpponentDressUri().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#opponent_formation#", matchDetails.getOpponentFormation().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#opponent_tactic_type#", String.valueOf(matchDetails.getOpponentTacticType()));
        sqlCode = sqlCode.replaceAll("#opponent_tactic_skill#", String.valueOf(matchDetails.getOpponentTacticSkill()));
        sqlCode = sqlCode.replaceAll("#opponent_rating_m#", String.valueOf(matchDetails.getOpponentRatingM()));
        sqlCode = sqlCode.replaceAll("#opponent_rating_rd#", String.valueOf(matchDetails.getOpponentRatingRD()));
        sqlCode = sqlCode.replaceAll("#opponent_rating_cd#", String.valueOf(matchDetails.getOpponentRatingCD()));
        sqlCode = sqlCode.replaceAll("#opponent_rating_ld#", String.valueOf(matchDetails.getOpponentRatingLD()));
        sqlCode = sqlCode.replaceAll("#opponent_rating_ra#", String.valueOf(matchDetails.getOpponentRatingRA()));
        sqlCode = sqlCode.replaceAll("#opponent_rating_ca#", String.valueOf(matchDetails.getOpponentRatingCA()));
        sqlCode = sqlCode.replaceAll("#opponent_rating_la#", String.valueOf(matchDetails.getOpponentRatingLA()));
        sqlCode = sqlCode.replaceAll("#opponent_rating_ispd#", String.valueOf(matchDetails.getOpponentRatingISPD()));
        sqlCode = sqlCode.replaceAll("#opponent_rating_ispa#", String.valueOf(matchDetails.getOpponentRatingISPA()));
        sqlCode = sqlCode.replaceAll("#opponent_possession_1#", String.valueOf(matchDetails.getOpponentPossession1()));
        sqlCode = sqlCode.replaceAll("#opponent_possession_2#", String.valueOf(matchDetails.getOpponentPossession2()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoReferees(Connection connection,
            Referee referee) throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/referees.sql");
        sqlCode = sqlCode.replaceAll("#match_id#", String.valueOf(referee.getMatchId()));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(referee.getTeamId()));
        sqlCode = sqlCode.replaceAll("#referee_role#", String.valueOf(referee.getRefereeRole()));
        sqlCode = sqlCode.replaceAll("#referee_id#", String.valueOf(referee.getRefereeId()));
        sqlCode = sqlCode.replaceAll("#referee_name#", referee.getRefereeName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#referee_country_id#", String.valueOf(referee.getRefereeCountryId()));
        sqlCode = sqlCode.replaceAll("#referee_country_name#", referee.getRefereeCountryName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#referee_team_id#", String.valueOf(referee.getRefereeTeamId()));
        sqlCode = sqlCode.replaceAll("#referee_team_name#", referee.getRefereeTeamName().replaceAll("'", "''"));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoGoals(Connection connection, Goal goal)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/goals.sql");
        sqlCode = sqlCode.replaceAll("#match_id#", String.valueOf(goal.getMatchId()));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(goal.getTeamId()));
        sqlCode = sqlCode.replaceAll("#goal_index#", String.valueOf(goal.getGoalIndex()));
        sqlCode = sqlCode.replaceAll("#goal_player_id#", String.valueOf(goal.getGoalPlayerId()));
        sqlCode = sqlCode.replaceAll("#goal_player_name#", goal.getGoalPlayerName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#goal_team_id#", String.valueOf(goal.getGoalTeamId()));
        sqlCode = sqlCode.replaceAll("#goal_goals_for#", String.valueOf(goal.getGoalGoalsFor()));
        sqlCode = sqlCode.replaceAll("#goal_goals_against#", String.valueOf(goal.getGoalGoalsAgainst()));
        sqlCode = sqlCode.replaceAll("#goal_minute#", String.valueOf(goal.getGoalMinute()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoBookings(Connection connection, Booking booking)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/bookings.sql");
        sqlCode = sqlCode.replaceAll("#match_id#", String.valueOf(booking.getMatchId()));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(booking.getTeamId()));
        sqlCode = sqlCode.replaceAll("#booking_index#", String.valueOf(booking.getBookingIndex()));
        sqlCode = sqlCode.replaceAll("#booking_player_id#", String.valueOf(booking.getBookingPlayerId()));
        sqlCode = sqlCode.replaceAll("#booking_player_name#", booking.getBookingPlayerName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#booking_team_id#", String.valueOf(booking.getBookingTeamId()));
        sqlCode = sqlCode.replaceAll("#booking_type#", String.valueOf(booking.getBookingType()));
        sqlCode = sqlCode.replaceAll("#booking_minute#", String.valueOf(booking.getBookingMinute()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoInjuries(Connection connection, Injury injury)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/injuries.sql");
        sqlCode = sqlCode.replaceAll("#match_id#", String.valueOf(injury.getMatchId()));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(injury.getTeamId()));
        sqlCode = sqlCode.replaceAll("#injury_index#", String.valueOf(injury.getInjuryIndex()));
        sqlCode = sqlCode.replaceAll("#injury_player_id#", String.valueOf(injury.getInjuryPlayerId()));
        sqlCode = sqlCode.replaceAll("#injury_player_name#", injury.getInjuryPlayerName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#injury_team_id#", String.valueOf(injury.getInjuryTeamId()));
        sqlCode = sqlCode.replaceAll("#injury_type#", String.valueOf(injury.getInjuryType()));
        sqlCode = sqlCode.replaceAll("#injury_minute#", String.valueOf(injury.getInjuryMinute()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoEvents(Connection connection, Event event)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/events.sql");
        sqlCode = sqlCode.replaceAll("#match_id#", String.valueOf(event.getMatchId()));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(event.getTeamId()));
        sqlCode = sqlCode.replaceAll("#event_index#", String.valueOf(event.getEventIndex()));
        sqlCode = sqlCode.replaceAll("#event_minute#", String.valueOf(event.getEventMinute()));
        sqlCode = sqlCode.replaceAll("#event_type#", String.valueOf(event.getEventType()));
        sqlCode = sqlCode.replaceAll("#event_variation#", String.valueOf(event.getEventVariation()));
        sqlCode = sqlCode.replaceAll("#event_subject_team_id#", String.valueOf(event.getEventSubjectTeamId()));
        sqlCode = sqlCode.replaceAll("#event_subject_player_id#", String.valueOf(event.getEventSubjectPlayerId()));
        sqlCode = sqlCode.replaceAll("#event_object_player_id#", String.valueOf(event.getEventObjectPlayerId()));
        sqlCode = sqlCode.replaceAll("#event_text#", event.getEventText().replaceAll("'", "''"));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoMatchesExtended(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/matches_extended.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoStartingLineups(Connection connection, StartingLineup startingLineup)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/starting_lineups.sql");
        sqlCode = sqlCode.replaceAll("#match_id#", String.valueOf(startingLineup.getMatchId()));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(startingLineup.getTeamId()));
        sqlCode = sqlCode.replaceAll("#player_id#", String.valueOf(startingLineup.getPlayerId()));
        sqlCode = sqlCode.replaceAll("#role_id#", String.valueOf(startingLineup.getRole()));
        sqlCode = sqlCode.replaceAll("#first_name#", startingLineup.getFirstName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#last_name#", startingLineup.getLastName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#nick_name#", startingLineup.getNickName().replaceAll("'", "''"));
        sqlCode = sqlCode.replaceAll("#behaviour_id#", String.valueOf(startingLineup.getBehaviour()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void insertIntoSubstitutions(Connection connection, Substitution substitution)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/insert/substitution.sql");
        sqlCode = sqlCode.replaceAll("#match_id#", String.valueOf(substitution.getMatchId()));
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(substitution.getTeamId()));
        sqlCode = sqlCode.replaceAll("#subject_player_id#", String.valueOf(substitution.getSubjectPlayerId()));
        sqlCode = sqlCode.replaceAll("#object_player_id#", String.valueOf(substitution.getObjectPlayerId()));
        sqlCode = sqlCode.replaceAll("#order_type#", String.valueOf(substitution.getOrderType()));
        sqlCode = sqlCode.replaceAll("#new_position#", String.valueOf(substitution.getNewPosition()));
        sqlCode = sqlCode.replaceAll("#behaviour_id#", String.valueOf(substitution.getBehaviour()));
        sqlCode = sqlCode.replaceAll("#match_minute#", String.valueOf(substitution.getMinute()));
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
}
