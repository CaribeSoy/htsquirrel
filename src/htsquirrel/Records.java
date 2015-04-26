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
package htsquirrel;

import static htsquirrel.database.DatabaseManagement.createDatabaseConnection;
import static htsquirrel.database.DatabaseManagement.sqlToString;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static int mapBoolean(boolean input, int valueTrue, int valueFalse) {
        int result = 999;
        if (input) {
            result = valueTrue;
        } else {
            result = valueFalse;
        }
        return result;
    }
    
    public static String matchFilterToSql()
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/match_filter.sql");
        sqlCode = sqlCode.replaceAll("\\bV_TEAM_ID\\b", String.valueOf(htsquirrel.HTSquirrel.currentTeam.getTeamId()));
        sqlCode = sqlCode.replaceAll("\\bV_MATCH_TYPE_L\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbLeague().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_MATCH_TYPE_Q\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbQualification().isSelected(), 2, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_MATCH_TYPE_HM\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbHattrickMasters().isSelected(), 7, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_MATCH_TYPE_FN\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbFriendlyNormal().isSelected(), 4, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_MATCH_TYPE_FC\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbFriendlyCup().isSelected(), 5, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_MATCH_TYPE_IFN\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbIntFriendlyNormal().isSelected(), 8, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_MATCH_TYPE_IFC\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbIntFriendlyCup().isSelected(), 9, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_N\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbNationalCup().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_INDEX_NE\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbNationalEmerald().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_INDEX_NR\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbNationalRuby().isSelected(), 2, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_INDEX_NS\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbNationalSapphire().isSelected(), 3, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_NC\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbNationalConsolation().isSelected(), 3, 999)));
        String cupLevels = "(999";
        if (htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbLevel7().isSelected()) cupLevels = cupLevels + ", 7";
        if (htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbLevel8().isSelected()) cupLevels = cupLevels + ", 8";
        if (htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbLevel9().isSelected()) cupLevels = cupLevels + ", 9";
        cupLevels = cupLevels + ")";
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEAGUE_LEVEL_D\\b", cupLevels);
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_D\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbDivisionalCup().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_INDEX_DE\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbDivisionalEmerald().isSelected(), 1, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_INDEX_DR\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbDivisionalRuby().isSelected(), 2, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_INDEX_DS\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbDivisionalSapphire().isSelected(), 3, 999)));
        sqlCode = sqlCode.replaceAll("\\bV_CUP_LEVEL_DC\\b", String.valueOf(mapBoolean(htsquirrel.HTSquirrel.getMatchFilter().getMatchType().getCbDivisionalConsolation().isSelected(), 3, 999)));
        return sqlCode;
    }
    
    public static void showTotalTeamScore(Connection connection)
            throws SQLException, IOException {
        String sqlCode = sqlToString("htsquirrel/database/sql/total_team_score.sql");
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
            htsquirrel.gui.pages.RecordsType1.showLabel2(text);
        }
        statement.close();

    }
    
}
