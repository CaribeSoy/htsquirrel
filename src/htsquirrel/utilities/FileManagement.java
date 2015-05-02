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
package htsquirrel.utilities;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class FileManagement {
    
    private static String getHomePath() {
        return System.getProperty("user.home");
    }
    
    private static String getHtsPath() {
        return getHomePath() + "/.htsquirrel";
    }
    
    public static String getConfigPath() {
        return getHtsPath() + "/config.properties";
    }
    
    private static boolean htsFileExists() {
        boolean result = false;
        File htsPath = new File(getHtsPath());
        if (htsPath.exists() & htsPath.isFile()) {
            result = true;
        }
        return result;
    }
    
    private static boolean htsDirExists() {
        boolean result = false;
        File htsPath = new File(getHtsPath());
        if (htsPath.exists() & htsPath.isDirectory()) {
            result = true;
        }
        return result;
    }
    
    public static boolean configFileExists() {
        boolean result = false;
        File configPath = new File(getConfigPath());
        if (configPath.exists() & configPath.isFile()) {
            result = true;
        }
        return result;
    }
    
    private static boolean configDirExists() {
        boolean result = false;
        File configPath = new File(getConfigPath());
        if (configPath.exists() & configPath.isDirectory()) {
            result = true;
        }
        return result;
    }
    
    public static void createConfigFile() throws IOException {
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
