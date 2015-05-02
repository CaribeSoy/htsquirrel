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

import htsquirrel.game.Team;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
