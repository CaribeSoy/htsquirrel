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
package htsquirrel.oauth;

import htsquirrel.game.Cup;
import htsquirrel.game.League;
import htsquirrel.game.Match;
import htsquirrel.game.Team;
import htsquirrel.game.Transfer;
import htsquirrel.game.User;
import static htsquirrel.oauth.OAuth.getResponse;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Aleksandar Cvetković <arcvetkovic@gmail.com>
 */
public class Responses {
    
    public static int getUserIdFromHt(OAuthService oAuthService, Token accessToken)
            throws ParserConfigurationException, SAXException, IOException {
        int userId;
        String xmlString = getResponse(oAuthService, accessToken, "teamdetails&version=3.2");
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element userElement = (Element) document.getElementsByTagName("User").item(0);
        userId = Integer.parseInt(userElement.getElementsByTagName("UserID").item(0).getTextContent());
        return userId;
    }
    
    public static User getUserFromHt(String xmlString)
            throws ParserConfigurationException, SAXException, IOException {
        User user = new User();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element userElement = (Element) document.getElementsByTagName("User").item(0);
        user.setUserId(Integer.parseInt(userElement.getElementsByTagName("UserID").item(0).getTextContent()));
        user.setLoginName(userElement.getElementsByTagName("Loginname").item(0).getTextContent());
        user.setSupporterTier(userElement.getElementsByTagName("SupporterTier").item(0).getTextContent());
        return user;
    }
    
    public static ArrayList<Team> getTeamsFromHt(String xmlString)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Team> teams = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element teamsElement = (Element) document.getElementsByTagName("Teams").item(0);
        NodeList teamNodes = teamsElement.getElementsByTagName("Team");
        for (int teamCnt = 0; teamCnt < teamNodes.getLength(); teamCnt++) {
            Team team = new Team();
            Element teamElement = (Element) teamNodes.item(teamCnt);
            team.setTeamId(Integer.parseInt(teamElement.getElementsByTagName("TeamID").item(0).getTextContent()));
            team.setTeamName(teamElement.getElementsByTagName("TeamName").item(0).getTextContent());
            team.setShortTeamName(teamElement.getElementsByTagName("ShortTeamName").item(0).getTextContent());
            team.setFoundedDate(Timestamp.valueOf(teamElement.getElementsByTagName("FoundedDate").item(0).getTextContent()));
            team.setPrimaryClub("True".equals(teamElement.getElementsByTagName("IsPrimaryClub").item(0).getTextContent()));
            team.setArenaId(Integer.parseInt(teamElement.getElementsByTagName("ArenaID").item(0).getTextContent()));
            team.setArenaName(teamElement.getElementsByTagName("ArenaName").item(0).getTextContent());
            team.setLeagueId(Integer.parseInt(teamElement.getElementsByTagName("LeagueID").item(0).getTextContent()));
            team.setLeagueName(teamElement.getElementsByTagName("LeagueName").item(0).getTextContent());
            team.setRegionId(Integer.parseInt(teamElement.getElementsByTagName("RegionID").item(0).getTextContent()));
            team.setRegionName(teamElement.getElementsByTagName("RegionName").item(0).getTextContent());
            team.setCoachId(Integer.parseInt(teamElement.getElementsByTagName("PlayerID").item(0).getTextContent()));
            team.setLeagueLevelUnitId(Integer.parseInt(teamElement.getElementsByTagName("LeagueLevelUnitID").item(0).getTextContent()));
            team.setLeagueLevelUnitName(teamElement.getElementsByTagName("LeagueLevelUnitName").item(0).getTextContent());
            team.setLeagueLevel(Integer.parseInt(teamElement.getElementsByTagName("LeagueLevel").item(0).getTextContent()));
            team.setFanclubId(Integer.parseInt(teamElement.getElementsByTagName("FanclubID").item(0).getTextContent()));
            team.setFanclubName(teamElement.getElementsByTagName("FanclubName").item(0).getTextContent());
            team.setFanclubSize(Integer.parseInt(teamElement.getElementsByTagName("FanclubSize").item(0).getTextContent()));
            team.setLogoUri(teamElement.getElementsByTagName("LogoURL").item(0).getTextContent());
            team.setDressUri(teamElement.getElementsByTagName("DressURI").item(0).getTextContent());
            team.setDressAlternateUri(teamElement.getElementsByTagName("DressAlternateURI").item(0).getTextContent());
            teams.add(team);
        }
        return teams;
    }
    
    public static ArrayList<Cup> getCupsFromHt(String xmlString, Team team)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Cup> cups = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element cupsElement = (Element) document.getElementsByTagName("Cups").item(0);
        NodeList cupNodes = cupsElement.getElementsByTagName("Cup");
        if (cupNodes.getLength() > 0) {
            for (int cupCnt = 0; cupCnt < cupNodes.getLength(); cupCnt++) {
                Cup cup = new Cup();
                Element cupElement = (Element) cupNodes.item(cupCnt);
                cup.setTeamId(team.getTeamId());
                cup.setCupId(Integer.parseInt(cupElement.getElementsByTagName("CupID").item(0).getTextContent()));
                cup.setCupName(cupElement.getElementsByTagName("CupName").item(0).getTextContent());
                cup.setCupLeagueLevel(Integer.parseInt(cupElement.getElementsByTagName("CupLeagueLevel").item(0).getTextContent()));
                cup.setCupLevel(Integer.parseInt(cupElement.getElementsByTagName("CupLevel").item(0).getTextContent()));
                cup.setCupLevelIndex(Integer.parseInt(cupElement.getElementsByTagName("CupLevelIndex").item(0).getTextContent()));
                cups.add(cup);
            }
        }
        return cups;
    }
    
    public static int getTransferPagesFromHt(String xmlString)
            throws ParserConfigurationException, SAXException, IOException {
        int transferPages = 0;
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element transfersElement = (Element) document.getElementsByTagName("Transfers").item(0);
        transferPages = Integer.parseInt(transfersElement.getElementsByTagName("Pages").item(0).getTextContent());
        return transferPages;
    }
    
    public static ArrayList<Transfer> getTransfersFromHt(String xmlString, Team team)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Transfer> transfers = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element transfersElement = (Element) document.getElementsByTagName("Transfers").item(0);
        NodeList transferNodes = transfersElement.getElementsByTagName("Transfer");
        if (transferNodes.getLength() > 0) {
            for (int transferCnt = 0; transferCnt < transferNodes.getLength(); transferCnt++) {
                Element transferElement = (Element) transferNodes.item(transferCnt);
                Transfer transfer = new Transfer();
                transfer.setTeamId(team.getTeamId());
                transfer.setTransferId(Integer.parseInt(transferElement.getElementsByTagName("TransferID").item(0).getTextContent()));
                transfer.setDeadline(Timestamp.valueOf(transferElement.getElementsByTagName("Deadline").item(0).getTextContent()));
                transfer.setPlayerId(Integer.parseInt(transferElement.getElementsByTagName("PlayerID").item(0).getTextContent()));
                transfer.setPlayerName(transferElement.getElementsByTagName("PlayerName").item(0).getTextContent());
                transfer.setTsi(Integer.parseInt(transferElement.getElementsByTagName("TSI").item(0).getTextContent()));
                transfer.setTransferType(transferElement.getElementsByTagName("TransferType").item(0).getTextContent());
                transfer.setBuyerTeamId(Integer.parseInt(transferElement.getElementsByTagName("BuyerTeamID").item(0).getTextContent()));
                transfer.setBuyerTeamName(transferElement.getElementsByTagName("BuyerTeamName").item(0).getTextContent());
                transfer.setSellerTeamId(Integer.parseInt(transferElement.getElementsByTagName("SellerTeamID").item(0).getTextContent()));
                transfer.setSellerTeamName(transferElement.getElementsByTagName("SellerTeamName").item(0).getTextContent());
                transfer.setPrice(Integer.parseInt(transferElement.getElementsByTagName("Price").item(0).getTextContent()));
                transfers.add(transfer);
            }
        }
        return transfers;
    }
    
    public static int getSeasonFromHt(OAuthService oAuthService, Token accessToken,
            Team team) throws ParserConfigurationException, SAXException,
            IOException {
        String xmlString = getResponse(oAuthService, accessToken,
                "worlddetails&version=1.6&leagueID=" + team.getLeagueId());
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        int season = Integer.parseInt(document.getElementsByTagName("Season").item(0).getTextContent());
        return season;
    }
    
    public static ArrayList<Match> getMatchesFromHt(OAuthService oAuthService,
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
                    Match match = new Match();
                    match.setTeamId(team.getTeamId());
                    match.setSeason(season);
                    match.setMatchDate(matchDate);
                    match.setMatchId(Integer.parseInt(matchElement.getElementsByTagName("MatchID").item(0).getTextContent()));
                    match.setMatchType(Integer.parseInt(matchElement.getElementsByTagName("MatchType").item(0).getTextContent()));
                    match.setMatchContextId(Integer.parseInt(matchElement.getElementsByTagName("MatchContextId").item(0).getTextContent()));
                    match.setCupLevel(Integer.parseInt(matchElement.getElementsByTagName("CupLevel").item(0).getTextContent()));
                    match.setCupLevelIndex(Integer.parseInt(matchElement.getElementsByTagName("CupLevelIndex").item(0).getTextContent()));
                    int homeTeamId = Integer.parseInt(matchElement.getElementsByTagName("HomeTeamID").item(0).getTextContent());
                    String homeTeamName = matchElement.getElementsByTagName("HomeTeamName").item(0).getTextContent();
                    int awayTeamId = Integer.parseInt(matchElement.getElementsByTagName("AwayTeamID").item(0).getTextContent());
                    String awayTeamName = matchElement.getElementsByTagName("AwayTeamName").item(0).getTextContent();
                    int homeGoals = Integer.parseInt(matchElement.getElementsByTagName("HomeGoals").item(0).getTextContent());
                    int awayGoals = Integer.parseInt(matchElement.getElementsByTagName("AwayGoals").item(0).getTextContent());
                    if (homeTeamId == team.getTeamId()) {
                        match.setTeamName(homeTeamName);
                        match.setOpponentTeamId(awayTeamId);
                        match.setOpponentTeamName(awayTeamName);
                        match.setVenue("Home");
                        match.setGoalsFor(homeGoals);
                        match.setGoalsAgainst(awayGoals);
                    } else {
                        match.setTeamName(awayTeamName);
                        match.setOpponentTeamId(homeTeamId);
                        match.setOpponentTeamName(homeTeamName);
                        match.setVenue("Away");
                        match.setGoalsFor(awayGoals);
                        match.setGoalsAgainst(homeGoals);
                    }
                    matches.add(match);
                }
            }
        }
        return matches;
    }
    
    public static int getLeagueIdFromSeasonFromHt(OAuthService oAuthService,
            Token accessToken, Team team, int season)
            throws ParserConfigurationException, SAXException, IOException {
        int leagueId = 0;
        String xmlString = getResponse(oAuthService, accessToken,
                "matchesarchive&version=1.3&teamID=" + team.getTeamId() +
                        "&season=" + season);
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element matchListElement = (Element) document.getElementsByTagName("MatchList").item(0);
        NodeList matchNodes = matchListElement.getElementsByTagName("Match");
        for (int matchCnt = 0; matchCnt < matchNodes.getLength(); matchCnt++) {
            Element matchElement = (Element) matchNodes.item(matchCnt);
            int matchType = Integer.parseInt(matchElement.getElementsByTagName("MatchType").item(0).getTextContent());
            int matchContextId = Integer.parseInt(matchElement.getElementsByTagName("MatchContextId").item(0).getTextContent());
            if (matchType == 1) {
                leagueId = matchContextId;
            }
        }
        return leagueId;
    }
    
    public static League getLeagueFromHt(OAuthService oAuthService, Token accessToken,
            int leagueLevelUnitId)
            throws ParserConfigurationException, SAXException, IOException {
        League league = new League();
        String xmlString = getResponse(oAuthService, accessToken,
                "leaguedetails&version=1.4&leagueLevelUnitID="
                        + leagueLevelUnitId);
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        league.setLeagueLevelUnitId(leagueLevelUnitId);
        Element leagueLevelElement = (Element) document.getElementsByTagName("LeagueLevel").item(0);
        Element leagueLevelUnitNameElement = (Element) document.getElementsByTagName("LeagueLevelUnitName").item(0);
        league.setLeagueLevel(Integer.parseInt(leagueLevelElement.getTextContent()));
        league.setLeagueLevelUnitName(leagueLevelUnitNameElement.getTextContent());
        return league;
    }
    
    public static Document xmlStringToDoc(String xmlString)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource inputSource = new InputSource(new StringReader(xmlString));
        Document document = dBuilder.parse(inputSource);
        return document;
    }
    
}
