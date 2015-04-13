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

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class FileManagement {

    // get user home directory path
    public static String getHomePath() {
        return System.getProperty("user.home");
    }

    // get .htsquirrel directory path
    public static String getHtsPath() {
        return getHomePath() + "/.htsquirrel";
    }

    // get config.properties file path
    public static String getConfigPath() {
        return getHtsPath() + "/config.properties";
    }

    // get database file path
    public static String getDatabasePath() {
        return getHtsPath() + "/htsquirrel.h2.db";
    }
    
    // get database file path short
    public static String getDatabasePathShort() {
        return getHtsPath() + "/htsquirrel";
    }

    // check if .htsquirrel directory exists
    public static boolean htsDirExists() {
        boolean result = false;
        File htsPath = new File(getHtsPath());
        if (htsPath.exists() & htsPath.isDirectory()) {
            result = true;
        }
        return result;
    }

    // check if .htsquirrel file exists
    public static boolean htsFileExists() {
        boolean result = false;
        File htsPath = new File(getHtsPath());
        if (htsPath.exists() & htsPath.isFile()) {
            result = true;
        }
        return result;
    }

    // check if config.properties file exists
    public static boolean configFileExists() {
        boolean result = false;
        File configPath = new File(getConfigPath());
        if (configPath.exists() & configPath.isFile()) {
            result = true;
        }
        return result;
    }

    // check if config.properties directory exists
    public static boolean configDirExists() {
        boolean result = false;
        File configPath = new File(getConfigPath());
        if (configPath.exists() & configPath.isDirectory()) {
            result = true;
        }
        return result;
    }

    // check if database directory exists
    public static boolean databaseDirExists() {
        boolean result = false;
        File databasePath = new File(getDatabasePath());
        if (databasePath.exists() & databasePath.isDirectory()) {
            result = true;
        }
        return result;
    }

    // check if database file exists
    public static boolean databaseFileExists() {
        boolean result = false;
        File databasePath = new File(getDatabasePath());
        if (databasePath.exists() & databasePath.isFile()) {
            result = true;
        }
        return result;
    }

    // create new config.properties file
    public static void createNewConfig() throws IOException {
        if (htsFileExists()) {
            File htsPath = new File(getHtsPath());
            htsPath.delete();
        }
        if (!(htsDirExists())) {
            File htsPath = new File(getHtsPath());
            htsPath.mkdir();
        }
        if (configDirExists()) {
            File configPath = new File(getConfigPath());
            deleteDir(configPath);
        }
        if (configFileExists()) {
            File configPath = new File(getConfigPath());
            configPath.delete();
        }
        File configPath = new File(getConfigPath());
        configPath.createNewFile();
    }

    // delete database directory
    public static void deleteDatabaseDir() throws IOException {
        if (databaseDirExists()) {
            File databasePath = new File(getDatabasePath());
            deleteDir(databasePath);
        }
    }

    // delete directory
    private static void deleteDir(File directory) {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                deleteDir(file);
                file.delete();
            } else {
                file.delete();
            }
        }
        directory.delete();
    }

}
