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
    
    // get config.properties path
    public static String getConfigPath() {
        return getHtsPath() + "/config.properties";
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
    
}
