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
package htsquirrel.translations;

import static htsquirrel.HTSquirrel.getLanguage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Translations {
    
    public Properties getTranslations(String language) throws IOException {
        Properties properties = new Properties();
        String translationsPath = "htsquirrel/translations/" + language + ".properties";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(translationsPath);
        properties.load(inputStream);
        return properties;
    }
    
    public static ArrayList<String> getSkillLevels() {
        ArrayList<String> result = new ArrayList<>();
        if ("English".equals(getLanguage())) {
            result.add("Non-existent (0)");
            result.add("Disastrous (1)");
            result.add("Wretched (2)");
            result.add("Poor (3)");
            result.add("Weak (4)");
            result.add("Inadequate (5)");
            result.add("Passable (6)");
            result.add("Solid (7)");
            result.add("Excellent (8)");
            result.add("Formidable (9)");
            result.add("Outstanding (10)");
            result.add("Brilliant (11)");
            result.add("Magnificent (12)");
            result.add("World class (13)");
            result.add("Supernatural (14)");
            result.add("Titanic (15)");
            result.add("Extra-terrestrial (16)");
            result.add("Mythical (17)");
            result.add("Magical (18)");
            result.add("Utopian (19)");
            result.add("Divine (20)");
        }
        if ("Srpski".equals(getLanguage())) {
            result.add("Nepostojeći (0)");
            result.add("Katastrofalan (1)");
            result.add("Očajan (2)");
            result.add("Jadan (3)");
            result.add("Slab (4)");
            result.add("Nedovoljan (5)");
            result.add("Prosečan (6)");
            result.add("Dobar (7)");
            result.add("Odličan (8)");
            result.add("Silan (9)");
            result.add("Izuzetan (10)");
            result.add("Briljantan (11)");
            result.add("Fantastičan (12)");
            result.add("Svetska klasa (13)");
            result.add("Natprirodan (14)");
            result.add("Veličanstven (15)");
            result.add("Legendaran (16)");
            result.add("Epski (17)");
            result.add("Magičan (18)");
            result.add("Savršen (19)");
            result.add("Božanski (20)");
        }
        return result;
    }
    
}
