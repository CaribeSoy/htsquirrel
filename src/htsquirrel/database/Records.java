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

import static htsquirrel.HTSquirrel.getCurrentTeam;
import static htsquirrel.HTSquirrel.getMatchFilter;
import static htsquirrel.HTSquirrel.getPageRecords1;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Records {

    private static String mode;

    public static String getMode() {
        return mode;
    }

    public static void setMode(String mode) {
        Records.mode = mode;
    }

    private static int mapBoolean(boolean input, int valueTrue, int valueFalse) {
        int result = 999;
        if (input) {
            result = valueTrue;
        } else {
            result = valueFalse;
        }
        return result;
    }

    private static String matchFilterToSql() throws IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/where/match_filter.sql");
        sqlCode = sqlCode.replaceAll("\\b#team_id#\\b", String.valueOf(getCurrentTeam().getTeamId()));
        sqlCode = sqlCode.replaceAll("\\b#match_type_l#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxLeague().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\b#match_type_q#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxQualification().isSelected(), 2, 999)));
        sqlCode = sqlCode.replaceAll("\\b#match_type_hm#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxHattrickMasters().isSelected(), 7, 999)));
        sqlCode = sqlCode.replaceAll("\\b#match_type_fn#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelFriendlies().getCheckBoxFriendlyNormal().isSelected(), 4, 999)));
        sqlCode = sqlCode.replaceAll("\\b#match_type_fc#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelFriendlies().getCheckBoxFriendlyCup().isSelected(), 5, 999)));
        sqlCode = sqlCode.replaceAll("\\b#match_type_ifn#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelFriendlies().getCheckBoxIntFriendlyNormal().isSelected(), 8, 999)));
        sqlCode = sqlCode.replaceAll("\\b#match_type_ifc#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelFriendlies().getCheckBoxIntFriendlyCup().isSelected(), 9, 999)));
        sqlCode = sqlCode.replaceAll("\\b#cup_level_n#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalCup().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\b#cup_level_index_ne#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalEmerald().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\b#cup_level_index_nr#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalRuby().isSelected(), 2, 999)));
        sqlCode = sqlCode.replaceAll("\\b#cup_level_index_ns#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalSapphire().isSelected(), 3, 999)));
        sqlCode = sqlCode.replaceAll("\\b#cup_level_nc#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalConsolation().isSelected(), 3, 999)));
        String cupLevels = "(999";
        if (getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxLevel7().isSelected()) cupLevels = cupLevels + ", 7";
        if (getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxLevel8().isSelected()) cupLevels = cupLevels + ", 8";
        if (getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxLevel9().isSelected()) cupLevels = cupLevels + ", 9";
        cupLevels = cupLevels + ")";
        sqlCode = sqlCode.replaceAll("\\b#cup_league_level_d#\\b", cupLevels);
        sqlCode = sqlCode.replaceAll("\\b#cup_level_d#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalCup().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\b#cup_level_index_de#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalEmerald().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\b#cup_level_index_dr#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalRuby().isSelected(), 2, 999)));
        sqlCode = sqlCode.replaceAll("\\b#cup_level_index_ds#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalSapphire().isSelected(), 3, 999)));
        sqlCode = sqlCode.replaceAll("\\b#cup_level_dc#\\b", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalConsolation().isSelected(), 3, 999)));
        String seasonFrom = "0";
        String seasonTo = "999";
        if (getMatchFilter().getPanelPeriod().getPeriodBase1().getRadioButtonSeason().isSelected()) {
            seasonFrom = getMatchFilter().getPanelPeriod().getPeriodBase1().getComboBoxSeasonFrom().getSelectedItem().toString();
            seasonTo = getMatchFilter().getPanelPeriod().getPeriodBase1().getComboBoxSeasonTo().getSelectedItem().toString();
        }
        String dateFrom = "1990-01-01";
        String dateTo = "2100-01-01";
        if (getMatchFilter().getPanelPeriod().getPeriodBase1().getRadioButtonDate().isSelected()) {
            dateFrom = getMatchFilter().getPanelPeriod().getPeriodBase1().getTextFieldDateFrom().getText();
            dateTo = getMatchFilter().getPanelPeriod().getPeriodBase1().getTextFieldDateTo().getText();
        }
        String leagueFrom = "0";
        String leagueTo = "999";
        if (getMatchFilter().getPanelPeriod().getPeriodBase1().getRadioButtonLeagueLevel().isSelected()) {
            leagueFrom = getMatchFilter().getPanelPeriod().getPeriodBase1().getComboBoxLevelFrom().getSelectedItem().toString();
            leagueTo = getMatchFilter().getPanelPeriod().getPeriodBase1().getComboBoxLevelTo().getSelectedItem().toString();
        }
        String league = "%";
        if (getMatchFilter().getPanelPeriod().getPeriodBase1().getRadioButtonSpecificLeague().isSelected()) {
            league = getMatchFilter().getPanelPeriod().getPeriodBase1().getComboBoxLeagueName().getSelectedItem().toString();
        }
        sqlCode = sqlCode.replaceAll("\\b#season_from#\\b", seasonFrom);
        sqlCode = sqlCode.replaceAll("\\b#season_to#\\b", seasonTo);
        sqlCode = sqlCode.replaceAll("\\b#match_date_from#\\b", dateFrom);
        sqlCode = sqlCode.replaceAll("\\b#match_date_to#\\b", dateTo);
        sqlCode = sqlCode.replaceAll("\\b#league_level_from#\\b", leagueFrom);
        sqlCode = sqlCode.replaceAll("\\b#league_level_to#\\b", leagueTo);
        sqlCode = sqlCode.replaceAll("\\b#league_level_unit_name#\\b", league);
        return sqlCode;
    }
    
    public static void showTotalTeamScore(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/select/total_team_score.sql");
        sqlCode = sqlCode + " " + matchFilterToSql();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            int wins = resultSet.getInt("W");
            int draws = resultSet.getInt("D");
            int losses = resultSet.getInt("L");
            int goalsFor = resultSet.getInt("GF");
            int goalsAgainst = resultSet.getInt("GA");
            int matches = wins + draws + losses;
            double goalsForPerMatch = (double) goalsFor / (double) matches;
            double goalsAgainstPerMatch = (double) goalsAgainst / (double) matches;
            String text;
            text = "<html>Matches: " + matches + "<br><br>";
            text = text + "Wins: " + wins + "<br>";
            text = text + "Draws: " + draws + "<br>";
            text = text + "Losses: " + losses + "<br><br>";
            text = text + "Goals for: " + goalsFor + " (" + String.format("%.1f", goalsForPerMatch) + " per match)<br>";
            text = text + "Goals against: " + goalsAgainst + " (" + String.format("%.1f", goalsAgainstPerMatch) + " per match)</html>";
            getPageRecords1().showLabel2(text);
        }
        statement.close();

    }

}
