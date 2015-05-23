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

import htsquirrel.game.Booking;
import htsquirrel.game.Cup;
import htsquirrel.game.Event;
import htsquirrel.game.Goal;
import htsquirrel.game.Injury;
import htsquirrel.game.League;
import htsquirrel.game.Match;
import htsquirrel.game.MatchDetails;
import htsquirrel.game.Referee;
import htsquirrel.game.StartingLineup;
import htsquirrel.game.Substitution;
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
    
    public static MatchDetails getMatchDetailsFromHt(String xmlString, Match match)
            throws ParserConfigurationException, SAXException, IOException {
        MatchDetails matchDetails = new MatchDetails();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element matchElement = (Element) document.getElementsByTagName("Match").item(0);
        matchDetails.setMatchId(match.getMatchId());
        matchDetails.setTeamId(match.getTeamId());
        matchDetails.setTeamName(match.getTeamName());
        matchDetails.setOpponentTeamId(match.getOpponentTeamId());
        matchDetails.setOpponentTeamName(match.getOpponentTeamName());
        matchDetails.setGoalsFor(match.getGoalsFor());
        matchDetails.setGoalsAgainst(match.getGoalsAgainst());
        matchDetails.setMatchType(match.getMatchType());
        matchDetails.setMatchContextId(match.getMatchContextId());
        matchDetails.setCupLevel(match.getCupLevel());
        matchDetails.setCupLevelIndex(match.getCupLevelIndex());
        matchDetails.setSeason(match.getSeason());
        matchDetails.setMatchDate(match.getMatchDate());
        matchDetails.setFinishedDate(Timestamp.valueOf(matchElement.getElementsByTagName("FinishedDate").item(0).getTextContent()));
        matchDetails.setVenue(match.getVenue());
        matchDetails.setArenaId(Integer.parseInt(matchElement.getElementsByTagName("ArenaID").item(0).getTextContent()));
        matchDetails.setArenaName(matchElement.getElementsByTagName("ArenaName").item(0).getTextContent());
        matchDetails.setSoldTotal(Integer.parseInt(matchElement.getElementsByTagName("SoldTotal").item(0).getTextContent()));
        matchDetails.setSoldTerraces(-1);
        matchDetails.setSoldBasic(-1);
        matchDetails.setSoldRoof(-1);
        matchDetails.setSoldVip(-1);
        matchDetails.setWeatherId(Integer.parseInt(matchElement.getElementsByTagName("WeatherID").item(0).getTextContent()));
        int homeTeamId = Integer.parseInt(matchElement.getElementsByTagName("HomeTeamID").item(0).getTextContent());
        if (homeTeamId == match.getTeamId()) {
            matchDetails.setSoldTerraces(Integer.parseInt(matchElement.getElementsByTagName("SoldTerraces").item(0).getTextContent()));
            matchDetails.setSoldBasic(Integer.parseInt(matchElement.getElementsByTagName("SoldBasic").item(0).getTextContent()));
            matchDetails.setSoldRoof(Integer.parseInt(matchElement.getElementsByTagName("SoldRoof").item(0).getTextContent()));
            matchDetails.setSoldVip(Integer.parseInt(matchElement.getElementsByTagName("SoldVIP").item(0).getTextContent()));
            Element homeTeamElement = (Element) matchElement.getElementsByTagName("HomeTeam").item(0);
            matchDetails.setDressUri(homeTeamElement.getElementsByTagName("DressURI").item(0).getTextContent());
            matchDetails.setFormation(homeTeamElement.getElementsByTagName("Formation").item(0).getTextContent());
            matchDetails.setTacticType(Integer.parseInt(homeTeamElement.getElementsByTagName("TacticType").item(0).getTextContent()));
            matchDetails.setTacticSkill(Integer.parseInt(homeTeamElement.getElementsByTagName("TacticSkill").item(0).getTextContent()));
            matchDetails.setTeamAttitude(Integer.parseInt(homeTeamElement.getElementsByTagName("TeamAttitude").item(0).getTextContent()));
            matchDetails.setRatingM(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidfield").item(0).getTextContent()));
            matchDetails.setRatingRD(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingRightDef").item(0).getTextContent()));
            matchDetails.setRatingCD(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidDef").item(0).getTextContent()));
            matchDetails.setRatingLD(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingLeftDef").item(0).getTextContent()));
            matchDetails.setRatingRA(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingRightAtt").item(0).getTextContent()));
            matchDetails.setRatingCA(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidAtt").item(0).getTextContent()));
            matchDetails.setRatingLA(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingLeftAtt").item(0).getTextContent()));
            matchDetails.setRatingISPD(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingIndirectSetPiecesDef").item(0).getTextContent()));
            matchDetails.setRatingISPA(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingIndirectSetPiecesAtt").item(0).getTextContent()));
            matchDetails.setPossession1(Integer.parseInt(matchElement.getElementsByTagName("PossessionFirstHalfHome").item(0).getTextContent()));
            matchDetails.setPossession2(Integer.parseInt(matchElement.getElementsByTagName("PossessionSecondHalfHome").item(0).getTextContent()));
            Element awayTeamElement = (Element) matchElement.getElementsByTagName("AwayTeam").item(0);
            matchDetails.setOpponentDressUri(awayTeamElement.getElementsByTagName("DressURI").item(0).getTextContent());
            matchDetails.setOpponentFormation(awayTeamElement.getElementsByTagName("Formation").item(0).getTextContent());
            matchDetails.setOpponentTacticType(Integer.parseInt(awayTeamElement.getElementsByTagName("TacticType").item(0).getTextContent()));
            matchDetails.setOpponentTacticSkill(Integer.parseInt(awayTeamElement.getElementsByTagName("TacticSkill").item(0).getTextContent()));
            matchDetails.setOpponentRatingM(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidfield").item(0).getTextContent()));
            matchDetails.setOpponentRatingRD(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingRightDef").item(0).getTextContent()));
            matchDetails.setOpponentRatingCD(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidDef").item(0).getTextContent()));
            matchDetails.setOpponentRatingLD(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingLeftDef").item(0).getTextContent()));
            matchDetails.setOpponentRatingRA(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingRightAtt").item(0).getTextContent()));
            matchDetails.setOpponentRatingCA(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidAtt").item(0).getTextContent()));
            matchDetails.setOpponentRatingLA(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingLeftAtt").item(0).getTextContent()));
            matchDetails.setOpponentRatingISPD(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingIndirectSetPiecesDef").item(0).getTextContent()));
            matchDetails.setOpponentRatingISPA(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingIndirectSetPiecesAtt").item(0).getTextContent()));
            matchDetails.setOpponentPossession1(Integer.parseInt(matchElement.getElementsByTagName("PossessionFirstHalfAway").item(0).getTextContent()));
            matchDetails.setOpponentPossession2(Integer.parseInt(matchElement.getElementsByTagName("PossessionSecondHalfAway").item(0).getTextContent()));
        } else {
            Element awayTeamElement = (Element) matchElement.getElementsByTagName("AwayTeam").item(0);
            matchDetails.setDressUri(awayTeamElement.getElementsByTagName("DressURI").item(0).getTextContent());
            matchDetails.setFormation(awayTeamElement.getElementsByTagName("Formation").item(0).getTextContent());
            matchDetails.setTacticType(Integer.parseInt(awayTeamElement.getElementsByTagName("TacticType").item(0).getTextContent()));
            matchDetails.setTacticSkill(Integer.parseInt(awayTeamElement.getElementsByTagName("TacticSkill").item(0).getTextContent()));
            matchDetails.setTeamAttitude(Integer.parseInt(awayTeamElement.getElementsByTagName("TeamAttitude").item(0).getTextContent()));
            matchDetails.setRatingM(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidfield").item(0).getTextContent()));
            matchDetails.setRatingRD(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingRightDef").item(0).getTextContent()));
            matchDetails.setRatingCD(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidDef").item(0).getTextContent()));
            matchDetails.setRatingLD(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingLeftDef").item(0).getTextContent()));
            matchDetails.setRatingRA(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingRightAtt").item(0).getTextContent()));
            matchDetails.setRatingCA(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidAtt").item(0).getTextContent()));
            matchDetails.setRatingLA(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingLeftAtt").item(0).getTextContent()));
            matchDetails.setRatingISPD(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingIndirectSetPiecesDef").item(0).getTextContent()));
            matchDetails.setRatingISPA(Integer.parseInt(awayTeamElement.getElementsByTagName("RatingIndirectSetPiecesAtt").item(0).getTextContent()));
            matchDetails.setPossession1(Integer.parseInt(matchElement.getElementsByTagName("PossessionFirstHalfAway").item(0).getTextContent()));
            matchDetails.setPossession2(Integer.parseInt(matchElement.getElementsByTagName("PossessionSecondHalfAway").item(0).getTextContent()));
            Element homeTeamElement = (Element) matchElement.getElementsByTagName("HomeTeam").item(0);
            matchDetails.setOpponentDressUri(homeTeamElement.getElementsByTagName("DressURI").item(0).getTextContent());
            matchDetails.setOpponentFormation(homeTeamElement.getElementsByTagName("Formation").item(0).getTextContent());
            matchDetails.setOpponentTacticType(Integer.parseInt(homeTeamElement.getElementsByTagName("TacticType").item(0).getTextContent()));
            matchDetails.setOpponentTacticSkill(Integer.parseInt(homeTeamElement.getElementsByTagName("TacticSkill").item(0).getTextContent()));
            matchDetails.setOpponentRatingM(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidfield").item(0).getTextContent()));
            matchDetails.setOpponentRatingRD(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingRightDef").item(0).getTextContent()));
            matchDetails.setOpponentRatingCD(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidDef").item(0).getTextContent()));
            matchDetails.setOpponentRatingLD(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingLeftDef").item(0).getTextContent()));
            matchDetails.setOpponentRatingRA(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingRightAtt").item(0).getTextContent()));
            matchDetails.setOpponentRatingCA(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidAtt").item(0).getTextContent()));
            matchDetails.setOpponentRatingLA(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingLeftAtt").item(0).getTextContent()));
            matchDetails.setOpponentRatingISPD(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingIndirectSetPiecesDef").item(0).getTextContent()));
            matchDetails.setOpponentRatingISPA(Integer.parseInt(homeTeamElement.getElementsByTagName("RatingIndirectSetPiecesAtt").item(0).getTextContent()));
            matchDetails.setOpponentPossession1(Integer.parseInt(matchElement.getElementsByTagName("PossessionFirstHalfHome").item(0).getTextContent()));
            matchDetails.setOpponentPossession2(Integer.parseInt(matchElement.getElementsByTagName("PossessionSecondHalfHome").item(0).getTextContent()));
        }
        return matchDetails;
    }
    
    public static ArrayList<Referee> getRefereesFromHt(String xmlString, Match match)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Referee> referees = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element r0Element = (Element) document.getElementsByTagName("Referee").item(0);
        Element r1Element = (Element) document.getElementsByTagName("RefereeAssistant1").item(0);
        Element r2Element = (Element) document.getElementsByTagName("RefereeAssistant2").item(0);
        Referee referee0 = new Referee();
        Referee referee1 = new Referee();
        Referee referee2 = new Referee();
        referee0.setMatchId(match.getMatchId());
        referee0.setTeamId(match.getTeamId());
        referee0.setRefereeRole(0);
        referee0.setRefereeId(Integer.parseInt(r0Element.getElementsByTagName("RefereeId").item(0).getTextContent()));
        referee0.setRefereeName(r0Element.getElementsByTagName("RefereeName").item(0).getTextContent());
        referee0.setRefereeCountryId(Integer.parseInt(r0Element.getElementsByTagName("RefereeCountryId").item(0).getTextContent()));
        referee0.setRefereeCountryName(r0Element.getElementsByTagName("RefereeCountryName").item(0).getTextContent());
        referee0.setRefereeTeamId(Integer.parseInt(r0Element.getElementsByTagName("RefereeTeamId").item(0).getTextContent()));
        referee0.setRefereeTeamName(r0Element.getElementsByTagName("RefereeTeamname").item(0).getTextContent());
        referee1.setMatchId(match.getMatchId());
        referee1.setTeamId(match.getTeamId());
        referee1.setRefereeRole(1);
        referee1.setRefereeId(Integer.parseInt(r1Element.getElementsByTagName("RefereeId").item(0).getTextContent()));
        referee1.setRefereeName(r1Element.getElementsByTagName("RefereeName").item(0).getTextContent());
        referee1.setRefereeCountryId(Integer.parseInt(r1Element.getElementsByTagName("RefereeCountryId").item(0).getTextContent()));
        referee1.setRefereeCountryName(r1Element.getElementsByTagName("RefereeCountryName").item(0).getTextContent());
        referee1.setRefereeTeamId(Integer.parseInt(r1Element.getElementsByTagName("RefereeTeamId").item(0).getTextContent()));
        referee1.setRefereeTeamName(r1Element.getElementsByTagName("RefereeTeamname").item(0).getTextContent());
        referee2.setMatchId(match.getMatchId());
        referee2.setTeamId(match.getTeamId());
        referee2.setRefereeRole(2);
        referee2.setRefereeId(Integer.parseInt(r2Element.getElementsByTagName("RefereeId").item(0).getTextContent()));
        referee2.setRefereeName(r2Element.getElementsByTagName("RefereeName").item(0).getTextContent());
        referee2.setRefereeCountryId(Integer.parseInt(r2Element.getElementsByTagName("RefereeCountryId").item(0).getTextContent()));
        referee2.setRefereeCountryName(r2Element.getElementsByTagName("RefereeCountryName").item(0).getTextContent());
        referee2.setRefereeTeamId(Integer.parseInt(r2Element.getElementsByTagName("RefereeTeamId").item(0).getTextContent()));
        referee2.setRefereeTeamName(r2Element.getElementsByTagName("RefereeTeamname").item(0).getTextContent());
        referees.add(referee0);
        referees.add(referee1);
        referees.add(referee2);
        return referees;
    }
    
    public static ArrayList<Goal> getGoalsFromHt(String xmlString, Match match)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Goal> goals = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element goalsElement = (Element) document.getElementsByTagName("Scorers").item(0);
        NodeList goalNodes = goalsElement.getElementsByTagName("Goal");
        if (goalNodes.getLength() > 0) {
            for (int goalCnt = 0; goalCnt < goalNodes.getLength(); goalCnt++) {
                Element goalElement = (Element) goalNodes.item(goalCnt);
                Goal goal = new Goal();
                goal.setMatchId(match.getMatchId());
                goal.setTeamId(match.getTeamId());
                goal.setGoalIndex(Integer.parseInt(goalElement.getAttribute("Index")));
                goal.setGoalPlayerId(Integer.parseInt(goalElement.getElementsByTagName("ScorerPlayerID").item(0).getTextContent()));
                goal.setGoalPlayerName(goalElement.getElementsByTagName("ScorerPlayerName").item(0).getTextContent());
                goal.setGoalTeamId(Integer.parseInt(goalElement.getElementsByTagName("ScorerTeamID").item(0).getTextContent()));
                if (match.getVenue() == "home") {
                    goal.setGoalGoalsFor(Integer.parseInt(goalElement.getElementsByTagName("ScorerHomeGoals").item(0).getTextContent()));
                    goal.setGoalGoalsAgainst(Integer.parseInt(goalElement.getElementsByTagName("ScorerAwayGoals").item(0).getTextContent()));
                } else {
                    goal.setGoalGoalsFor(Integer.parseInt(goalElement.getElementsByTagName("ScorerAwayGoals").item(0).getTextContent()));
                    goal.setGoalGoalsAgainst(Integer.parseInt(goalElement.getElementsByTagName("ScorerHomeGoals").item(0).getTextContent()));
                }
                goal.setGoalMinute(Integer.parseInt(goalElement.getElementsByTagName("ScorerMinute").item(0).getTextContent()));
                goals.add(goal);
            }
        }
        return goals;
    }
    
    public static ArrayList<Booking> getBookingsFromHt(String xmlString, Match match)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Booking> bookings = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element bookingsElement = (Element) document.getElementsByTagName("Bookings").item(0);
        NodeList bookingNodes = bookingsElement.getElementsByTagName("Booking");
        if (bookingNodes.getLength() > 0) {
            for (int bookingCnt = 0; bookingCnt < bookingNodes.getLength(); bookingCnt++) {
                Element bookingElement = (Element) bookingNodes.item(bookingCnt);
                Booking booking = new Booking();
                booking.setMatchId(match.getMatchId());
                booking.setTeamId(match.getTeamId());
                booking.setBookingIndex(Integer.parseInt(bookingElement.getAttribute("Index")));
                booking.setBookingPlayerId(Integer.parseInt(bookingElement.getElementsByTagName("BookingPlayerID").item(0).getTextContent()));
                booking.setBookingPlayerName(bookingElement.getElementsByTagName("BookingPlayerName").item(0).getTextContent());
                booking.setBookingTeamId(Integer.parseInt(bookingElement.getElementsByTagName("BookingTeamID").item(0).getTextContent()));
                booking.setBookingType(Integer.parseInt(bookingElement.getElementsByTagName("BookingType").item(0).getTextContent()));
                booking.setBookingMinute(Integer.parseInt(bookingElement.getElementsByTagName("BookingMinute").item(0).getTextContent()));
                bookings.add(booking);
            }
        }
        return bookings;
    }
    
    public static ArrayList<Injury> getInjuriesFromHt(String xmlString, Match match)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Injury> injuries = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element injuriesElement = (Element) document.getElementsByTagName("Injuries").item(0);
        NodeList injuryNodes = injuriesElement.getElementsByTagName("Injury");
        if (injuryNodes.getLength() > 0) {
            for (int injuryCnt = 0; injuryCnt < injuryNodes.getLength(); injuryCnt++) {
                Element injuryElement = (Element) injuryNodes.item(injuryCnt);
                Injury injury = new Injury();
                injury.setMatchId(match.getMatchId());
                injury.setTeamId(match.getTeamId());
                injury.setInjuryIndex(Integer.parseInt(injuryElement.getAttribute("Index")));
                injury.setInjuryPlayerId(Integer.parseInt(injuryElement.getElementsByTagName("InjuryPlayerID").item(0).getTextContent()));
                injury.setInjuryPlayerName(injuryElement.getElementsByTagName("InjuryPlayerName").item(0).getTextContent());
                injury.setInjuryTeamId(Integer.parseInt(injuryElement.getElementsByTagName("InjuryTeamID").item(0).getTextContent()));
                injury.setInjuryType(Integer.parseInt(injuryElement.getElementsByTagName("InjuryType").item(0).getTextContent()));
                injury.setInjuryMinute(Integer.parseInt(injuryElement.getElementsByTagName("InjuryMinute").item(0).getTextContent()));
                injuries.add(injury);
            }
        }
        return injuries;
    }
    
    public static ArrayList<Event> getEventsFromHt(String xmlString, Match match)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Event> events = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element eventsElement = (Element) document.getElementsByTagName("EventList").item(0);
        NodeList eventNodes = eventsElement.getElementsByTagName("Event");
        if (eventNodes.getLength() > 0) {
            for (int eventCnt = 0; eventCnt < eventNodes.getLength(); eventCnt++) {
                Element eventElement = (Element) eventNodes.item(eventCnt);
                Event event = new Event();
                event.setMatchId(match.getMatchId());
                event.setTeamId(match.getTeamId());
                event.setEventIndex(Integer.parseInt(eventElement.getAttribute("Index")));
                event.setEventMinute(Integer.parseInt(eventElement.getElementsByTagName("Minute").item(0).getTextContent()));
                event.setEventType(Integer.parseInt(eventElement.getElementsByTagName("EventTypeID").item(0).getTextContent()));
                event.setEventVariation(Integer.parseInt(eventElement.getElementsByTagName("EventVariation").item(0).getTextContent()));
                event.setEventSubjectTeamId(Integer.parseInt(eventElement.getElementsByTagName("SubjectTeamID").item(0).getTextContent()));
                event.setEventSubjectPlayerId(Integer.parseInt(eventElement.getElementsByTagName("SubjectPlayerID").item(0).getTextContent()));
                event.setEventObjectPlayerId(Integer.parseInt(eventElement.getElementsByTagName("ObjectPlayerID").item(0).getTextContent()));
                event.setEventText(eventElement.getElementsByTagName("EventText").item(0).getTextContent());
                events.add(event);
            }
        }
        return events;
    }
    
    public static ArrayList<StartingLineup> getStartingLineupFromHt(String xmlString, Match match)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<StartingLineup> startingLineups = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element startingLineupElement = (Element) document.getElementsByTagName("StartingLineup").item(0);
        NodeList playerNodes = startingLineupElement.getElementsByTagName("Player");
        if (playerNodes.getLength() > 0) {
            for (int playerCnt = 0; playerCnt < playerNodes.getLength(); playerCnt++) {
                Element playerElement = (Element) playerNodes.item(playerCnt);
                StartingLineup startingLineup = new StartingLineup();
                startingLineup.setMatchId(match.getMatchId());
                startingLineup.setTeamId(match.getTeamId());
                startingLineup.setPlayerId(Integer.parseInt(playerElement.getElementsByTagName("PlayerID").item(0).getTextContent()));
                startingLineup.setRole(Integer.parseInt(playerElement.getElementsByTagName("RoleID").item(0).getTextContent()));
                startingLineup.setFirstName(playerElement.getElementsByTagName("FirstName").item(0).getTextContent());
                startingLineup.setLastName(playerElement.getElementsByTagName("LastName").item(0).getTextContent());
                startingLineup.setNickName(playerElement.getElementsByTagName("NickName").item(0).getTextContent());
                startingLineup.setBehaviour(Integer.parseInt(playerElement.getElementsByTagName("Behaviour").item(0).getTextContent()));
                startingLineups.add(startingLineup);
            }
        }
        return startingLineups;
    }
    
    public static ArrayList<Substitution> getSubstitutionsFromHt(String xmlString, Match match)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Substitution> substitutions = new ArrayList<>();
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element substitutionsElement = (Element) document.getElementsByTagName("Substitutions").item(0);
        NodeList substitutionNodes = substitutionsElement.getElementsByTagName("Substitution");
        if (substitutionNodes.getLength() > 0) {
            for (int substitutionCnt = 0; substitutionCnt < substitutionNodes.getLength(); substitutionCnt++) {
                Element substitutionElement = (Element) substitutionNodes.item(substitutionCnt);
                Substitution substitution = new Substitution();
                substitution.setMatchId(match.getMatchId());
                substitution.setTeamId(match.getTeamId());
                substitution.setSubjectPlayerId(Integer.parseInt(substitutionElement.getElementsByTagName("SubjectPlayerID").item(0).getTextContent()));
                substitution.setObjectPlayerId(Integer.parseInt(substitutionElement.getElementsByTagName("ObjectPlayerID").item(0).getTextContent()));
                substitution.setOrderType(Integer.parseInt(substitutionElement.getElementsByTagName("OrderType").item(0).getTextContent()));
                substitution.setNewPosition(Integer.parseInt(substitutionElement.getElementsByTagName("NewPositionId").item(0).getTextContent()));
                substitution.setBehaviour(Integer.parseInt(substitutionElement.getElementsByTagName("NewPositionBehaviour").item(0).getTextContent()));
                substitution.setMinute(Integer.parseInt(substitutionElement.getElementsByTagName("MatchMinute").item(0).getTextContent()));
                substitutions.add(substitution);
            }
        }
        return substitutions;
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
