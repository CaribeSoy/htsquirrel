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

import static htsquirrel.DownloadManagement.*;
import static htsquirrel.OAuth.*;
import htsquirrel.game.Team;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Responses {
    
    public static int getUserId(OAuthService oAuthService,
            Token accessToken)
            throws ParserConfigurationException, SAXException, IOException {
        int userId;
        String xmlString = getResponse(oAuthService, accessToken,
                "teamdetails&version=3.2");
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element userElement = (Element) document.getElementsByTagName("User").item(0);
        userId = Integer.parseInt(userElement.getElementsByTagName("UserID").item(0).getTextContent());
        return userId;
    }
    
    public static ArrayList<Team> getTeams(OAuthService oAuthService,
            Token accessToken)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Team> teams = new ArrayList<>();
        String xmlString = getResponse(oAuthService, accessToken,
                "teamdetails&version=3.2");
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element teamsElement = (Element) document.getElementsByTagName("Teams").item(0);
        NodeList teamNodes = teamsElement.getElementsByTagName("Team");
        for (int teamCnt = 0; teamCnt < teamNodes.getLength(); teamCnt++) {
            Element teamElement = (Element) teamNodes.item(teamCnt);
            int teamId = Integer.parseInt(teamElement.getElementsByTagName("TeamID").item(0).getTextContent());
            String teamName = teamElement.getElementsByTagName("TeamName").item(0).getTextContent();
            String shortTeamName = teamElement.getElementsByTagName("ShortTeamName").item(0).getTextContent();
            Timestamp foundedDate = Timestamp.valueOf(teamElement.getElementsByTagName("FoundedDate").item(0).getTextContent());
            boolean primaryClub = "True".equals(teamElement.getElementsByTagName("IsPrimaryClub").item(0).getTextContent());
            int arenaId = Integer.parseInt(teamElement.getElementsByTagName("ArenaID").item(0).getTextContent());
            String arenaName = teamElement.getElementsByTagName("ArenaName").item(0).getTextContent();
            int leagueId = Integer.parseInt(teamElement.getElementsByTagName("LeagueID").item(0).getTextContent());
            String leagueName = teamElement.getElementsByTagName("LeagueName").item(0).getTextContent();
            int regionId = Integer.parseInt(teamElement.getElementsByTagName("RegionID").item(0).getTextContent());
            String regionName = teamElement.getElementsByTagName("RegionName").item(0).getTextContent();
            int coachId = Integer.parseInt(teamElement.getElementsByTagName("PlayerID").item(0).getTextContent());
            int leagueLevelUnitId = Integer.parseInt(teamElement.getElementsByTagName("LeagueLevelUnitID").item(0).getTextContent());
            String leagueLevelUnitName = teamElement.getElementsByTagName("LeagueLevelUnitName").item(0).getTextContent();
            int leagueLevel = Integer.parseInt(teamElement.getElementsByTagName("LeagueLevel").item(0).getTextContent());
            int fanclubId = Integer.parseInt(teamElement.getElementsByTagName("FanclubID").item(0).getTextContent());
            String fanclubName = teamElement.getElementsByTagName("FanclubName").item(0).getTextContent();
            int fanclubSize = Integer.parseInt(teamElement.getElementsByTagName("FanclubSize").item(0).getTextContent());
            String logoUri = teamElement.getElementsByTagName("LogoURL").item(0).getTextContent();
            String dressUri = teamElement.getElementsByTagName("DressURI").item(0).getTextContent();
            String dressAlternateUri = teamElement.getElementsByTagName("DressAlternateURI").item(0).getTextContent();
            Team team = new Team(teamId, teamName, shortTeamName, foundedDate,
            primaryClub, arenaId, arenaName, leagueId, leagueName, regionId,
            regionName, coachId, leagueLevelUnitId, leagueLevelUnitName,
            leagueLevel, fanclubId, fanclubName, fanclubSize, logoUri, dressUri,
            dressAlternateUri);
            teams.add(team);
        }
        return teams;
    }
    
}
