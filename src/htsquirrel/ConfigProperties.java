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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.scribe.model.Token;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class ConfigProperties {
    
    // get user id from config.properties
    public static int getUserIdProperty() throws IOException {
        String userId;
        int userIdProperty;
        if (!(configFileExists())) {
            createNewConfig();
        }
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(getConfigPath());
        properties.load(inputStream);
        userId = properties.getProperty("USER_ID", "0");
        try {
            userIdProperty = Integer.parseInt(userId);
        } catch (NumberFormatException ex) {
            userIdProperty = 0;
        }
        return userIdProperty;
    }
    
    // set all properties
    public static void setProperties(int userId,
            Token accessToken) throws IOException {
        if (!(configFileExists())) {
            createNewConfig();
        }
        Properties properties = new Properties();
        OutputStream outputStream = new FileOutputStream(getConfigPath());
        properties.setProperty("USER_ID", Integer.toString(userId));
        properties.setProperty("ACCESS_TOKEN", accessToken.getToken());
        properties.setProperty("ACCESS_SECRET", accessToken.getSecret());
        properties.store(outputStream, null);
        outputStream.close();
    }
    
}
