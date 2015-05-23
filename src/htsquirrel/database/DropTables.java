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

import static htsquirrel.database.DatabaseManagement.tableExists;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class DropTables {
    
    public static void dropAllTables(Connection connection)
            throws SQLException {
        if (tableExists(connection, "TEAMS")) dropTeamsTable(connection);
        if (tableExists(connection, "MATCHES")) dropMatchesTable(connection);
        if (tableExists(connection, "MATCH_DETAILS")) dropMatchDetailsTable(connection);
        if (tableExists(connection, "CUPS")) dropCupsTable(connection);
        if (tableExists(connection, "REFEREES")) dropRefereesTable(connection);
        if (tableExists(connection, "GOALS")) dropGoalsTable(connection);
        if (tableExists(connection, "BOOKINGS")) dropBookingsTable(connection);
        if (tableExists(connection, "INJURIES")) dropInjuriesTable(connection);
        if (tableExists(connection, "EVENTS")) dropEventsTable(connection);
        if (tableExists(connection, "LEAGUE_IDS")) dropLeagueIdsTable(connection);
        if (tableExists(connection, "LEAGUE_NAMES")) dropLeagueNamesTable(connection);
        if (tableExists(connection, "LEAGUES")) dropLeaguesTable(connection);
        if (tableExists(connection, "MATCHES_EXTENDED")) dropMatchesExtendedTable(connection);
        if (tableExists(connection, "TRANSFERS")) dropTransfersTable(connection);
        if (tableExists(connection, "STARTING_LINEUPS")) dropStartingLineupsTable(connection);
        if (tableExists(connection, "SUBSTITUTIONS")) dropSubstitutionsTable(connection);
        if (tableExists(connection, "LINEUPS")) dropLineupsTable(connection);
        if (tableExists(connection, "PLAYERS")) dropPlayersTable(connection);
    }
    
    private static void dropTeamsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE TEAMS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropMatchesTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE MATCHES";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropMatchDetailsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE MATCH_DETAILS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropCupsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE CUPS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropRefereesTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE REFEREES";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropGoalsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE GOALS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropBookingsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE BOOKINGS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropInjuriesTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE INJURIES";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropEventsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE EVENTS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropLeagueIdsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE LEAGUE_IDS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropLeagueNamesTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE LEAGUE_NAMES";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropLeaguesTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE LEAGUES";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropMatchesExtendedTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE MATCHES_EXTENDED";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropTransfersTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE TRANSFERS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropStartingLineupsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE STARTING_LINEUPS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropSubstitutionsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE SUBSTITUTIONS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropLineupsTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE LINEUPS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void dropPlayersTable(Connection connection)
            throws SQLException {
        String sqlCode = "DROP TABLE PLAYERS";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
}
