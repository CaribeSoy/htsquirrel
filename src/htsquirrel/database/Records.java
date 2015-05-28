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
import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
        sqlCode = sqlCode.replaceAll("#team_id#", String.valueOf(getCurrentTeam().getTeamId()));
        sqlCode = sqlCode.replaceAll("#match_type_l#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxLeague().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("#match_type_q#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxQualification().isSelected(), 2, 999)));
        sqlCode = sqlCode.replaceAll("#match_type_hm#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxHattrickMasters().isSelected(), 7, 999)));
        sqlCode = sqlCode.replaceAll("#match_type_fn#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelFriendlies().getCheckBoxFriendlyNormal().isSelected(), 4, 999)));
        sqlCode = sqlCode.replaceAll("#match_type_fc#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelFriendlies().getCheckBoxFriendlyCup().isSelected(), 5, 999)));
        sqlCode = sqlCode.replaceAll("#match_type_ifn#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelFriendlies().getCheckBoxIntFriendlyNormal().isSelected(), 8, 999)));
        sqlCode = sqlCode.replaceAll("#match_type_ifc#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelFriendlies().getCheckBoxIntFriendlyCup().isSelected(), 9, 999)));
        sqlCode = sqlCode.replaceAll("#cup_level_n#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalCup().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("#cup_level_index_ne#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalEmerald().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("#cup_level_index_nr#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalRuby().isSelected(), 2, 999)));
        sqlCode = sqlCode.replaceAll("#cup_level_index_ns#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalSapphire().isSelected(), 3, 999)));
        sqlCode = sqlCode.replaceAll("#cup_level_nc#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxNationalConsolation().isSelected(), 3, 999)));
        String cupLevels = "(999";
        if (getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxLevel7().isSelected()) cupLevels = cupLevels + ", 7";
        if (getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxLevel8().isSelected()) cupLevels = cupLevels + ", 8";
        if (getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxLevel9().isSelected()) cupLevels = cupLevels + ", 9";
        cupLevels = cupLevels + ")";
        sqlCode = sqlCode.replaceAll("#cup_league_level_d#", cupLevels);
        sqlCode = sqlCode.replaceAll("#cup_level_d#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalCup().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("#cup_level_index_de#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalEmerald().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("#cup_level_index_dr#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalRuby().isSelected(), 2, 999)));
        sqlCode = sqlCode.replaceAll("#cup_level_index_ds#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalSapphire().isSelected(), 3, 999)));
        sqlCode = sqlCode.replaceAll("#cup_level_dc#", String.valueOf(mapBoolean(getMatchFilter().getPanelMatchType().getPanelCompetitions().getCheckBoxDivisionalConsolation().isSelected(), 3, 999)));
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
        sqlCode = sqlCode.replaceAll("#season_from#", seasonFrom);
        sqlCode = sqlCode.replaceAll("#season_to#", seasonTo);
        sqlCode = sqlCode.replaceAll("#match_date_from#", dateFrom);
        sqlCode = sqlCode.replaceAll("#match_date_to#", dateTo);
        sqlCode = sqlCode.replaceAll("#league_level_from#", leagueFrom);
        sqlCode = sqlCode.replaceAll("#league_level_to#", leagueTo);
        sqlCode = sqlCode.replaceAll("#league_level_unit_name#", league);
        String venue = "('999'";
        if (getMatchFilter().getPanelArena().getPanelGeneral().getCheckBoxHome().isSelected()) venue = venue + ", 'Home'";
        if (getMatchFilter().getPanelArena().getPanelGeneral().getCheckBoxAway().isSelected()) venue = venue + ", 'Away'";
        venue = venue + ")";
        sqlCode = sqlCode.replaceAll("#venue#", venue);
        String weather = "(999";
        if (getMatchFilter().getPanelArena().getPanelGeneral().getCheckBoxRain().isSelected()) weather = weather + ", 0";
        if (getMatchFilter().getPanelArena().getPanelGeneral().getCheckBoxOvercast().isSelected()) weather = weather + ", 1";
        if (getMatchFilter().getPanelArena().getPanelGeneral().getCheckBoxPartiallyCloudy().isSelected()) weather = weather + ", 2";
        if (getMatchFilter().getPanelArena().getPanelGeneral().getCheckBoxSunny().isSelected()) weather = weather + ", 3";
        weather = weather + ")";
        sqlCode = sqlCode.replaceAll("#weather_id#", weather);
        sqlCode = sqlCode.replaceAll("#sold_total_from#", String.valueOf(getMatchFilter().getPanelArena().getPanelGeneral().getSpinnerFrom().getValue()));
        sqlCode = sqlCode.replaceAll("#sold_total_to#", String.valueOf(getMatchFilter().getPanelArena().getPanelGeneral().getSpinnerTo().getValue()));
        if (getMatchFilter().getPanelArena().getPanelSeatType().getCheckBoxTerraces().isSelected()) {
            sqlCode = sqlCode.replaceAll("#sold_terraces_from#", String.valueOf(getMatchFilter().getPanelArena().getPanelSeatType().getSpinnerTerracesFrom().getValue()));
            sqlCode = sqlCode.replaceAll("#sold_terraces_to#", String.valueOf(getMatchFilter().getPanelArena().getPanelSeatType().getSpinnerTerracesTo().getValue()));
        } else {
            sqlCode = sqlCode.replaceAll("#sold_terraces_from#", "-1");
            sqlCode = sqlCode.replaceAll("#sold_terraces_to#", "999999");
        }
        if (getMatchFilter().getPanelArena().getPanelSeatType().getCheckBoxBasic().isSelected()) {
            sqlCode = sqlCode.replaceAll("#sold_basic_from#", String.valueOf(getMatchFilter().getPanelArena().getPanelSeatType().getSpinnerBasicFrom().getValue()));
            sqlCode = sqlCode.replaceAll("#sold_basic_to#", String.valueOf(getMatchFilter().getPanelArena().getPanelSeatType().getSpinnerBasicTo().getValue()));
        } else {
            sqlCode = sqlCode.replaceAll("#sold_basic_from#", "-1");
            sqlCode = sqlCode.replaceAll("#sold_basic_to#", "999999");
        }
        if (getMatchFilter().getPanelArena().getPanelSeatType().getCheckBoxRoof().isSelected()) {
            sqlCode = sqlCode.replaceAll("#sold_roof_from#", String.valueOf(getMatchFilter().getPanelArena().getPanelSeatType().getSpinnerRoofFrom().getValue()));
            sqlCode = sqlCode.replaceAll("#sold_roof_to#", String.valueOf(getMatchFilter().getPanelArena().getPanelSeatType().getSpinnerRoofTo().getValue()));
        } else {
            sqlCode = sqlCode.replaceAll("#sold_roof_from#", "-1");
            sqlCode = sqlCode.replaceAll("#sold_roof_to#", "999999");
        }
        if (getMatchFilter().getPanelArena().getPanelSeatType().getCheckBoxVip().isSelected()) {
            sqlCode = sqlCode.replaceAll("#sold_vip_from#", String.valueOf(getMatchFilter().getPanelArena().getPanelSeatType().getSpinnerVipFrom().getValue()));
            sqlCode = sqlCode.replaceAll("#sold_vip_to#", String.valueOf(getMatchFilter().getPanelArena().getPanelSeatType().getSpinnerVipTo().getValue()));
        } else {
            sqlCode = sqlCode.replaceAll("#sold_vip_from#", "-1");
            sqlCode = sqlCode.replaceAll("#sold_vip_to#", "999999");
        }
        if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBoxAllFormations().isSelected()) {
            sqlCode = sqlCode.replace("AND (FORMATION IN #formation#", "");
            sqlCode = sqlCode.replace("OR FORMATION NOT IN ('5-5-0', '5-4-1', '5-3-2', '5-2-3', '4-5-1', '4-4-2', '4-3-3', '3-5-2', '3-4-3', '2-5-3'))", "");
        } else {
            String formation = "('999'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox550().isSelected()) formation = formation + ", '5-5-0'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox541().isSelected()) formation = formation + ", '5-4-1'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox532().isSelected()) formation = formation + ", '5-3-2'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox523().isSelected()) formation = formation + ", '5-2-3'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox451().isSelected()) formation = formation + ", '4-5-1'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox442().isSelected()) formation = formation + ", '4-4-2'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox433().isSelected()) formation = formation + ", '4-3-3'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox352().isSelected()) formation = formation + ", '3-5-2'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox343().isSelected()) formation = formation + ", '3-4-3'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBox253().isSelected()) formation = formation + ", '2-5-3'";
            if (getMatchFilter().getPanelFormation().getFormationTeam().getCheckBoxSpecific().isSelected()) {
                formation = formation + ", '" + getMatchFilter().getPanelFormation().getFormationTeam().getTextFieldSpecific().getText() + "'";
            }
            formation = formation + ")";
            sqlCode = sqlCode.replaceAll("#formation#", formation);
            if (!(getMatchFilter().getPanelFormation().getFormationTeam().getCheckBoxOther().isSelected())) {
                sqlCode = sqlCode.replace("OR FORMATION NOT IN ('5-5-0', '5-4-1', '5-3-2', '5-2-3', '4-5-1', '4-4-2', '4-3-3', '3-5-2', '3-4-3', '2-5-3')", "");
            }
        }
        if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBoxAllFormations().isSelected()) {
            sqlCode = sqlCode.replace("AND (OPPONENT_FORMATION IN #opponent_formation#", "");
            sqlCode = sqlCode.replace("OR OPPONENT_FORMATION NOT IN ('5-5-0', '5-4-1', '5-3-2', '5-2-3', '4-5-1', '4-4-2', '4-3-3', '3-5-2', '3-4-3', '2-5-3'))", "");
        } else {
            String formation = "('999'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox550().isSelected()) formation = formation + ", '5-5-0'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox541().isSelected()) formation = formation + ", '5-4-1'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox532().isSelected()) formation = formation + ", '5-3-2'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox523().isSelected()) formation = formation + ", '5-2-3'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox451().isSelected()) formation = formation + ", '4-5-1'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox442().isSelected()) formation = formation + ", '4-4-2'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox433().isSelected()) formation = formation + ", '4-3-3'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox352().isSelected()) formation = formation + ", '3-5-2'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox343().isSelected()) formation = formation + ", '3-4-3'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBox253().isSelected()) formation = formation + ", '2-5-3'";
            if (getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBoxSpecific().isSelected()) {
                formation = formation + ", '" + getMatchFilter().getPanelFormation().getFormationOpponent().getTextFieldSpecific().getText() + "'";
            }
            formation = formation + ")";
            sqlCode = sqlCode.replaceAll("#opponent_formation#", formation);
            if (!(getMatchFilter().getPanelFormation().getFormationOpponent().getCheckBoxOther().isSelected())) {
                sqlCode = sqlCode.replace("OR OPPONENT_FORMATION NOT IN ('5-5-0', '5-4-1', '5-3-2', '5-2-3', '4-5-1', '4-4-2', '4-3-3', '3-5-2', '3-4-3', '2-5-3')", "");
            }
        }
        String tacticType = "(999";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxPressing().isSelected()) tacticType = tacticType + ", 1";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxCA().isSelected()) tacticType = tacticType + ", 2";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxMiddle().isSelected()) tacticType = tacticType + ", 3";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxWings().isSelected()) tacticType = tacticType + ", 4";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxLongShots().isSelected()) tacticType = tacticType + ", 8";
        tacticType = tacticType + ")";
        sqlCode = sqlCode.replaceAll("#tactic_type_1#", tacticType);
        String tacticSkillFrom = String.valueOf(getMatchFilter().getPanelTactics().getPanelTeam().getComboBoxFrom().getSelectedIndex());
        String tacticSkillTo = String.valueOf(getMatchFilter().getPanelTactics().getPanelTeam().getComboBoxTo().getSelectedIndex());
        sqlCode = sqlCode.replaceAll("#tactic_skill_from#", tacticSkillFrom);
        sqlCode = sqlCode.replaceAll("#tactic_skill_to#", tacticSkillTo);
        tacticType = "(999";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxNormal().isSelected()) tacticType = tacticType + ", 0";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxCreatively().isSelected()) tacticType = tacticType + ", 7";
        tacticType = tacticType + ")";
        sqlCode = sqlCode.replaceAll("#tactic_type_2#", tacticType);
        String teamAttitude = "(999";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxNorm().isSelected()) teamAttitude = teamAttitude + ", 0";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxPIC().isSelected()) teamAttitude = teamAttitude + ", -1";
        if (getMatchFilter().getPanelTactics().getPanelTeam().getCheckBoxMOTS().isSelected()) teamAttitude = teamAttitude + ", 1";
        teamAttitude = teamAttitude + ")";
        sqlCode = sqlCode.replaceAll("#team_attitude#", teamAttitude);
        tacticType = "(999";
        if (getMatchFilter().getPanelTactics().getPanelOpponent().getCheckBoxPressing().isSelected()) tacticType = tacticType + ", 1";
        if (getMatchFilter().getPanelTactics().getPanelOpponent().getCheckBoxCA().isSelected()) tacticType = tacticType + ", 2";
        if (getMatchFilter().getPanelTactics().getPanelOpponent().getCheckBoxMiddle().isSelected()) tacticType = tacticType + ", 3";
        if (getMatchFilter().getPanelTactics().getPanelOpponent().getCheckBoxWings().isSelected()) tacticType = tacticType + ", 4";
        if (getMatchFilter().getPanelTactics().getPanelOpponent().getCheckBoxLongShots().isSelected()) tacticType = tacticType + ", 8";
        tacticType = tacticType + ")";
        sqlCode = sqlCode.replaceAll("#opponent_tactic_type_1#", tacticType);
        tacticSkillFrom = String.valueOf(getMatchFilter().getPanelTactics().getPanelOpponent().getComboBoxFrom().getSelectedIndex());
        tacticSkillTo = String.valueOf(getMatchFilter().getPanelTactics().getPanelOpponent().getComboBoxTo().getSelectedIndex());
        sqlCode = sqlCode.replaceAll("#opponent_tactic_skill_from#", tacticSkillFrom);
        sqlCode = sqlCode.replaceAll("#opponent_tactic_skill_to#", tacticSkillTo);
        tacticType = "(999";
        if (getMatchFilter().getPanelTactics().getPanelOpponent().getCheckBoxNormal().isSelected()) tacticType = tacticType + ", 0";
        if (getMatchFilter().getPanelTactics().getPanelOpponent().getCheckBoxCreatively().isSelected()) tacticType = tacticType + ", 7";
        tacticType = tacticType + ")";
        sqlCode = sqlCode.replaceAll("#opponent_tactic_type_2#", tacticType);
        if (getMatchFilter().getPanelResult().getResultBase().getCheckBoxFor().isSelected()) {
            sqlCode = sqlCode.replaceAll("#goals_for_from#", String.valueOf(getMatchFilter().getPanelResult().getResultBase().getSpinnerForFrom().getValue()));
            sqlCode = sqlCode.replaceAll("#goals_for_to#", String.valueOf(getMatchFilter().getPanelResult().getResultBase().getSpinnerForTo().getValue()));
        } else {
            sqlCode = sqlCode.replace("AND GOALS_FOR BETWEEN #goals_for_from# AND #goals_for_to#", "");
        }
        if (getMatchFilter().getPanelResult().getResultBase().getCheckBoxAgainst().isSelected()) {
            sqlCode = sqlCode.replaceAll("#goals_against_from#", String.valueOf(getMatchFilter().getPanelResult().getResultBase().getSpinnerAgainstFrom().getValue()));
            sqlCode = sqlCode.replaceAll("#goals_against_to#", String.valueOf(getMatchFilter().getPanelResult().getResultBase().getSpinnerAgainstTo().getValue()));
        } else {
            sqlCode = sqlCode.replace("AND GOALS_AGAINST BETWEEN #goals_against_from# AND #goals_against_to#", "");
        }
        if (getMatchFilter().getPanelResult().getResultBase().getCheckBoxTotal().isSelected()) {
            sqlCode = sqlCode.replaceAll("#goals_total_from#", String.valueOf(getMatchFilter().getPanelResult().getResultBase().getSpinnerTotalFrom().getValue()));
            sqlCode = sqlCode.replaceAll("#goals_total_to#", String.valueOf(getMatchFilter().getPanelResult().getResultBase().getSpinnerTotalTo().getValue()));
        } else {
            sqlCode = sqlCode.replace("AND GOALS_FOR + GOALS_AGAINST BETWEEN #goals_total_from# AND #goals_total_to#", "");
        }
        if (getMatchFilter().getPanelResult().getResultBase().getCheckBoxDifference().isSelected()) {
            sqlCode = sqlCode.replaceAll("#goal_difference_from#", String.valueOf(getMatchFilter().getPanelResult().getResultBase().getSpinnerDifferenceFrom().getValue()));
            sqlCode = sqlCode.replaceAll("#goal_difference_to#", String.valueOf(getMatchFilter().getPanelResult().getResultBase().getSpinnerDifferenceTo().getValue()));
        } else {
            sqlCode = sqlCode.replace("AND GOALS_FOR - GOALS_AGAINST BETWEEN #goal_difference_from# AND #goal_difference_to#", "");
        }
        System.out.println(sqlCode);
        return sqlCode;
    }

    public static void showTotalTeamScore(Connection connection)
            throws SQLException, IOException {
//        getPageRecords1().getjScrollPane1().setSize(375, 60);
//        getPageRecords1().getjScrollPane1().setPreferredSize(new Dimension(375, 60));
//        getPageRecords1().getjTable1().setPreferredSize(new Dimension(375, 30));
//        getPageRecords1().getjTable1().setSize(375, 30);
        DefaultTableModel model = (DefaultTableModel) getPageRecords1().getjTable1().getModel();
        model.setColumnCount(0);
        model.addColumn("Category");
        model.addColumn("Total");
        model.addColumn("Average");
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        getPageRecords1().getjTable1().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
        getPageRecords1().getjTable1().getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        getPageRecords1().getjTable1().getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
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
            String matchesPerMatch = "100.0%";
            String winsPerMatch = String.format("%.1f", 100.0 * (double) wins / (double) matches) + "%";
            String drawsPerMatch = String.format("%.1f", 100.0 * (double) draws / (double) matches) + "%";
            String lossesPerMatch = String.format("%.1f", 100.0 * (double) losses / (double) matches) + "%";
            String goalsForPerMatch = String.format("%.1f", (double) goalsFor / (double) matches);
            String goalsAgainstPerMatch = String.format("%.1f", (double) goalsAgainst / (double) matches);
            if (matches == 0) {
                matchesPerMatch = "-";
                winsPerMatch = "-";
                drawsPerMatch = "-";
                lossesPerMatch = "-";
                goalsForPerMatch = "-";
                goalsAgainstPerMatch = "-";
            }
            model.addRow(new Object[]{"Matches", matches, matchesPerMatch});
            model.addRow(new Object[]{"Wins", wins, winsPerMatch});
            model.addRow(new Object[]{"Draws", draws, drawsPerMatch});
            model.addRow(new Object[]{"Losses", losses, lossesPerMatch});
            model.addRow(new Object[]{"Goals for", goalsFor, goalsForPerMatch});
            model.addRow(new Object[]{"Goals against", goalsAgainst, goalsAgainstPerMatch});
        }
        statement.close();
    }

    public static void showMostGoals(Connection connection)
            throws SQLException, IOException {
        DefaultTableModel model = (DefaultTableModel) getPageRecords1().getjTable1().getModel();
        model.setColumnCount(0);
        model.addColumn("Player");
        model.addColumn("Goals");
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        getPageRecords1().getjTable1().getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
        getPageRecords1().getjTable1().getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        ReadSql readSql = new ReadSql();
        String sqlCode = "SELECT T2.FIRST_NAME || ' ' || T2.LAST_NAME AS PLAYER, T1.GOALS FROM "
                + "(SELECT T1.TEAM_ID, T2.GOAL_PLAYER_ID, COUNT(*) AS GOALS "
                + "FROM (SELECT TEAM_ID, MATCH_ID FROM MATCHES_EXTENDED "
                + matchFilterToSql() + ") T1 INNER JOIN GOALS T2 ON "
                + "T1.MATCH_ID = T2.MATCH_ID AND T1.TEAM_ID = T2.GOAL_TEAM_ID "
                + "GROUP BY T1.TEAM_ID, T2.GOAL_PLAYER_ID ) T1 "
                + "INNER JOIN PLAYERS T2 ON "
                + "T1.TEAM_ID = T2.TEAM_ID AND T1.GOAL_PLAYER_ID = T2.PLAYER_ID "
                + "ORDER BY T1.GOALS DESC";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            String player = resultSet.getString("PLAYER");
            int goals = resultSet.getInt("GOALS");
            model.addRow(new Object[]{player, goals});
        }
        statement.close();
    }
}
