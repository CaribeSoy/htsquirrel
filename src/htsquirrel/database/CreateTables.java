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

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class CreateTables {
    
    public static void createAllTables(Connection connection)
            throws SQLException, IOException {
        createTeamsTable(connection);
        createMatchesTable(connection);
        createMatchDetailsTable(connection);
        createCupsTable(connection);
        createRefereesTable(connection);
        createGoalsTable(connection);
        createBookingsTable(connection);
        createInjuriesTable(connection);
        createEventsTable(connection);
        createLeagueIdsTable(connection);
        createLeagueNamesTable(connection);
        createLeaguesTable(connection);
        createMatchesExtendedTable(connection);
        createTransfersTable(connection);
        createStartingLineupsTable(connection);
        createSubstitutionsTable(connection);
        createLineupsTable(connection);
        createPlayersTable(connection);
    }
    
    private static void createTeamsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/teams.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createMatchesTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/matches.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createMatchDetailsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/match_details.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createCupsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/cups.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createRefereesTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/referees.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createGoalsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/goals.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createBookingsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/bookings.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createInjuriesTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/injuries.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createEventsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/events.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createLeagueIdsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/league_ids.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createLeagueNamesTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/league_names.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createLeaguesTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/leagues.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createMatchesExtendedTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/matches_extended.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createTransfersTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/transfers.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createStartingLineupsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/starting_lineups.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createSubstitutionsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/substitutions.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createLineupsTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/lineups.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    private static void createPlayersTable(Connection connection)
            throws SQLException, IOException {
        ReadSql readSql = new ReadSql();
        String sqlCode = readSql.sqlToString("htsquirrel/database/sql/create/players.sql");
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
}
