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

import static htsquirrel.FileManagement.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class DatabaseManagement {
    
    // create database connection
    public static Connection createDatabaseConnection()
            throws IOException,ClassNotFoundException, SQLException {
        deleteDatabaseDir();
        String dbUrl = "jdbc:h2:" + getDatabasePathShort();
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }
    
    // check if table exists
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
    
    // create teams table
    public static void createTeamsTable(Connection connection)
            throws SQLException {
        String sqlCode = "CREATE TABLE TEAMS (" +
                "USER_ID INT," +
                "LOGIN_NAME VARCHAR(255)," +
                "SUPPORTER_TIER VARCHAR(255)," +
                "TEAM_ID INT," +
                "TEAM_NAME VARCHAR(255)," +
                "SHORT_TEAM_NAME VARCHAR(255)," +
                "FOUNDED_DATE TIMESTAMP," +
                "PRIMARY_CLUB BOOLEAN," +
                "ARENA_ID INT," +
                "ARENA_NAME VARCHAR(255)," +
                "LEAGUE_ID INT," +
                "LEAGUE_NAME VARCHAR(255)," +
                "REGION_ID INT," +
                "REGION_NAME VARCHAR(255)," +
                "COACH_ID INT," +
                "LEAGUE_LEVEL_UNIT_ID INT," +
                "LEAGUE_LEVEL_UNIT_NAME VARCHAR(255)," +
                "LEAGUE_LEVEL INT," +
                "FANCLUB_ID INT," +
                "FANCLUB_NAME VARCHAR(255)," +
                "FANCLUB_SIZE INT," +
                "LOGO_URI VARCHAR(255)," +
                "DRESS_URI VARCHAR(255)," +
                "DRESS_ALTERNATE_URI VARCHAR(255)" +
                ")";
        Statement statement = connection.createStatement();
        statement.execute(sqlCode);
        statement.close();
    }
    
    // get team ids
    public static ArrayList<Integer> getTeamIds(Connection connection,
            int userId) throws SQLException {
        ArrayList<Integer> teamIds = new ArrayList<>();
        String sqlCode = "SELECT TEAM_ID FROM TEAMS " +
                "WHERE USER_ID = " + userId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlCode);
        while (resultSet.next()) {
            teamIds.add(resultSet.getInt("TEAM_ID"));
        }
        statement.close();
        return teamIds;
    }

}
