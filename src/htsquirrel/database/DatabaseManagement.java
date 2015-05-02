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

import static htsquirrel.database.CreateTables.createAllTables;
import static htsquirrel.database.DropTables.dropAllTables;
import static htsquirrel.utilities.FileManagement.deleteDatabaseDir;
import static htsquirrel.utilities.FileManagement.getDatabasePathShort;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class DatabaseManagement {
    
    public static Connection createDatabaseConnection()
            throws ClassNotFoundException, SQLException {
        deleteDatabaseDir();
        String dbUrl = "jdbc:h2:" + getDatabasePathShort();
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }
    
    public static void ensureTablesExist(Connection connection)
            throws SQLException, IOException {
        boolean allExist = true;
        if (!(tableExists(connection, "TEAMS"))) allExist = false;
        if (!(tableExists(connection, "MATCHES"))) allExist = false;
        if (!(tableExists(connection, "MATCH_DETAILS"))) allExist = false;
        if (!(tableExists(connection, "CUPS"))) allExist = false;
        if (!(tableExists(connection, "REFEREES"))) allExist = false;
        if (!(tableExists(connection, "GOALS"))) allExist = false;
        if (!(tableExists(connection, "BOOKINGS"))) allExist = false;
        if (!(tableExists(connection, "INJURIES"))) allExist = false;
        if (!(tableExists(connection, "EVENTS"))) allExist = false;
        if (!(tableExists(connection, "LEAGUE_IDS"))) allExist = false;
        if (!(tableExists(connection, "LEAGUE_NAMES"))) allExist = false;
        if (!(tableExists(connection, "LEAGUES"))) allExist = false;
        if (!(tableExists(connection, "MATCHES_EXTENDED"))) allExist = false;
        if (!(tableExists(connection, "TRANSFERS"))) allExist = false;
        if (!(allExist)) {
            dropAllTables(connection);
            createAllTables(connection);
        }
    }
    
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
    
}
