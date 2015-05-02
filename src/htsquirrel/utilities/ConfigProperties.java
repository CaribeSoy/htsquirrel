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

import static htsquirrel.utilities.FileManagement.configFileExists;
import static htsquirrel.utilities.FileManagement.createConfigFile;
import static htsquirrel.utilities.FileManagement.getConfigPath;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class ConfigProperties {
    
    public static String getLanguageProperty() throws IOException {
        String language = "";
        if (!(configFileExists())) {
            createConfigFile();
        }
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(getConfigPath());
        properties.load(inputStream);
        language = properties.getProperty("LANGUAGE", "");
        if (!(languageExists(language))) {
            language = "";
        }
        return language;
    }
    
    private static boolean languageExists(String language) {
        boolean result = false;
        if ("English".equals(language)
            || "Srpski".equals(language)) {
            result = true;
        }
        return result;
    }
    
}
