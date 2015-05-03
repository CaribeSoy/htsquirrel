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
import htsquirrel.game.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class DeleteFrom {
    
    public static void deleteFromTeams(Connection connection, User user)
            throws SQLException {
        String sqlCode = "DELETE FROM TEAMS WHERE USER_ID = " +
                user.getUserId();
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void deleteFromCups(Connection connection, Team team)
            throws SQLException {
        String sqlCode = "DELETE FROM CUPS WHERE TEAM_ID = " +
                team.getTeamId();
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void deleteFromTransfers(Connection connection, Team team)
            throws SQLException {
        String sqlCode = "DELETE FROM TRANSFERS WHERE TEAM_ID = " +
                team.getTeamId();
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void deleteFromLeagueIds(Connection connection)
            throws SQLException {
        String sqlCode = "DELETE FROM LEAGUE_IDS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void deleteFromLeagueNames(Connection connection)
            throws SQLException {
        String sqlCode = "DELETE FROM LEAGUE_NAMES";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    public static void deleteFromLeagues(Connection connection)
            throws SQLException, IOException {
        String sqlCode = "DELETE FROM LEAGUES";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
}
