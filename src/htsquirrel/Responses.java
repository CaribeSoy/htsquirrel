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
import htsquirrel.game.Booking;
import htsquirrel.game.Cup;
import htsquirrel.game.Goal;
import htsquirrel.game.Injury;
import htsquirrel.game.Match;
import htsquirrel.game.MatchDetails;
import htsquirrel.game.Referee;
import htsquirrel.game.Team;
import htsquirrel.game.User;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
                    int awayTeamId = Integer.parseInt(matchElement.getElementsByTagName("AwayTeamID").item(0).getTextContent());
                    String awayTeamName = matchElement.getElementsByTagName("AwayTeamName").item(0).getTextContent();
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

    public static ArrayList<Cup> getCups(OAuthService oAuthService,
            Token accessToken, Team team)
            throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Cup> cups = new ArrayList<>();
        String xmlString = getResponse(oAuthService, accessToken,
                "worlddetails&version=1.6&leagueID=" + team.getLeagueId());
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element cupsElement = (Element) document.getElementsByTagName("Cups").item(0);
        NodeList cupNodes = cupsElement.getElementsByTagName("Cup");
        if (cupNodes.getLength() > 0) {
            for (int cupCnt = 0; cupCnt < cupNodes.getLength(); cupCnt++) {
                Element cupElement = (Element) cupNodes.item(cupCnt);
                int cupId = Integer.parseInt(cupElement.getElementsByTagName("CupID").item(0).getTextContent());
                String cupName = cupElement.getElementsByTagName("CupName").item(0).getTextContent();
                int cupLeagueLevel = Integer.parseInt(cupElement.getElementsByTagName("CupLeagueLevel").item(0).getTextContent());
                int cupLevel = Integer.parseInt(cupElement.getElementsByTagName("CupLevel").item(0).getTextContent());
                int cupLevelIndex = Integer.parseInt(cupElement.getElementsByTagName("CupLevelIndex").item(0).getTextContent());
                Cup cup = new Cup(team.getTeamId(), cupId, cupName,
                        cupLeagueLevel, cupLevel, cupLevelIndex);
                cups.add(cup);
            }
        }
        return cups;
    }

    public static MatchDetails getMatchDetails(String xmlString, Match match)
            throws ParserConfigurationException, SAXException, IOException {
        Document document = xmlStringToDoc(xmlString);
        document.getDocumentElement().normalize();
        Element matchElement = (Element) document.getElementsByTagName("Match").item(0);
        long matchId = match.getMatchId();
        int teamId = match.getTeamId();
        String teamName = match.getTeamName();
        int opponentTeamId = match.getOpponentTeamId();
        String opponentTeamName = match.getOpponentTeamName();
        int goalsFor = match.getGoalsFor();
        int goalsAgainst = match.getGoalsAgainst();
        int matchType = match.getMatchType();
        int matchContextId = match.getMatchContextId();
        int cupLevel = match.getCupLevel();
        int cupLevelIndex = match.getCupLevelIndex();
        int season = match.getSeason();
        Timestamp matchDate = match.getMatchDate();
        Timestamp finishedDate = Timestamp.valueOf(matchElement.getElementsByTagName("FinishedDate").item(0).getTextContent());
        String venue = match.getVenue();
        int arenaId = Integer.parseInt(matchElement.getElementsByTagName("ArenaID").item(0).getTextContent());
        String arenaName = matchElement.getElementsByTagName("ArenaName").item(0).getTextContent();
        int soldTotal = Integer.parseInt(matchElement.getElementsByTagName("SoldTotal").item(0).getTextContent());
        int soldTerraces = 0;
        int soldBasic = 0;
        int soldRoof = 0;
        int soldVip = 0;
        int weatherId = Integer.parseInt(matchElement.getElementsByTagName("WeatherID").item(0).getTextContent());
        String dressUri;
        String formation;
        int tacticType;
        int tacticSkill;
        int teamAttitude;
        int ratingM;
        int ratingRD;
        int ratingCD;
        int ratingLD;
        int ratingRA;
        int ratingCA;
        int ratingLA;
        int ratingISPD;
        int ratingISPA;
        int possession1;
        int possession2;
        String opponentDressUri;
        String opponentFormation;
        int opponentTacticType;
        int opponentTacticSkill;
        int opponentRatingM;
        int opponentRatingRD;
        int opponentRatingCD;
        int opponentRatingLD;
        int opponentRatingRA;
        int opponentRatingCA;
        int opponentRatingLA;
        int opponentRatingISPD;
        int opponentRatingISPA;
        int opponentPossession1;
        int opponentPossession2;
        int homeTeamId = Integer.parseInt(matchElement.getElementsByTagName("HomeTeamID").item(0).getTextContent());
        if (homeTeamId == match.getTeamId()) {
            soldTerraces = Integer.parseInt(matchElement.getElementsByTagName("SoldTerraces").item(0).getTextContent());
            soldBasic = Integer.parseInt(matchElement.getElementsByTagName("SoldBasic").item(0).getTextContent());
            soldRoof = Integer.parseInt(matchElement.getElementsByTagName("SoldRoof").item(0).getTextContent());
            soldVip = Integer.parseInt(matchElement.getElementsByTagName("SoldVIP").item(0).getTextContent());
            Element homeTeamElement = (Element) matchElement.getElementsByTagName("HomeTeam").item(0);
            dressUri = homeTeamElement.getElementsByTagName("DressURI").item(0).getTextContent();
            formation = homeTeamElement.getElementsByTagName("Formation").item(0).getTextContent();
            tacticType = Integer.parseInt(homeTeamElement.getElementsByTagName("TacticType").item(0).getTextContent());
            tacticSkill = Integer.parseInt(homeTeamElement.getElementsByTagName("TacticSkill").item(0).getTextContent());
            teamAttitude = Integer.parseInt(homeTeamElement.getElementsByTagName("TeamAttitude").item(0).getTextContent());
            ratingM = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidfield").item(0).getTextContent());
            ratingRD = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingRightDef").item(0).getTextContent());
            ratingCD = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidDef").item(0).getTextContent());
            ratingLD = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingLeftDef").item(0).getTextContent());
            ratingRA = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingRightAtt").item(0).getTextContent());
            ratingCA = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidAtt").item(0).getTextContent());
            ratingLA = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingLeftAtt").item(0).getTextContent());
            ratingISPD = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingIndirectSetPiecesDef").item(0).getTextContent());
            ratingISPA = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingIndirectSetPiecesAtt").item(0).getTextContent());
            possession1 = Integer.parseInt(matchElement.getElementsByTagName("PossessionFirstHalfHome").item(0).getTextContent());
            possession2 = Integer.parseInt(matchElement.getElementsByTagName("PossessionSecondHalfHome").item(0).getTextContent());
            Element awayTeamElement = (Element) matchElement.getElementsByTagName("AwayTeam").item(0);
            opponentDressUri = awayTeamElement.getElementsByTagName("DressURI").item(0).getTextContent();
            opponentFormation = awayTeamElement.getElementsByTagName("Formation").item(0).getTextContent();
            opponentTacticType = Integer.parseInt(awayTeamElement.getElementsByTagName("TacticType").item(0).getTextContent());
            opponentTacticSkill = Integer.parseInt(awayTeamElement.getElementsByTagName("TacticSkill").item(0).getTextContent());
            opponentRatingM = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidfield").item(0).getTextContent());
            opponentRatingRD = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingRightDef").item(0).getTextContent());
            opponentRatingCD = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidDef").item(0).getTextContent());
            opponentRatingLD = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingLeftDef").item(0).getTextContent());
            opponentRatingRA = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingRightAtt").item(0).getTextContent());
            opponentRatingCA = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidAtt").item(0).getTextContent());
            opponentRatingLA = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingLeftAtt").item(0).getTextContent());
            opponentRatingISPD = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingIndirectSetPiecesDef").item(0).getTextContent());
            opponentRatingISPA = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingIndirectSetPiecesAtt").item(0).getTextContent());
            opponentPossession1 = Integer.parseInt(matchElement.getElementsByTagName("PossessionFirstHalfAway").item(0).getTextContent());
            opponentPossession2 = Integer.parseInt(matchElement.getElementsByTagName("PossessionSecondHalfAway").item(0).getTextContent());
        } else {
            Element awayTeamElement = (Element) matchElement.getElementsByTagName("AwayTeam").item(0);
            dressUri = awayTeamElement.getElementsByTagName("DressURI").item(0).getTextContent();
            formation = awayTeamElement.getElementsByTagName("Formation").item(0).getTextContent();
            tacticType = Integer.parseInt(awayTeamElement.getElementsByTagName("TacticType").item(0).getTextContent());
            tacticSkill = Integer.parseInt(awayTeamElement.getElementsByTagName("TacticSkill").item(0).getTextContent());
            teamAttitude = Integer.parseInt(awayTeamElement.getElementsByTagName("TeamAttitude").item(0).getTextContent());
            ratingM = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidfield").item(0).getTextContent());
            ratingRD = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingRightDef").item(0).getTextContent());
            ratingCD = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidDef").item(0).getTextContent());
            ratingLD = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingLeftDef").item(0).getTextContent());
            ratingRA = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingRightAtt").item(0).getTextContent());
            ratingCA = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingMidAtt").item(0).getTextContent());
            ratingLA = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingLeftAtt").item(0).getTextContent());
            ratingISPD = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingIndirectSetPiecesDef").item(0).getTextContent());
            ratingISPA = Integer.parseInt(awayTeamElement.getElementsByTagName("RatingIndirectSetPiecesAtt").item(0).getTextContent());
            possession1 = Integer.parseInt(matchElement.getElementsByTagName("PossessionFirstHalfAway").item(0).getTextContent());
            possession2 = Integer.parseInt(matchElement.getElementsByTagName("PossessionSecondHalfAway").item(0).getTextContent());
            Element homeTeamElement = (Element) matchElement.getElementsByTagName("HomeTeam").item(0);
            opponentDressUri = homeTeamElement.getElementsByTagName("DressURI").item(0).getTextContent();
            opponentFormation = homeTeamElement.getElementsByTagName("Formation").item(0).getTextContent();
            opponentTacticType = Integer.parseInt(homeTeamElement.getElementsByTagName("TacticType").item(0).getTextContent());
            opponentTacticSkill = Integer.parseInt(homeTeamElement.getElementsByTagName("TacticSkill").item(0).getTextContent());
            opponentRatingM = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidfield").item(0).getTextContent());
            opponentRatingRD = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingRightDef").item(0).getTextContent());
            opponentRatingCD = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidDef").item(0).getTextContent());
            opponentRatingLD = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingLeftDef").item(0).getTextContent());
            opponentRatingRA = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingRightAtt").item(0).getTextContent());
            opponentRatingCA = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingMidAtt").item(0).getTextContent());
            opponentRatingLA = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingLeftAtt").item(0).getTextContent());
            opponentRatingISPD = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingIndirectSetPiecesDef").item(0).getTextContent());
            opponentRatingISPA = Integer.parseInt(homeTeamElement.getElementsByTagName("RatingIndirectSetPiecesAtt").item(0).getTextContent());
            opponentPossession1 = Integer.parseInt(matchElement.getElementsByTagName("PossessionFirstHalfHome").item(0).getTextContent());
            opponentPossession2 = Integer.parseInt(matchElement.getElementsByTagName("PossessionSecondHalfHome").item(0).getTextContent());
        }
        MatchDetails matchDetails = new MatchDetails(matchId, teamId, teamName,
                opponentTeamId, opponentTeamName, goalsFor, goalsAgainst,
                matchType, matchContextId, cupLevel, cupLevelIndex, season,
                matchDate, finishedDate, venue, arenaId, arenaName, soldTotal,
                soldTerraces, soldBasic, soldRoof, soldVip, weatherId, dressUri,
                formation, tacticType, tacticSkill, teamAttitude, ratingM,
                ratingRD, ratingCD, ratingLD, ratingRA, ratingCA, ratingLA,
                ratingISPD, ratingISPA, possession1, possession2,
                opponentDressUri, opponentFormation, opponentTacticType,
                opponentTacticSkill, opponentRatingM, opponentRatingRD,
                opponentRatingCD, opponentRatingLD, opponentRatingRA,
                opponentRatingCA, opponentRatingLA, opponentRatingISPD,
                opponentRatingISPA, opponentPossession1, opponentPossession2);
        return matchDetails;
    }
    
    public static ArrayList<Referee> getReferees(String xmlString, Match match)
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
    
    public static ArrayList<Goal> getGoals(String xmlString, Match match)
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
    
    public static ArrayList<Booking> getBookings(String xmlString, Match match)
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
    
    public static ArrayList<Injury> getInjuries(String xmlString, Match match)
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

}
