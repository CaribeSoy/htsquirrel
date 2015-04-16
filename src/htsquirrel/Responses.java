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
import htsquirrel.game.Match;
import htsquirrel.game.Team;
import htsquirrel.game.User;
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
    
    public static User getUser(OAuthService oAuthService,
            Token accessToken)
            throws ParserConfigurationException, SAXException, IOException {
        String xmlString = getResponse(oAuthService, accessToken,
                "teamdetails&version=3.2");
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element userElement = (Element) document.getElementsByTagName("User").item(0);
        int userId = Integer.parseInt(userElement.getElementsByTagName("UserID").item(0).getTextContent());
        String loginName = userElement.getElementsByTagName("Loginname").item(0).getTextContent();
        String supporterTier = userElement.getElementsByTagName("SupporterTier").item(0).getTextContent();
        User user = new User(userId, loginName, supporterTier);
        return user;
    }
    
    public static ArrayList<Match> getMatches(OAuthService oAuthService,
            Token accessToken, Team team, int season, Timestamp lastMatchDate)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Match> matches = new ArrayList<>();
        String xmlString = getResponse(oAuthService, accessToken,
                "matchesarchive&version=1.3&teamID=" + team.getTeamId() +
                        "&season=" + season);
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element matchListElement = (Element) document.getElementsByTagName("MatchList").item(0);
        NodeList matchNodes = matchListElement.getElementsByTagName("Match");
        if (matchNodes.getLength() > 0) {
            for (int matchCnt = 0; matchCnt < matchNodes.getLength(); matchCnt++) {
                Element matchElement = (Element) matchNodes.item(matchCnt);
                Timestamp matchDate = Timestamp.valueOf(matchElement.getElementsByTagName("MatchDate").item(0).getTextContent());
                if (matchDate.after(team.getFoundedDate()) & matchDate.after(lastMatchDate)) {
                    long matchId = Integer.parseInt(matchElement.getElementsByTagName("MatchID").item(0).getTextContent());
                    int homeTeamId = Integer.parseInt(matchElement.getElementsByTagName("HomeTeamID").item(0).getTextContent());
                    String homeTeamName = matchElement.getElementsByTagName("HomeTeamName").item(0).getTextContent();
                    homeTeamName = homeTeamName.replace("\'", "\'\'"); // TODO check this
                    int awayTeamId = Integer.parseInt(matchElement.getElementsByTagName("AwayTeamID").item(0).getTextContent());
                    String awayTeamName = matchElement.getElementsByTagName("AwayTeamName").item(0).getTextContent();
                    awayTeamName = awayTeamName.replace("\'", "\'\'"); // TODO check this
                    int matchType = Integer.parseInt(matchElement.getElementsByTagName("MatchType").item(0).getTextContent());
                    int matchContextId = Integer.parseInt(matchElement.getElementsByTagName("MatchContextId").item(0).getTextContent());
                    int cupLevel = Integer.parseInt(matchElement.getElementsByTagName("CupLevel").item(0).getTextContent());
                    int cupLevelIndex = Integer.parseInt(matchElement.getElementsByTagName("CupLevelIndex").item(0).getTextContent());
                    int homeGoals = Integer.parseInt(matchElement.getElementsByTagName("HomeGoals").item(0).getTextContent());
                    int awayGoals = Integer.parseInt(matchElement.getElementsByTagName("AwayGoals").item(0).getTextContent());
                    String teamName;
                    int opponentTeamId;
                    String opponentTeamName;
                    String venue;
                    int goalsFor;
                    int goalsAgainst;
                    if (homeTeamId == team.getTeamId()) {
                        teamName = homeTeamName;
                        opponentTeamId = awayTeamId;
                        opponentTeamName = awayTeamName;
                        venue = "Home";
                        goalsFor = homeGoals;
                        goalsAgainst = awayGoals;
                    } else {
                        teamName = awayTeamName;
                        opponentTeamId = homeTeamId;
                        opponentTeamName = homeTeamName;
                        venue = "Away";
                        goalsFor = awayGoals;
                        goalsAgainst = homeGoals;
                    }
                    Match match = new Match(matchId, team.getTeamId(),
                            teamName, opponentTeamId, opponentTeamName, venue,
                            matchDate, season, matchType, matchContextId,
                            cupLevel, cupLevelIndex, goalsFor, goalsAgainst);
                    matches.add(match);
                }
            }
        }
        return matches;
    }
    
}
